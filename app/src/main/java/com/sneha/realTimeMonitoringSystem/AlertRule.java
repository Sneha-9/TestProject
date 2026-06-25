package com.sneha.realTimeMonitoringSystem;

public class AlertRule {
    private String name;
    private int value;
    private String message;
    private int dataPoint;
    private int duration;

    AlertRule(String name,String message, int value, int dataPoint, int duration){

    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public int getDataPoint() {
        return dataPoint;
    }

    public int getDuration() {
        return duration;
    }
}
