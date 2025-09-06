package rideHailing;

public class TripDetails {
    private  String id;
    TripDetails(IdGenerator idGenerator){
        this.id = idGenerator.generate();
    }

    public String getId() {
        return id;
    }
}
