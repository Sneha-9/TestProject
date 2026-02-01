package com.sneha.car;

import java.util.ArrayList;

public class TwoWheelerCar extends Car {

    TwoWheelerCar(Engine engine, HeadLight headLight) {
        super(engine, new ArrayList<>(2), headLight);
    }
}
