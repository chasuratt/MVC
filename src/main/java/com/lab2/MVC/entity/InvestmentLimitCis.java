package com.lab2.MVC.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "investment_limit_cis")
public class InvestmentLimitCis {

    private BigDecimal overLimit;
    private String createdBy;
    private LocalDate createDate;

}
