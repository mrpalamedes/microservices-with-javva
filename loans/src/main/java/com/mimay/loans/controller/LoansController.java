package com.mimay.loans.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mimay.loans.constant.LoansConstant;
import com.mimay.loans.dto.LoansDto;
import com.mimay.loans.dto.ResponseDto;
import com.mimay.loans.service.ILoansService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor @Validated
public class LoansController {

    private ILoansService iLoansService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits.") String mobileNumber) {
        iLoansService.createLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(LoansConstant.STATUS_201, LoansConstant.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber) {
        LoansDto loansDto = iLoansService.fetchLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@Valid @RequestBody LoansDto loansDto) {
        boolean isUpdated = iLoansService.updateLoan(loansDto);
        if(isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoansConstant.STATUS_200, LoansConstant.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(LoansConstant.STATUS_417, LoansConstant.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(@RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber) {
        boolean isDeleted = iLoansService.deleteLoan(mobileNumber);
        if(isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoansConstant.STATUS_200, LoansConstant.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(LoansConstant.STATUS_417, LoansConstant.MESSAGE_417_DELETE));
        }
    }
}
