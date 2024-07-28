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
   * @return menampilkan Account details berdasarkan dari input mobileNumber
   */
    CustomersDto fetchAccount(String mobileNumber);

  /**
   *
   * @param customersDto - CustomerDto Object
   * @return boolean menandakan update account berhasil atau tidak
   */
    boolean updateAccount(CustomersDto customersDto);

  /**
   *
   * @param mobileNumber - Input mobileNumber
   * @return boolean menandakan delete account berhasil atau tidak
   */
    boolean deleteAccount(String mobileNumber);
}
