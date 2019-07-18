package com.cold.blade;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.LongStream;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @description
 * @author cold_blade
 * @date 2019/7/18
 * @version 1.0
 */
@RunWith(JUnit4.class)
public abstract class BaseTest {

    public void printCost(long cost, String unit) {
        System.out.println(String.format("cost : %d %s", cost, unit));
    }

    /**
     * 统计10次的执行时间减去一个最大和最小的再去平均值
     *
     * @param intConsumer 接收一个int参数的函数式接口
     * @param value 函数式接口的入参
     * @return 平均耗时
     */
    public long statisticEfficient(IntConsumer intConsumer, int value) {
        long[] array = LongStream.rangeClosed(1, 10)
            .map(i -> {
                long start = System.nanoTime();
                intConsumer.accept(value);
                return System.nanoTime() - start;
            }).toArray();
        long max = Arrays.stream(array).max().orElse(0);
        long min = Arrays.stream(array).min().orElse(0);
        return (Arrays.stream(array).sum() - max - min) / 8;
    }
}
