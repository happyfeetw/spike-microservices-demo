package com.spike.demo.netty.server.model;

/**
 * date: 2021/8/30
 * author: Spike
 * description:
 */
public class RequestData {
    private int intVal;
    private String stringVal;

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "intVal=" + intVal +
                ", stringVal='" + stringVal + '\'' +
                '}';
    }
}
