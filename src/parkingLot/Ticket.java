package parkingLot;

import java.util.Objects;
import java.util.UUID;

public class Ticket {
    private final String id;
    private final String vehicleNumber;
    private final String lotId;
    private final String floorId;
    private final long startTime ;
    private String regex ="^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";

    Ticket(IdGenerator idGenerator,TimeUtil timeUtil,String vehicleNumber, String lotId, String floorId)throws IllegalArgumentException {
        if(lotId == null || lotId.isEmpty()){ //Very good

            throw new IllegalArgumentException("lotId cannot be null or an empty string");
        }

        if(floorId == null || floorId.isEmpty()){
            throw new IllegalArgumentException("floorId cannot be empty or null");
        }

        if(vehicleNumber == null || vehicleNumber.isEmpty()){
            throw new IllegalArgumentException("Vehicle Number cannot be empty or null");
        }
        if(idGenerator == null ){
            throw  new IllegalArgumentException("Id cannot be null");
        }
        if(!idGenerator.generate().matches(regex)){
            throw new IllegalArgumentException("Id is not valid");
        }

        this.vehicleNumber = vehicleNumber;
        this.lotId = lotId;
        this.floorId = floorId;
        this.startTime=timeUtil.getCurrentTime();
        this.id = idGenerator.generate();
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }


    public String getTicketId() {
        return this.id;
    }

    public String getLotId() {
        return this.lotId;
    }

    public String getFloorId() {
        return floorId;
    }

    public long getStartTime() {
        return this.startTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", lotId='" + lotId + '\'' +
                ", floorId='" + floorId + '\'' +
                ", startTime=" + startTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return startTime == ticket.startTime && Objects.equals(id, ticket.id) && Objects.equals(vehicleNumber, ticket.vehicleNumber) && Objects.equals(lotId, ticket.lotId) && Objects.equals(floorId, ticket.floorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicleNumber, lotId, floorId, startTime);
    }
}
