package com.sneha.splitwise;

import java.util.List;

public class Splitwise {

    private final Trip trip;
    private final Calculator calculator;

    Splitwise(Trip trip, Calculator calculator) {
        this.calculator = calculator;
        this.trip = trip;

    }

    List<Debt> expenses() {
        return null;
    }

}
