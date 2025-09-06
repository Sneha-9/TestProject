package parkingLot;

public class LotNotFoundException extends  Exception{
    LotNotFoundException(){
        super("Lot not found");
    }
}
