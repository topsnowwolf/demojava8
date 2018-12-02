package com.snowwolf.demojava8.test.quicklook;

import com.snowwolf.demojava8.mode.eo.ShopEo;
import com.snowwolf.demojava8.mode.service.impl.ShopServiceImpl;
import com.snowwolf.demojava8.mode.util.function.ShopFilter;
import com.snowwolf.demojava8.mode.util.function.ShopForEach;
import com.snowwolf.demojava8.mode.util.function.ShopSupplier;
import com.snowwolf.demojava8.mode.util.function.ShopUnaryOperator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Spliterator;

/**
 * @author: topsnowwolf
 * @description: 函数接口的认识 常用的函数接口有一下：
 * Predicate,Consumer,Function,Suppliere,UnaryOperator,BinaryOperator
 * BiPredicate,Biconsumer,BiFunction（这三个接口就不多介绍了）
 * BiPredicate<L,R>  (L,R)->boolean
 * BiConsumer<T,U>   (T,U)->void
 * BiFunction<T,U,R> (T,U)->R
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
     * Consumer<T>接口定义了一个accept的抽象方法，接收一个T没有返回。 使用场景：访问对象，并对对象进行操作（操作对象的属性）。例如forEach方法的实现。
     * 下面自己写一个列子：将shop全部改成在营业的。
     * 注意：它还有另外一个方法andThen，功能类型，不多说了。
     */
    @Test
    public void ConsumerTest(){
        ShopForEach.shopForEach(shopService.findAll(),shopEo -> shopEo.setStatus("1"));
    }

    /**
     * Function 函数/功能
     * Function<T,R>接口定义了一个apply的方法，接收T对象返回R对象。例如map方法的实现。
     * 注意：它的其他方法都是基于apply方法实现的（除了identity），compose，andThen就不多说了。
     */
    @Test
    public void  FunctionTest(){
        shopService.findAll();
    }

    /**
     * Supplier 供应商
     * Supplier<T> 接口定义了一个get方法，唯一的一个方法。传入一个对象，返回一对象。
     */
    @Test
    public void SupplierTest(){
        ShopEo shopEo = ShopSupplier.shopSupplier(() -> new ShopEo());
    }

    /**
     * UnaryOperator 一元运算子
     * UnaryOperator<T> 继承了Function接口。和它功能类型。多了一个静态方法identity()
     */
    @Test
    public void UnaryOperatorTest(){
        ShopUnaryOperator.shopUnaryOperator(new ShopEo(),shopEo -> new ShopEo());
    }


    /**
     * Spliterator,Optional的认识
     */

    /**
     * Spliterator (splitable iterator) 可分迭代器
     * 它和Iterator一样都是迭代器。但是Splitetator是为了程序能并行执行而生的。
     * 具有的方法：
     * boolean tryAdvance(Consumer<? supper T> ation) 判断使用还有元素要遍历，有就返回true（类似迭代器）
     * Spliterator<T> trySplit() 使用并行处理时，元素一部分划分给Spliterator1，一部分划分给Spliterator1,2...等处理。 拆分成子任务的作用。
     * long estimateSize() 评估还有多少元素没有处理
     * int characteristics()
     *
     *
     * 综上：我们可以知道并行流的工作原理了：
     * 第一步：Spliterator调用trySplit拆分任务
     * 第二步：子任务执行
     * 第三步：合并结果
     */
    @Test
    public void Splitetator(){
    }
}
