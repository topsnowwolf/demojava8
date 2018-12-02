package com.snowwolf.demojava8.mode.util.function;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/2 15:00
 * @modified by:
 * @versions：0.1.0
 */
public class ShopForEach {
    public static <T> void shopForEach(List<T> list, Consumer<T> consumer){
        for(T t : list){
            consumer.accept(t);
        }
    }
}
