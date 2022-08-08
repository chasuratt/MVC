package com.lab2.MVC.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer_cis")
public class CustomerCis {

    @Id // for generate value
    Integer cisId ;
    List<AddressCis> addressCisList;
    InvestmentLimitCis investmentLimitCis;
}
