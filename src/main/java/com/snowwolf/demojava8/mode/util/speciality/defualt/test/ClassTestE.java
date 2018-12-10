package com.snowwolf.demojava8.mode.util.speciality.defualt.test;

import com.snowwolf.demojava8.mode.util.speciality.defualt.impl.ClassTestA;
import com.snowwolf.demojava8.mode.util.speciality.defualt.impl.ClassTestB;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/10 22:11
 * @modified by:
 * @versions：0.1.0
 */
public class ClassTestE implements ClassA,ClassB {
    @Override
    public void msg() {
        ClassB.super.msg();
    }
}
