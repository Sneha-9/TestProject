package com.sneha.farmingSystem;

public class SingleDimensionalFarmland {
    Crop[] crops ;
    SingleDimensionalFarmland(int size){
        crops= new Crop[size];
    }

    void addCrop(int idx, Crop crop){
        crops[idx] = crop;
    }

    Crop getCrop(int idx, Crop crop){
        return crops[idx];
    }

    Crop[] getFarm(){
        return crops;
    }
}
