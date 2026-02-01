package com.sneha.car;

import java.util.List;

abstract public class Car {

    private final Engine engine;
    private final List<Wheel> wheels;
    private final HeadLight headLight;

    Car(Engine engine, List<Wheel> wheels, HeadLight headLight) {
        this.engine = engine;
        this.headLight = headLight;
        this.wheels = wheels;
    }


}
