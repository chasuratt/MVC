package com.lab2.MVC.controller;


import com.lab2.MVC.entity.CustomerProfile;
import com.lab2.MVC.entity.Message;
import com.lab2.MVC.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@RestController
public class CustomerProfileController {
    @Autowired
    CustomerProfileService customerProfileService ;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getCustomerProfileById/{customerId}")
    public Optional<CustomerProfile> getCustomerProfileById(@PathVariable String customerId){
        return customerProfileService.getCustomerProfileById(String.valueOf(customerId));
    }

    @GetMapping("/getCustomerProfileWithLimit/{limit}")
    public List<CustomerProfile> getCustomerProfileWithLimit(@PathVariable int limit){
        return customerProfileService.getCustomerProfileWithLimit(limit);
    }

    @GetMapping("/getRandomParagraphWithMounteBank")
    public String getRandomParagraphWithMounteBank(){
        return  restTemplate.getForObject(
                "http://localhost:4545"
                ,String.class);



    }



}
