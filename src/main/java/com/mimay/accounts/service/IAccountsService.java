package com.mimay.accounts.service;

import com.mimay.accounts.dto.CustomersDto;

public interface IAccountsService {

  /**
   *
   * @param customersDto - CustomerDto Object
   */
    void createAccount(CustomersDto customersDto);

  /**
   *
   * @param mobileNumber - Input mobileNumber
   * @return Account details based on given mobileNumber
   */
    CustomersDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomersDto customersDto);
}
