package com.snowwolf.demojava8.mode.util.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/2 10:31
 * @modified by:
 * @versions：0.1.0
 */
public class ShopFilter {
    public static <T> List<T> shopFilter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T t: list){
            //这里就是按断言去执行，shopEo.getSaleroom() > 1000就返回true
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }
}
