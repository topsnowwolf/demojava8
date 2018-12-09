package com.snowwolf.demojava8.mode.util.designmode.observer.impl;

import com.snowwolf.demojava8.mode.util.designmode.observer.Observer;
import com.snowwolf.demojava8.mode.util.designmode.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/9 18:30
 * @modified by:
 * @versions：0.1.0
 */
public class User implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObserver(String msg) {
        observers.stream().forEach(observer -> observer.notify(msg));
    }
}
