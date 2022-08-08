package com.lab2.MVC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProfileOnlyDto {
    String customerId ;
    String titleName ;
    String firstName ;
    String lastName ;
    Date birthDay ;
    LocalDate createdDateTime ;
}
