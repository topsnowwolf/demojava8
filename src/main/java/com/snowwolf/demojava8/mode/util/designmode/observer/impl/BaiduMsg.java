package com.snowwolf.demojava8.mode.util.designmode.observer.impl;

import com.snowwolf.demojava8.mode.util.designmode.observer.Observer;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/9 18:19
 * @modified by:
 * @versions：0.1.0
 */
public class BaiduMsg implements Observer {
    @Override
    public void notify(String msg) {
        if("cheater".equals(msg)){
            System.out.println("baidu have cheater");
        }
    }
}
