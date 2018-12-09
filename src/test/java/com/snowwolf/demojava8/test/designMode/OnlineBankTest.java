package com.snowwolf.demojava8.test.designMode;

import com.snowwolf.demojava8.mode.util.designmode.template.OnlineBankingForCom;
import com.snowwolf.demojava8.mode.util.designmode.template.impl.OnlineBankingCom;
import com.snowwolf.demojava8.mode.util.designmode.template.impl.OnlineBankingLambda;
import org.junit.Test;

/**
 * @author: topsnowwolf
 * @description:模板方法
 * @date: Create in 2018/12/9 16:15
 * @modified by:
 * @versions：0.1.0
 */
public class OnlineBankTest {
    @Test
    public void testForLambda(){
        new OnlineBankingLambda().processCusttomer(1001, c-> System.out.println("hello"));
    }

    @Test
    public void testForCom(){
        new OnlineBankingCom().processCusttomer(123);
    }
}
