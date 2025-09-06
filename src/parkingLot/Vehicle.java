package parkingLot;

import java.util.Objects;

public class Vehicle {
    private final String number;
    private final String type;
    private Constants constants;
    public Vehicle(String number, String type)throws IllegalArgumentException {
        if(number == null || number.isEmpty()){
            throw new IllegalArgumentException("Vehicle number cannot be empty or null");
        }

        if(type == null || type.isEmpty()){
            throw  new IllegalArgumentException("Vehicle Type cannot be empty or null");
        }

        if(!type.equals(constants.TWO_WHEELER) && !type.equals(constants.FOUR_WHEELER)){
            throw new IllegalArgumentException("Vehicle Type can be either TWO_WHEELER or FOUR_WHEELER");
        }

        this.number = number;
        this.type = type;
    }

    public String getVehicleNumber() {
        return this.number;
    }

    public String getVehicleType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(number, vehicle.number) && Objects.equals(type, vehicle.type) && Objects.equals(constants, vehicle.constants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type, constants);
    }
}
