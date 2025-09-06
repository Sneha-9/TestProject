package com.sneha.parkingLot;

public class FloorNotFoundException extends Exception {
    FloorNotFoundException(){
        super("Floor not found");
    }
}
