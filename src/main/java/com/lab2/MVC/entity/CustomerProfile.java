package com.lab2.MVC.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer_profile")
public class CustomerProfile {

    @Id
    String customerId ;
    String titleName ;
    String firstName ;
    String lastName ;
    Date birthDay ;
    LocalDate createdDateTime ;
    List<CustomerCis> customerCisList;

}
