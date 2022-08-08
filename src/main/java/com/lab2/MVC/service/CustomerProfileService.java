package com.lab2.MVC.service;

import com.lab2.MVC.dto.AddressCisDto;
import com.lab2.MVC.dto.CustomerCisDto;
import com.lab2.MVC.dto.InvestmentCisDto;
import com.lab2.MVC.entity.AddressCis;
import com.lab2.MVC.entity.CustomerCis;
import com.lab2.MVC.entity.CustomerProfile;
import com.lab2.MVC.repository.CustomerProfileMongoTemplate;
import com.lab2.MVC.repository.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerProfileService {
    @Autowired
    private CustomerProfileRepository customerProfileRepository;
    @Autowired
    private CustomerProfileMongoTemplate customerProfileMongoTemplate;
    public Optional<CustomerProfile> getCustomerProfileById(String id){
        return customerProfileRepository.findCustomerProfileById(id);
    }

    public List<CustomerProfile> getCustomerProfileOnlyWithLimit(int limit){
        return customerProfileMongoTemplate.getCustomerProfileOnlyWithLimit(limit);
    }

    public List<CustomerProfile> getCustomerProfileWithLimit(int limit){
        return customerProfileMongoTemplate.geCustomerProfileWithLimit(limit);
    }

    public List<CustomerCisDto>getCustomerCisWithLimit(int limit){
        List<CustomerProfile> customerProfileList = customerProfileMongoTemplate.getCustomerCisWithLimit(limit);
        List<CustomerCisDto> customerCisDtoList = new ArrayList<>();
        for ( CustomerProfile customerProfile : customerProfileList) {
            for (CustomerCis customerCis: customerProfile.getCustomerCisList()) {
                CustomerCisDto customerCisDto = new CustomerCisDto();
                customerCisDto.setCustomer_id(customerProfile.getCustomerId());
                customerCisDto.setCisId(customerCis.getCisId());
                customerCisDtoList.add(customerCisDto);
            }
        }

        return customerCisDtoList;
    }


    public List<AddressCisDto> getAddressCisWithLimit(int limit){
        List<CustomerProfile> customerProfileList = customerProfileMongoTemplate.getAddressCisWithLimit(limit);
        List<AddressCisDto> addressCisDtoList = new ArrayList<>();
        for ( CustomerProfile customerProfile : customerProfileList) {
            for (CustomerCis customerCis: customerProfile.getCustomerCisList()) {
                for (AddressCis addressCis : customerCis.getAddressCisList()) {
                    AddressCisDto addressCisDto = new AddressCisDto();
                    addressCisDto.setAddressName(addressCis.getAddressName());
                    addressCisDto.setCountry(addressCis.getCountry());
                    addressCisDto.setZipCode(addressCis.getZipCode());
                    addressCisDtoList.add(addressCisDto);
                }
            }

        }

        return addressCisDtoList ;
    }


    public List<InvestmentCisDto> getInvestmentLimitCisWithLimit(int limit) {

        List<CustomerProfile> customerProfileList = customerProfileMongoTemplate.getInvestmentLimitCisWithLimit(limit);
        List<InvestmentCisDto> investmentCisDtoList = new ArrayList<>();
        for ( CustomerProfile customerProfile : customerProfileList) {
            for (CustomerCis customerCis: customerProfile.getCustomerCisList()) {
                InvestmentCisDto investmentCisDto = new InvestmentCisDto();
                investmentCisDto.setOverLimit(customerCis.getInvestmentLimitCis().getOverLimit());
                investmentCisDto.setCreateDate(customerCis.getInvestmentLimitCis().getCreateDate());
                investmentCisDto.setCreatedBy(customerCis.getInvestmentLimitCis().getCreatedBy());
                investmentCisDtoList.add(investmentCisDto);
            }
        }

        return investmentCisDtoList;

    }
//
//    public List<CustomerProfile> getInvestmentLimitCisOnly(int limit){
//        return customerProfileMongoTemplate.getCustomerProfileOnly(limit);
//    }


}
