package com.snowwolf.demojava8.mode.util.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/2 15:25
 * @modified by:
 * @versions：0.1.0
 */
public class ShopMap {
    public static <T,R> List<R> shopMap(List<T> list,Function<T,R> function){
        List<R> result = new ArrayList<>();
        for(T t : list){
            result.add(function.apply(t));
        }
        return result;
    }
}
