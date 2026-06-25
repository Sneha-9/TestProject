package com.sneha.realTimeMonitoringSystem;

//Does this need to be interface?
public abstract class Metric {

    private String name;
    private long timeStamp;

    Metric(String name, TimeUtil timeUtil) {
        this.name = name;
        this.timeStamp = timeUtil.getCurrentTime();
    }

    String getName() {
        return name;
    }

    long getTimeStamp() {
        return timeStamp;
    }
}
