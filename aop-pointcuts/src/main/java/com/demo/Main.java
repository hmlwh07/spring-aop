package com.demo;

import com.demo.ds.CurrencyType;
import com.demo.service.AlterCurrencyService;
import com.demo.service.CurrencyService;
import com.demo.service.MyCurrencyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        CurrencyService currencyService = context.getBean(CurrencyService.class);
        AlterCurrencyService alterCurrencyService = context.getBean(AlterCurrencyService.class);
        MyCurrencyService myCurrencyService = context.getBean(MyCurrencyService.class);

        currencyService.changeCurrency(200,1.2);
        alterCurrencyService.changeCurrency(500,2.5);

        myCurrencyService.changeCurrency();
        myCurrencyService.changeCurrency(10008,2.6);
        myCurrencyService.currencyCountryName(CurrencyType.US);
        myCurrencyService.currencyLongName(CurrencyType.US);
        myCurrencyService.currencyLongName(CurrencyType.EURO);

        try {
            myCurrencyService.currencyCountryName(CurrencyType.EURO);
        } catch (IllegalArgumentException e){
            System.out.println("Exception caught!");
        }
    }
}
