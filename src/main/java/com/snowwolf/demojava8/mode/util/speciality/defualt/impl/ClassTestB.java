package com.snowwolf.demojava8.mode.util.speciality.defualt.impl;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/10 21:00
 * @modified by:
 * @versions：0.1.0
 */
public interface ClassTestB extends ClassTestA {
    @Override
    default void getMsg() {
        System.out.println("coming B");
    }
}
