package com.snowwolf.demojava8.mode.util.designmode.observer.impl;

import com.snowwolf.demojava8.mode.util.designmode.observer.Observer;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/9 18:21
 * @modified by:
 * @versions：0.1.0
 */
public class XinlangMsg implements Observer {
    @Override
    public void notify(String msg) {
        if("NBA".equals(msg)){
            System.out.println("xinlang nba");
        }
    }
}
