package com.snowwolf.demojava8.test.defualt;

import com.snowwolf.demojava8.mode.util.speciality.defualt.impl.ClassTestC;
import org.junit.Test;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/10 21:04
 * @modified by:
 * @versions：0.1.0
 */
public class DefaultTest {
    @Test
    public void test(){
        ClassTestC classTestC = new ClassTestC();
        classTestC.getMsg();
    }
}
