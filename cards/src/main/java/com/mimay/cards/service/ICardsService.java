package com.mimay.cards.service;

import com.mimay.cards.dto.CardsDto;

public interface ICardsService {

    /*
     * 
     * @param mobileNumber - Mobile Number of the customer
     */
    void createCard(String mobileNumber);

    /**
     *
     * @param mobileNumber - Input mobile Number
     *  @return Card Details based on a given mobileNumber
     */
    CardsDto fetchCard(String mobileNumber);
}
