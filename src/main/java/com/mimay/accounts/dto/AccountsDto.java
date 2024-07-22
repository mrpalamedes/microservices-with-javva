package com.mimay.accounts.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AccountsDto {

    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}
