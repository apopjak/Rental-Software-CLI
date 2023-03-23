package com.popjak.customer;

import com.popjak.exception.ResourceNotFound;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // service class, this is naming convention which says that
        // all service classes should have this annotation.
public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(@Qualifier("jpa") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.selectAllCustomers();
    }

    public Customer getCustomerById(Integer id) {

        return customerDAO.selectCustomerById(id)
                .orElseThrow(()-> new ResourceNotFound("yaya"));
    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        // check if customer is not in database already
        if (customerDAO.existsPersonWithEmail(customerRegistrationRequest.email())) {
            throw new DuplicateRequestException("test");
        }
        customerDAO.insertCustomer(new Customer(customerRegistrationRequest.name(),
                customerRegistrationRequest.email(), customerRegistrationRequest.age()));
    }

    public void deleteCustomerById(Integer customerId) {
        if (!customerDAO.existsPersonWithId(customerId)) {
            throw new ResourceNotFound("Takyto uzivatel nie je ");
        }
        customerDAO.deleteCustomerById(customerId);
    }

    public void updateCustomerById(Integer id, CustomerRegistrationRequest cxUpdate) {
        Customer customer = getCustomerById(id);

        customer.setName(cxUpdate.name());
        customer.setAge(cxUpdate.age());
        customer.setEmail(cxUpdate.email());

    }



}
