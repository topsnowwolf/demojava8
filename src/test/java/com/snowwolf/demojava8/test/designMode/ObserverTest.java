package com.snowwolf.demojava8.test.designMode;

import com.snowwolf.demojava8.mode.util.designmode.observer.impl.*;
import org.junit.Test;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/12/9 19:19
 * @modified by:
 * @versions：0.1.0.
 */
public class ObserverTest {
    @Test
    public void ObserverCom(){
        User user = new User();
        user.registerObserver(new BaiduMsg());
        user.registerObserver(new XinlangMsg());
        user.registerObserver(new CCTVmsg());
        user.registerObserver(new SougouMsg());
        user.notifyObserver("nba");
    }

    @Test
    public void ObserverLamdba(){
        User user = new User();
        user.registerObserver(msg -> {
            if("nba".equals(msg)){
                System.out.println("xinlang nba!");
            }
        });
    }

}
