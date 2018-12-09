package com.snowwolf.demojava8.mode.util.designmode.strategy.impl;

import com.snowwolf.demojava8.mode.util.designmode.strategy.PayStrategy;

/**
 * @author: topsnowwolf
 * @description: 微信支付
 * @date: Create in 2018/12/2 22:13
 * @modified by:
 * @versions：0.1.0
 */
public class WeiChatPay implements PayStrategy {
    @Override
    public boolean payMoney(String payMode) {
        return payMode.matches("WEICHAT");
    }
}
