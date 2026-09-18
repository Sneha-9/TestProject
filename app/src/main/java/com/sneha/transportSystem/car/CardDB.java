package com.sneha.transportSystem.car;

import java.util.ArrayList;
import java.util.List;

public class CardDB {
    List<CarData> carDataList = new ArrayList<>();

    void add(CarData carData){
      carDataList.add(carData);
    }

    List<CarData> getCar(){
        return carDataList;
    }
}
