package com.lab2.MVC.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "address_cis")

public class AddressCis {
    private String addressName ;
    private String country ;
    private String zipCode ;

}
