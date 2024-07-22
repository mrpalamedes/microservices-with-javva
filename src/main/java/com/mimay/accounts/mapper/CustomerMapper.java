package com.mimay.accounts.mapper;

import com.mimay.accounts.dto.CustomersDto;
import com.mimay.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomersDto mapToCustomersDto(Customer customer, CustomersDto customersDto){
        customersDto.setName(customer.getName());
        customersDto.setEmail(customer.getEmail());
        customersDto.setMobileNumber(customer.getMobileNumber());
        return customersDto;
    }

    public static Customer mapToCustomers(CustomersDto customersDto, Customer customer){
        customer.setName(customersDto.getName());
        customer.setEmail(customersDto.getEmail());
        customer.setMobileNumber(customersDto.getMobileNumber());
        return customer;
    }
}
