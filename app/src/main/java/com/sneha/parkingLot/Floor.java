package com.sneha.parkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Floor {

    private String idGenerator;
    private  Lot[] lots ;


    Floor(IdGenerator idGenerator, Lot... lots) throws IllegalArgumentException {
        if(idGenerator == null){
            throw  new IllegalArgumentException("Id cannot be null");
        }

        if(lots.length==0){
            throw new IllegalArgumentException("Lot size cannot be zero");
        }

        this.idGenerator=idGenerator.generate();

//        lots.add(new Lot(idGenerator,vehicleType));
//        lots.add(new Lot(idGenerator,vehicleType));
        this.lots=lots;

    }

//    Floor(IdGenerator idGenerator, List<Lot> lots) {
//        this.lots = lots;
//    }
//
//    Floor(IdGenerator idGenerator, int noOfLots, String vehicleType) {
//        for (int i = 0; i < noOfLots; i++) {
//            lots.add(new Lot(vehicleType));
//        }
//    }
//
//    Floor(IdGenerator idGenerator, List<String> vehicleTypes) {
//        for (String vehicleType : vehicleTypes) {
//            lots.add(new Lot(vehicleType));
//        }
//    }

    public String getId() {
        return idGenerator;
    }

    Lot getAvailableLot() {
        for (Lot lot : lots) {
            if (lot.isAvailable()) {
                return lot;
            }
        }

        return null;
    }

    Lot findLot(String lotId) {
        for (Lot lot : lots) {
            if (lot.getId() == lotId) {
                return lot;
            }
        }

        return null;
//
//        for (int i = 0; i < lots.size(); i++) {
//            if (lots.get(i).getId() == lotId) {
//                return lots.get(i);
//            }
//        }
//        return null;
    }


}
