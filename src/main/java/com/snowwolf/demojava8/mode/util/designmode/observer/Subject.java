package com.snowwolf.demojava8.mode.util.designmode.observer;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/9 18:29
 * @modified by:
 * @versions：0.1.0
 */
public interface Subject {
    void registerObserver(Observer observer);
    void notifyObserver(String msg);
}
