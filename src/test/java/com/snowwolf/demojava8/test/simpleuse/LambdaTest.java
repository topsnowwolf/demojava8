package com.snowwolf.demojava8.test.simpleuse;

import com.snowwolf.demojava8.mode.dto.ShopDto;
import com.snowwolf.demojava8.mode.eo.ShopEo;
import com.snowwolf.demojava8.mode.service.impl.ShopServiceImpl;
import com.snowwolf.demojava8.mode.util.ForkJoinSumTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/25 15:09
 * @modified by:
 * @versions：0.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {
    @Autowired
    private ShopServiceImpl shopService;
    /**
     * 场景，查询商店按距离大小排序
     */
    @Test
    public void testSort(){
        /**
         * 方法1，最笨最不灵活的方法，在实体类中实现Comparable接口重写compareTo方法，调用Collections的sort()方法
         * 最易懂，代码不可重用。
         * 什么说是最笨的。因为当一个需要时按距离大小排序，一个按商品的销售量或人气排序呢？你又写一类存放内容，再重写compareTo方法？
         * 例子：
        */
        List<ShopDto> list = shopService.findShops();
        Collections.sort(list);

        /**
         * 方法2，相对灵活，代码书写量过多。在sort方法中定义一个比较器，内部类的方式。调用sort方法
         * 例子：
         */
        List<ShopEo> shopEos = shopService.findAll();
        shopEos.sort(new Comparator<ShopEo>() {
            @Override
            public int compare(ShopEo o1, ShopEo o2) {
                return o1.getDistance().compareTo(o2.getDistance());
            }
        });

        /**
         * 方法3，最灵活，最简洁。利用java8的新特性，lambda表达式实现（方法引用）
         */
        List<ShopEo> shopEoList = shopService.findAll();
        //lambda表达式实现，通常优化成使用方法引用方式的，代码看起来简洁！
        shopEoList.sort((a,b)-> a.getDistance().compareTo(b.getDistance()));
        shopEoList.sort(Comparator.comparing((a)->a.getDistance()));
        //进一步优化，方法引用（最简洁明了）。注意：使用方法引用，目标引用放在::前，方法在后面
        //顺便说一个小知识点，在idea工具中如果代码可以优化成lambda表达式或方法引用，按住alt+shift，会出现一个黄色灯泡，提示replace with...选择就可以优化你的代码了！！！
        shopEoList.sort(Comparator.comparing(ShopEo::getDistance));


        /**
         * 现在新的需要又来了。要按距离从远到近
         * 使用reversed进行逆序
         */
        shopEoList.sort(Comparator.comparing(ShopEo::getDistance).reversed());

        /**
         * 又来新的需求了，按距离大小排序后，还有按销售量排序
         * 使用比较器链thenComparing,可以链多个！！
         */
        shopEoList.sort(Comparator.comparing(ShopEo::getDistance).thenComparing(ShopEo::getSaleroom));
        //到这里你发觉是不是java8的函数式编程很6很6。太强大了吧！下面还有更强大的！
    }

    /**
     * java8的又一大特色，流
     * 根据执行的步骤分成两种：1顺序流，2并行流
     */
    @Test
    public void testStream(){
        //顺序流，查询销售额大于1000的店铺
        List<ShopEo> shopEoList = shopService.findAll().stream().filter(shopEo -> shopEo.getSaleroom()>1000).collect(Collectors.toList());
        //当你发现，使用stream效率不够好，想利用并行流去操作。
        List<ShopEo> shopEoList1 = shopService.findAll().parallelStream().filter(shopEo -> shopEo.getSaleroom()>1000).collect(Collectors.toList());
        /**
         * 此时你会对parallelStream很感兴趣，他是怎么处理的？怎么就能实现并行了呢。实现原理就是forkjoin！！！
         * 以递归的方式将流划分成多个子流给不同线程执行，最后合并结果。
         */
        //TODO
        /**
         * 使用并行流注意的要点：不是什么时候使用都可以提升效率。因为并行要对流进行递归划分，将子流划归到不同线程中，之后再合并所有线程的结果。
         * 所以：不能使用在会改变共享变量值的情况下。 要按顺序执行的流不能使用并行，例如limit和findFirst等。数据量小不适合使用。遍历的数据结构拆分效率慢的不适合
         * (例如：LinkedList)。
         * 例子：
         */
        //这个就会导致并发的问题
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1,100).parallel().forEach(accumulator::add);
        Long total = accumulator.total;
    }

    /**
     *forkjoin框架的简单认识
     * 它的核心思想就是：以递归的方式将可以平行的任务拆分成更小的任务给每一个线程执行，最后合并结果。
     * 创建：创建一个任务，任务必须继承RecursiveTask,之后重写compute。创建一个ForkJoinPool()线程池对象，将任务invoke进去。
     */
    public void testForkJoin(){
        long numbers[] = LongStream.rangeClosed(1,200000).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumTask(numbers);
        long tatol = new ForkJoinPool().invoke(task);
    }

    /**
     * 流操作的常用方法
     * 这里主要说一下filter过滤，map提取，flatMap提取后形成新的流，limit截取，sort排序（之前已说过），collect收集,distinct去重（必须重写hash和equs方法），
     * reduce元素归约。其他的方法看JDK8的API介绍很详细了！！！
     * allMatch,anyMatch,noneMatch,findFirst,findAny等等这些方法就不介绍了。API已经很详细介绍了！
     * 注意：每一个流只能操作一次，就是说只能遍历一次。第二次就是报异常了。
     */
    @Test
    public void testStreamMenth(){
        //过滤，截取
        //查询销售额大于1000的店铺
        List<ShopEo> shopEoList = shopService.findAll().stream().filter(shopEo -> shopEo.getSaleroom()>1000).collect(Collectors.toList());
        //查询销售额大于1000的店铺中的前三名
        List<ShopEo> shoplimit = shopService.findAll().stream().filter(shopEo -> shopEo.getSaleroom()>1000).
                sorted(Comparator.comparing(ShopEo::getSaleroom)).limit(3).collect(Collectors.toList());

        //查询销售额大于1000的店铺非前三名
        List<ShopEo> shopskip = shopService.findAll().stream().filter(shopEo -> shopEo.getSaleroom()>1000).
                sorted(Comparator.comparing(ShopEo::getSaleroom)).skip(3).collect(Collectors.toList());

        //提取
        //获取销售额大于1000的店铺中的前三名的名称
        List<String> names = shopService.findAll().stream().filter(shopEo -> shopEo.getSaleroom()>1000).
                sorted(Comparator.comparing(ShopEo::getSaleroom)).limit(3).map(shopEo -> shopEo.getShopName()).collect(Collectors.toList());

        /**
         * 什么情况下使用flatMap提取后形成新的流
         * map之后再map。map之后distinct。所有通常我们使用map的时候都是最后才提取！！！
         * 如果你提取了，还有进行其他操作就要好好考虑是否要新的流才可以操作，考虑是否时候flatMap进行提取。
         */
        //TODO

        //归约
        //获取所有店铺的销售总和
        Long reduce = shopService.findAll().stream().map(shopEo -> shopEo.getSaleroom()).reduce(0L, (integer, aLong) -> integer + aLong);
        //最大的销售额是多少
        Optional<Long> maxoptional = shopService.findAll().stream().map(shopEo -> shopEo.getSaleroom()).reduce(Long::max);
        if(maxoptional.isPresent()){
            maxoptional.get();
        }
        //最小的销售额是多少
        Optional<Long> minoptional = shopService.findAll().stream().map(shopEo -> shopEo.getSaleroom()).reduce(Long::min);
        if(minoptional.isPresent()){
            minoptional.get();
        }

        //collect收集 收集成List，收集成Set,拼接成字符串
        Set<String> shopNames = shopService.findAll().stream().map(shopEo -> shopEo.getShopName()).collect(Collectors.toSet());
        //将所有的店铺拼接在一起成一个字符串
        String nameString = shopService.findAll().stream().map(shopEo -> shopEo.getShopName()).collect(joining());

        //查询销售额最小的商店
        Optional<ShopEo> min = shopService.findAll().stream().min(Comparator.comparing(ShopEo::getSaleroom));
        if(min.isPresent()){
            min.get();
        }
        //查询销售额最多的商店
        Optional<ShopEo> max = shopService.findAll().stream().max(Comparator.comparing(ShopEo::getSaleroom));
        if(max.isPresent()){
            max.get();
        }
    }

    /**
     * 流的构建
     */
    public void testCreatStream(){
        //Stream.of()构建
        Stream<String> stringStream = Stream.of("java","python","c++","php");
        //Arrays.stream构建
        int[] numbers = {3,1,32,34,5,6,12};
        IntStream stream = Arrays.stream(numbers);
        //Files.lines构建
        try(Stream<String> lines = Files.lines(Paths.get("I:\\tooldev\\demo\\test.doc"), Charset.defaultCharset())){
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 用流对数据进行收集整理
     * 1.归约汇总
     * 2.分组分区(注意：分组可以分成多个组，partitioningBy分区只能分两个)
     * 常用的方法：toList,toSet,toCollection,summingInt,averagingInt,summarizingInt,joing,maxBy,minBy,reducing,collectingAndThen
     * groupingBy,partitioningBy等等。在此不多介绍，自己查看API。
     * 下面主要介绍常用到的场景！
     */

    public void testStreamCollecte(){
        //查询销售额最多的店铺
        Optional<ShopEo> eoOptional = shopService.findAll().stream().collect(maxBy(Comparator.comparing(ShopEo::getSaleroom)));
        if(eoOptional.isPresent()){
            eoOptional.get();
        }
        ShopEo shopEo = shopService.findAll().stream().collect(collectingAndThen(maxBy(Comparator.comparing(ShopEo::getSaleroom)), Optional::get));
        //查询所有的销售总和
        Long collect = shopService.findAll().stream().collect(summingLong(ShopEo::getSaleroom));
        //查询销售平均值
        Double aDouble = shopService.findAll().stream().collect(averagingDouble(ShopEo::getSaleroom));
        //利用summarizing可以计算总和，平均值，最小值，最大值
        LongSummaryStatistics summaryStatistics = shopService.findAll().stream().collect(summarizingLong(ShopEo::getSaleroom));
        summaryStatistics.getAverage();
        summaryStatistics.getMax();
        summaryStatistics.getMin();
        summaryStatistics.getSum();
        //根据所在的城市分组
        Map<String, List<ShopEo>> listMap = shopService.findAll().stream().collect(groupingBy(ShopEo::getShopCity));
        //根据所在城市分组之后再按店铺的状态分组
        Map<String, Map<String, List<ShopEo>>> mapMap = shopService.findAll().stream().collect(groupingBy(ShopEo::getShopCity, groupingBy(ShopEo::getStatus)));
        //查询每个城市销售量最高的店铺
        Map<String, Optional<ShopEo>> optionalMap = shopService.findAll().stream().collect(groupingBy(ShopEo::getShopCity, maxBy(Comparator.comparing(ShopEo::getSaleroom))));
        Map<String, ShopEo> shopEoMap = shopService.findAll().stream().collect(groupingBy
                (ShopEo::getShopCity, collectingAndThen(maxBy(Comparator.comparing(ShopEo::getSaleroom)), Optional::get))
        );
        //每一个城市下销售额大于10000的为A，销售额小于10000大于5000的为B，5000以下的为C
        Map<String, Map<String, List<ShopEo>>> stringMapMap = shopService.findAll().stream().collect(groupingBy(ShopEo::getShopCity, groupingBy(shop -> {
            if (shop.getSaleroom() > 10000) {
                return "A";
            } else if (shop.getSaleroom() > 5000 && shop.getSaleroom() <= 10000) {
                return "B";
            } else {
                return "C";
            }
        })));
        //统计每一个城市的总销售额
        Map<String, Long> stringLongMap = shopService.findAll().stream().collect(groupingBy(ShopEo::getShopCity, summingLong(ShopEo::getSaleroom)));

        //分区
        //销售额大于10000的为true分区，小于的为false分区
        Map<Boolean, List<ShopEo>> booleanListMap = shopService.findAll().stream().collect(partitioningBy(shop -> shop.getSaleroom() > 10000));
        //是直店铺的true分组，非直销店铺false分区
        Map<Boolean, List<ShopEo>> map = shopService.findAll().stream().collect(partitioningBy(ShopEo::getType));
    }
}
