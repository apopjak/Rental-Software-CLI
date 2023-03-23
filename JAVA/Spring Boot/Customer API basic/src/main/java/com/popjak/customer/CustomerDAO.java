package com.popjak.customer;

import com.popjak.customer.Customer;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);

    // add user
    void insertCustomer(Customer customer);
    boolean existsPersonWithEmail(String email);

    // remove user
    boolean existsPersonWithId(Integer customerId);
    void deleteCustomerById(Integer customerId);

    // update user
    void updateCustomer(Customer updatedCustomer);

}
