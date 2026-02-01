package com.sneha.jobScheduler.machine;

public class Machine {
    private boolean isServiceable;

    Machine(){
        this.isServiceable = true;
    }

    public boolean isServiceable() {
        return isServiceable;
    }
}
