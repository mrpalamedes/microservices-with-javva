package com.mimay.accounts.dto;

import com.mimay.accounts.entity.Accounts;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomersDto {

    @NotEmpty(message = "Name cannot be a null or empty.")
    @Size(min = 5, max = 30, message = "Name length should be between 5 and 30 characters.")
    private String name;

    @NotEmpty(message = "Email cannot be a null or empty.")
    @Email(message = "Email address should be a valid format.")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits.")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
