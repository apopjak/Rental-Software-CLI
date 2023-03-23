package com.popjak.customer;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    /**
     * you have to use generics to tell JPARepository which entity it should manage
     AND what is data type for customerID...primary key...it is iInteget in this case */

    boolean existsCustomerByEmail(String email);
    boolean existsCustomerById(Integer id);


}
