package com.snowwolf.demojava8.test.simpleuse;

import com.snowwolf.demojava8.mode.eo.ShopEo;
import org.junit.Test;

import java.util.Optional;

/**
 * @author: topsnowwolf
 * @description:Optional对象的作用：
 * 主要用来处理空值。
 * 常用的方法有：empty,of,ofNullable,orElse,get,ifPresent,orElseThrow等。
 * @date: Create in 2018/12/11 8:00
 * @modified by:
 * @versions：0.1.0
 */
public class OptionalTest {
    /**
     * 创建一个为空的Optional对象
     */
    @Test
    public void emptyTest(){
        Optional<ShopEo> optional = Optional.empty();
        System.out.println(optional.get());//NoSuchElementException 异常
    }

    /**
     * 通过of创建一个Optional对象，of方法的入参不能是空值。
     */
    @Test
    public void ofTest(){
        ShopEo shopEo = new ShopEo();
        Optional<ShopEo> optional1 = Optional.of(shopEo);
        shopEo = null;
        Optional<ShopEo> optional = Optional.of(shopEo);//NullPointerException 异常
    }

    /**
     * ofNullable创建Optionl对象，入参可以是空
     */
    @Test
    public void ofNullable(){
        ShopEo shopEo = null;
        Optional<ShopEo> optional = Optional.ofNullable(shopEo);
    }

    /**
     * 获取Optional的值
     */
    @Test
    public void mapTest(){
        ShopEo shopEo = new ShopEo();
        shopEo.setShopName("super");
        Optional<ShopEo> optional1 = Optional.of(shopEo);
        Optional<String> s = optional1.map(ShopEo::getShopName);
        System.out.println(s.get());
        String shopName = optional1.get().getShopName();
        //flatMap的使用

    }
}

