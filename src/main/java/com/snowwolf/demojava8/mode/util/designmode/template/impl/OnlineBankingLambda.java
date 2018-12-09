package com.snowwolf.demojava8.mode.util.designmode.template.impl;

import com.snowwolf.demojava8.mode.util.designmode.template.entity.Customer;

import java.util.function.Consumer;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/9 16:25
 * @modified by:
 * @versions：0.1.0
 */
public class OnlineBankingLambda  {
    public void processCusttomer(int id, Consumer<Customer> makeCustomerHappy){
        Customer c = new Customer(id);
        makeCustomerHappy.accept(c);
    }
}
