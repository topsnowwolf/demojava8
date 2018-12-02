package com.snowwolf.demojava8.mode.util.function;

import com.snowwolf.demojava8.mode.eo.ShopEo;

import java.util.function.Supplier;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/2 16:54
 * @modified by:
 * @versions：0.1.0
 */
public class ShopSupplier {
    public static <T> T shopSupplier(Supplier<T> supplier){
        return supplier.get();
    }
}
