package com.mimay.loans.service.impl;
import java.util.Optional;
import java.util.Random;

import com.mimay.loans.constant.LoansConstant;
import com.mimay.loans.entity.Loans;
import com.mimay.loans.exception.LoanAlreadyExistsException;
import com.mimay.loans.repository.LoansRepository;
import com.mimay.loans.service.ILoansService;

public class ILoansServiceImpl implements ILoansService{

    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
        if(optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException("Loan already registered with given mobile number " + mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    private Loans createNewLoan(String mobileNumber) {
        Loans newLoans = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoans.setLoanNumber(Long.toString(randomLoanNumber));
        newLoans.setMobileNumber(mobileNumber);
        newLoans.setLoanType(LoansConstant.HOME_LOAN);
        newLoans.setTotalLoan(LoansConstant.NEW_LOAN_LIMIT);
        newLoans.setAmountPaid(0);
        newLoans.setOutstandingAmount(LoansConstant.NEW_LOAN_LIMIT);

        return newLoans;
    }

}
