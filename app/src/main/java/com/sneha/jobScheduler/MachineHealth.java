package com.sneha.jobScheduler;

import java.util.List;

public class MachineHealth {
    private List<MachineRegistry> serviceable;
    private List<MachineRegistry> unserviceable;

    MachineHealth(List<MachineRegistry> serviceable, List<MachineRegistry> unserviceable) {
        this.serviceable = serviceable;
        this.unserviceable = unserviceable;
    }

    public List<MachineRegistry> getServiceable() {
        return serviceable;
    }

    public List<MachineRegistry> getUnserviceable() {
        return unserviceable;
    }
}
