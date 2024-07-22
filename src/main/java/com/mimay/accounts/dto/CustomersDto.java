package com.mimay.accounts.dto;

import com.mimay.accounts.entity.Accounts;
import lombok.Data;

@Data
public class CustomersDto {

    private String name;

    private String email;

    private String mobileNumber;

    private AccountsDto accountsDto;
}
