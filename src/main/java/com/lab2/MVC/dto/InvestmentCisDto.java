package com.lab2.MVC.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentCisDto {

    private BigDecimal overLimit;
    private String createdBy;
    private LocalDate createDate;

}
