package com.snowwolf.demojava8.mode.util.function;

import java.util.function.UnaryOperator;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/2 17:20
 * @modified by:
 * @versions：0.1.0
 */
public class ShopUnaryOperator {
    public static <T> T shopUnaryOperator(T t,UnaryOperator<T> unaryOperator){
        return unaryOperator.apply(t);
    }
}
