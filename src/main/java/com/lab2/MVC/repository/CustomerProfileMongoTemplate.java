package com.lab2.MVC.repository;


import com.lab2.MVC.entity.CustomerProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerProfileMongoTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<CustomerProfile> getCustomerProfileOnlyWithLimit(int limit) {
        Query query = new Query(); // can't implement in Repository
        query.fields().exclude("customerCisList");
        query.limit(limit);
        return mongoTemplate.find(query, CustomerProfile.class);
    }

    public List<CustomerProfile> geCustomerProfileWithLimit(int limit) {
        Query query = new Query(); // can't implement in Repository
        query.limit(limit);
        return mongoTemplate.find(query, CustomerProfile.class);
    }
//    List<AddressCis> addressCisList;
//    InvestmentLimitCis investmentLimitCis;

    public List<CustomerProfile> getCustomerCisWithLimit(int limit) {
        Query query = new Query(); // can't implement in Repository
        query.fields().include("customerCisList.cisId");
        query.limit(limit);
        return mongoTemplate.find(query,CustomerProfile.class);
    }

    public List<CustomerProfile> getAddressCisWithLimit(int limit) {
        Query query = new Query(); // can't implement in Repository
        query.fields().include("customerCisList.addressCisList").include("customerCisList.cisId");
        query.limit(limit);
        return mongoTemplate.find(query,CustomerProfile.class);

    }

    public List<CustomerProfile> getInvestmentLimitCisWithLimit(int limit) {
        Query query = new Query(); // can't implement in Repository
        query.fields().include("customerCisList.cisId").include("customerCisList.investmentLimitCis");
        query.limit(limit);
        return mongoTemplate.find(query,CustomerProfile.class);

    }


//    public List<AddressCisDto> geCustomerAddressWithLimit(int limit) {
//        Query query = new Query(); // can't implement in Repository
//        query.fields();
//        return mongoTemplate.
//    }
//    size: { uom: 1 }



}
