package com.spike.demo.netty.client.model;

/**
 * date: 2021/8/30
 * author: Spike
 * description:
 */
public class ResponseData {
    private int intVal;

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "intVal=" + intVal +
                '}';
    }
}
