package com.example.foodSer.services;

import com.example.foodSer.entity.Customer;
import com.example.foodSer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        log.info("Customer info" + customer);
        return customerRepository.save(customer);
    }
}
