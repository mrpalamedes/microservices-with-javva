package com.mimay.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
@Data
public class AccountsDto {

    @NotEmpty(message = "Account number cannot be a null or empty.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits.")
    @Schema(
            description = "Account Number", example = "3454433243"
    )
    private Long accountNumber;

    @Schema(
            description = "Account Type", example = "Savings, Credit"
    )
    @NotEmpty(message = "Account type cannot be a null or empty.")
    private String accountType;

    @Schema(
            description = "Branch Address", example = "Komplek Senayan Residence"
    )
    @NotEmpty(message = "Branch address cannot be a null or empty.")
    private String branchAddress;
}