package com.popjak.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // THIS annotation handles HTTP requests
@RequestMapping("/api/v1/customer")
public class CustomerController { // BEAM

    // This class is taking care of html requests

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }


    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable("id") Integer id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        customerService.addCustomer(customerRegistrationRequest);
    }

    @DeleteMapping("/delete/{customerId}")
    public void deleteCustomerById(@PathVariable Integer customerId) {
        customerService.deleteCustomerById(customerId);
    }

    @PutMapping("/update/{customerId}")
    public void updateCustomer(@PathVariable Integer customerId,
                                   @RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        customerService.updateCustomerById(customerId,customerRegistrationRequest);
    }
}
