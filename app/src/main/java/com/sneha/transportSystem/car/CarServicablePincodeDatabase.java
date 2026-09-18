package com.sneha.transportSystem.car;

import java.util.ArrayList;
import java.util.List;

public class CarServicablePincodeDatabase {
    List<Pincode> pincodeList = new ArrayList<>();

    void add(Pincode pincode){
        pincodeList.add(pincode);
    }

    boolean validate(Pincode pincode){
        return true;
    }
}
