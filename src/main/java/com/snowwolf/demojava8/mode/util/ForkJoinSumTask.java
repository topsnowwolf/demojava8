package com.snowwolf.demojava8.mode.util;

import java.util.concurrent.RecursiveTask;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/27 8:26
 * @modified by:
 * @versions：0.1.0
 */
public class ForkJoinSumTask extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start;
    private final int end;
    private static final long taskNum = 1000;
    public ForkJoinSumTask(long[] numbers){
        this(numbers,0,numbers.length);
    }
    private ForkJoinSumTask(long[] numbers,int start,int end){
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        int length = end - start;
        if(length<taskNum){
            return computeTask();
        }
        ForkJoinSumTask leftask = new ForkJoinSumTask(numbers,start,start+length/2);
        leftask.fork();
        ForkJoinSumTask righttask = new ForkJoinSumTask(numbers,start+length/2,end);
        //同步执行第二个子任务
        Long compute = righttask.compute();
        //读取第一个子任务的结果，没完成继续等待
        Long join = leftask.join();
        return join+compute;
    }

    private long computeTask(){
        long sum = 0;
        for(int i=start;i<end;i++){
            sum += numbers[i];
        }
        return sum;
    }
}
