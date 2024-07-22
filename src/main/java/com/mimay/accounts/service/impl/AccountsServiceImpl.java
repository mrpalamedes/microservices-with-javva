package com.mimay.accounts.service.impl;

import com.mimay.accounts.constants.AccountsConstants;
import com.mimay.accounts.dto.AccountsDto;
import com.mimay.accounts.dto.CustomersDto;
import com.mimay.accounts.entity.Accounts;
import com.mimay.accounts.entity.Customer;
import com.mimay.accounts.exception.CustomerAlreadyExistsException;
import com.mimay.accounts.exception.ResourceNotFoundException;
import com.mimay.accounts.mapper.AccountsMapper;
import com.mimay.accounts.mapper.CustomerMapper;
import com.mimay.accounts.repository.AccountsRepository;
import com.mimay.accounts.repository.CustomerRepository;
import com.mimay.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomersDto customersDto) {
        Customer customer = CustomerMapper.mapToCustomers(customersDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customersDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already exists with given mobileNumber " + customersDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer){
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }

    @Override
    public CustomersDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomersDto customersDto = CustomerMapper.mapToCustomersDto(customer, new CustomersDto());
        customersDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
        return customersDto;
    }

    @Override
    public boolean updateAccount(CustomersDto customersDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customersDto.getAccountsDto();
        if(accountsDto != null){
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "customerId", customerId.toString())
            );
            CustomerMapper.mapToCustomers(customersDto, customer);
            customer = customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }
}
