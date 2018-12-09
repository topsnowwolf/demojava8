package com.snowwolf.demojava8.test.designMode;

import com.snowwolf.demojava8.mode.util.designmode.strategy.UserPayMoney;
import com.snowwolf.demojava8.mode.util.designmode.strategy.impl.ZhiFuBaoPay;
import org.junit.Test;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/2 22:26
 * @modified by:
 * @versions：0.1.0
 */
public class StrategyTest {
    @Test
    public void payTest(){
        //原始方式
        UserPayMoney ZFBPayMoney = new UserPayMoney(new ZhiFuBaoPay());
        ZFBPayMoney.payMoney("ZHIFUBAO");
        UserPayMoney WCPayMoney = new UserPayMoney(new ZhiFuBaoPay());
        WCPayMoney.payMoney("WEICHAT");
        UserPayMoney UNPayMoney = new UserPayMoney(new ZhiFuBaoPay());
        UNPayMoney.payMoney("UNION");

        //通过lamdba表达式
        new UserPayMoney(s->s.matches("ZHIFUBAO")).payMoney("ZHIFUBAO");

    }
}
