package com.popjak.CliWithTesting.BookedCars;

import com.popjak.CliWithTesting.car.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface BookedCarRepository extends JpaRepository<BookedCar,Integer> {

    boolean existsCarById(Integer Id);

    boolean existsCarByRegNum(String regNum);

    Car findCarById(Integer Id);

}
