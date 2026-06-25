package com.sneha.realTimeMonitoringSystem;


public class GaugeMetric extends Metric{

    private int value;

    GaugeMetric(String name ,TimeUtil timeUtil,int value){
     super(name, timeUtil);
        this.value = value;

    }

    public int getValue() {
        return value;
    }
}
