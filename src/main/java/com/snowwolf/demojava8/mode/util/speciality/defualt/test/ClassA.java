package com.snowwolf.demojava8.mode.util.speciality.defualt.test;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/10 22:13
 * @modified by:
 * @versions：0.1.0
 */
public interface ClassA {
    default void msg(){
        System.out.println("hello A");
    }
}
