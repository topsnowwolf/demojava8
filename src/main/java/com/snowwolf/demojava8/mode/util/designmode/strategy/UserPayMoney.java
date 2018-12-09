package com.snowwolf.demojava8.mode.util.designmode.strategy;

/**
 * @author: topsnowwolf
 * @description: 用户支付
 * @date: Create in 2018/12/2 22:18
 * @modified by:
 * @versions：0.1.0
 */
public class UserPayMoney {
    private final PayStrategy payStrategy;
    public UserPayMoney(PayStrategy payStrategy){
        this.payStrategy = payStrategy;
    }

    public boolean payMoney(String s){
        return payStrategy.payMoney(s);
    }
}
