package com.sneha.transportSystem.car;

import com.sneha.transportSystem.Vehicle;
import com.sneha.transportSystem.VehicleType;

import java.util.UUID;

public class Car implements Vehicle {
    private String id;
    private CarType carType;

    Car(CarType carType){
        this.carType = carType;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }

    @Override
    public String getId() {
        return id;
    }
}
