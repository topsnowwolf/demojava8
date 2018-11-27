package com.snowwolf.demojava8.test;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/27 8:01
 * @modified by:
 * @versions：0.1.0
 */
public class Accumulator {
    public Long total = 0L;
    public void add(Long val){
        total+=val;
    }
}
