package com.snowwolf.demojava8.mode.util.designmode.strategy;

/**
 * @author: topsnowwolf
 * @description: 订单支付策略
 * @date: Create in 2018/12/2 22:07
 * @modified by:
 * @versions：0.1.0
 */
public interface PayStrategy {
    boolean payMoney(String payMode);
}
