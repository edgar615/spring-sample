package com.github.edgar615.spring.ds;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

//https://o7planning.org/en/10869/using-multiple-datasources-with-spring-boot-and-routingdatasource
public class CustomerRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return CustomerContextHolder.getCustomerType();
    }
}