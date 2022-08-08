package com.lab2.MVC.repository;

import com.lab2.MVC.entity.CustomerProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerProfileRepository extends MongoRepository <CustomerProfile,String> {

    // by ID
    @Query("{ 'customerId' : ?0 }")
    public Optional<CustomerProfile> findCustomerProfileById(String id);








}
