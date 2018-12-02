package com.snowwolf.demojava8.test.quicklook;

import com.snowwolf.demojava8.mode.eo.ShopEo;
import com.snowwolf.demojava8.mode.service.impl.ShopServiceImpl;
import com.snowwolf.demojava8.mode.util.function.ShopFilter;
import com.snowwolf.demojava8.mode.util.function.ShopForEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: topsnowwolf
 * @description: 函数接口的认识 常用的函数接口有一下：
 * Predicate,Consumer,Function,Suppliere,UnaryOperator,BinaryOperator,BiPredicate,Biconsumer,BiFunction
 * @date: Create in 2018/12/2 10:19
 * @modified by:
 * @versions：0.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FunctionTest {

    @Autowired
    private ShopServiceImpl shopService;

    /**
     * Predicate 断言
     * Predicate<T>接口定义了一个test的抽象方法，接收一个对象返回boolean。所有通常用于筛选过滤。例如filter方法的实现
     * 下面自己写一个例子：现在根据不同的需求筛选复合条件的店铺
     * 注意：它还有其他的方法：and,negate,or,isEqual。方法都很简单，一看就懂，就不多说了。
     */
    @Test
    public void PredicateTest(){
        List<ShopEo> shopEoList = ShopFilter.shopFilter(shopService.findAll(), shopEo -> shopEo.getSaleroom() > 1000);
    }

    /**
     * Consumer 消费者
     * Consumer<T>接口定义了一个accept的抽象方法，接收一个T没有返回。 使用场景：访问对象，并对对象进行操作（操作对象的属性）。例如forEach的实现。
     * 下面自己写一个列子：将shop全部改成在营业的。
     * 注意：它还有另外一个方法andThen，功能类型，不多说了。
     */
    @Test
    public void ConsumerTest(){
        ShopForEach.shopForEach(shopService.findAll(),shopEo -> shopEo.setStatus("1"));
    }

    @Test
    public void  FunctionTest(){

    }
}
