package com.mimay.loans.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString 
@AllArgsConstructor @NoArgsConstructor
public class Loans extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loadId;
    
    private String mobileNumber;

    private String loanNumber;
    
    private String loanType;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;
}
