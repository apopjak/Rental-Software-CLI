package com.popjak.CliWithTesting.car;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    boolean existsCarById(Integer Id);

    boolean existsCarByRegNum(String regNum);

    Car findCarById(Integer Id);

}
