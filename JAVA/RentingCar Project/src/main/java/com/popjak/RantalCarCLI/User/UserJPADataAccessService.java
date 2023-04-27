package com.popjak.RantalCarCLI.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJPADataAccessService implements UserDAO{

    private final EntityManager entityManager;

    @Autowired
    public UserJPADataAccessService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void insertUserIntoDB(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> showAllUsers() {
        // QUERY FROM POJO!!!!
        String query = """
                FROM User
                ORDER BY Id
                """;

        TypedQuery<User> theQuery = entityManager.createQuery(query, User.class);
        return theQuery.getResultList();
    }

    @Override
    public User findUserById(Integer Id) {
        return null;
    }

    @Override
    public boolean existUserByEmail(String email) {
        String query = """
                FROM User
                WHERE email=:theData
                """;

        TypedQuery<User> theQuery = entityManager.createQuery(query, User.class);
        // PARAMETER
        theQuery.setParameter("theData", email);

        List<User> resultList = theQuery.getResultList();
        return resultList.size() > 0;
    }
}
