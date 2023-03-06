package com.demo.service;

import org.springframework.stereotype.Component;


public interface CurrencyService {

    int changeCurrency(int currency,double rate);
}
