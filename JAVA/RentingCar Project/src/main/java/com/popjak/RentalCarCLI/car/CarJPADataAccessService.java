package com.popjak.RentalCarCLI.car;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarJPADataAccessService implements CarDAO {

    private final EntityManager entityManager;

    @Autowired
    public CarJPADataAccessService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Car> showAllCars() {
        String query = """
                FROM Car
                ORDER BY Id
                """;
        TypedQuery<Car> theQuery = entityManager.createQuery(query,Car.class);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void insertToDB(Car car) {
        entityManager.persist(car);
    }

    @Override
    public boolean existById(Integer Id) {

        Car car = entityManager.find(Car.class,Id);
        return !car.getRegNum().isBlank();

    }

    @Override
    public boolean existByRegNum(String regNum) {
        String query = """
                FROM Car
                WHERE regNum=:theData
                """;

        TypedQuery<Car> theQuery = entityManager.createQuery(query, Car.class);
        theQuery.setParameter("theData", regNum);
        return theQuery.getResultList().size() > 0;
    }

    @Override
    @Transactional
    public void removeFromDB(Integer Id) {

        Car car = entityManager.find(Car.class,Id);
        entityManager.remove(car);
    }
}
