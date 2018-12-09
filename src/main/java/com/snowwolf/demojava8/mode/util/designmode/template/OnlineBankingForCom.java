package com.snowwolf.demojava8.mode.util.designmode.template;

import com.snowwolf.demojava8.mode.util.designmode.template.entity.Customer;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/9 16:18
 * @modified by:
 * @versions：0.1.0
 */
public abstract class OnlineBankingForCom {
    public void processCusttomer(int id){
        Customer c = new Customer(id);
        makeCustomerHappy(c);
    }
    protected abstract void makeCustomerHappy(Customer c);
}
