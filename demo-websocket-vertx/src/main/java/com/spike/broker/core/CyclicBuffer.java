package com.spike.broker.core;

/**
 * date: 2021/8/24
 * author: Spike
 * description:
 *  缓存数据的环形队列
 *  数据种类为秒变实时数据
 */
public class CyclicBuffer {

    /**
     * 环形队列的容量
     * 值表示最大能缓存的数据的个数
     * 若队列已满，从队列满元素开始，每一个出队元素都表示当前时间五秒前的数据
     *
     */
    private int capacity = 5;

    /**
     * 可读位置
     */
    private int readable;

    /**
     * 可写位置
     */
    private int writable;

    /**
     * 当前位置
     */
    private int current;


}
