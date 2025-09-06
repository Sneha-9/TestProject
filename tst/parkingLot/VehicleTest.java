package parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VehicleTest {

    @Test
    void throwsExceptionWhenVehicleTypeIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new Vehicle("123",null));
    }
    @Test
    void throwsExceptionWhenVehicleTypeIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new Vehicle("123",""));
    }
    @Test
    void throwsExceptionWhenVehicleNumberIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new Vehicle("","TWO_WHEELER"));
    }
    @Test
    void throwsExceptionWhenVehicleNumberIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new Vehicle(null,"TWO_WHEELER"));
    }
    @Test
    void throwsExceptionWhenVehicleTypeIsOtherThanTwoWheelerORFourWheeler(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new Vehicle("123s","TWOELER"));
    }
    @Test
    void returnsTwoWheelerVehicleTypeWhenVehicleNumberIsPresentAndVehicleTypeIsTwoWheeler(){
        Assertions.assertEquals("TWO_WHEELER",new Vehicle("123s","TWO_WHEELER").getVehicleType());
    }
    @Test
    void returnsThreeWheelerVehicleTypeWhenVehicleNumberIsPresentAndVehicleTypeIsFourWheeler(){
        Assertions.assertEquals("FOUR_WHEELER",new Vehicle("123s","FOUR_WHEELER").getVehicleType());
    }

}