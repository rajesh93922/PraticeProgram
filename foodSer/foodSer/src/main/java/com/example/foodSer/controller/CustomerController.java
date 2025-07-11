package com.example.foodSer.controller;

import com.example.foodSer.entity.Customer;
import com.example.foodSer.services.CustomerServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custmor")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServices.class);


    @Autowired
    private CustomerServices customerServices;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        logger.debug("inside CustomerController.addCustomer() method");
        logger.info("inside CustomerController.addCustomer() method");

        return new ResponseEntity<>(customerServices.addCustomer(customer), HttpStatus.CREATED);
    }
    

}
