package com.snowwolf.demojava8.mode.util.designmode.strategy.impl;

import com.snowwolf.demojava8.mode.util.designmode.strategy.PayStrategy;

/**
 * @author: topsnowwolf
 * @description: 银联支付
 * @date: Create in 2018/12/2 22:15
 * @modified by:
 * @versions：0.1.0
 */
public class UnionPay implements PayStrategy {
    @Override
    public boolean payMoney(String payMode) {
        return payMode.matches("Union");
    }
}
