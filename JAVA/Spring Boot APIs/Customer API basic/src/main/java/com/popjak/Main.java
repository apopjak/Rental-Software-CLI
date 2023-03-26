package com.popjak;

import com.popjak.customer.Customer;
import com.popjak.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication

public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            Customer andrej = new Customer("Andrej", "apop@gma.com", "25");
            Customer marek = new Customer( "Marek", "Marek@gma.com", "42");
            Customer jozef = new Customer( "Jozef", "asdasd@gma.com", "25");
            Customer peter = new Customer("Peter", "adsadfpop@gma.com", "18");
            Customer marek1 = new Customer( "Marek", "Madsdrek@gma.com", "55");
            Customer jozef2 = new Customer( "Jozef", "asdaadasd5sd@gma.com", "29");
            List<Customer> customers = List.of(andrej, marek, jozef, peter, marek1, jozef2);
            customerRepository.saveAll(customers);




    };
}}

