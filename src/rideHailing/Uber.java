package rideHailing;

import java.util.List;

public class Uber {
    private IdGenerator idGenerator;
    private LocationValidator locationValidator;
    private CabFinder cabFinder;
    private TripDatabase tripDatabase;

    Uber(IdGenerator idGenerator, LocationValidator locationValidator) {

    }

    List<Candidate> findACab(Location source, Location destination) {
        return null;
    }

    TripDetails startATrip(Candidate candidate) {
        return null;
    }

    void endATrip(TripDetails tripDetails) {

    }

}
