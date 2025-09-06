package com.sneha.parkingLot;

import java.util.Objects;
import java.util.UUID;

public class Lot {
    private Vehicle vehicle;
    private  IdGenerator idGenerator ;

    private final String supportedVehicleType;

    private String regex ="^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";

    Lot(IdGenerator idGenerator,String supportedVehicleType)throws IllegalArgumentException {
        if(idGenerator == null ){
            throw  new IllegalArgumentException("Id cannot be null");
        }

        if(!idGenerator.generate().matches(regex)){
            throw new IllegalArgumentException("Id is not valid");
        }

        if(!supportedVehicleType.equals(Constants.TWO_WHEELER)&& !supportedVehicleType.equals(Constants.FOUR_WHEELER)){
            throw new IllegalArgumentException("Vehicle Type can be either TWO_WHEELER or FOUR_WHEELER");
        }

        this.supportedVehicleType = supportedVehicleType;
        this.idGenerator = idGenerator;
    }

    public String getId() {
        return idGenerator.generate();
    }

    void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    boolean isAvailable() {
        return this.vehicle == null;
    }

    public String getSupportedVehicleType() {
        return this.supportedVehicleType;
    }

    Vehicle unparkVehicle() {
        Vehicle unparkedVehicle = this.vehicle;
        this.vehicle = null;
        return unparkedVehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lot lot = (Lot) o;
        return Objects.equals(vehicle, lot.vehicle) && Objects.equals(idGenerator, lot.idGenerator) && Objects.equals(supportedVehicleType, lot.supportedVehicleType) && Objects.equals(regex, lot.regex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicle, idGenerator, supportedVehicleType, regex);
    }
}
