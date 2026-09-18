package com.sneha.peerNetworkSystem;

import lombok.Getter;

import java.util.UUID;

@Getter
public class NetworkNode {
    private Coordinate coordinate;
    private Data data;
    private Speed speed;
    private String id;
    private Role role;
    private Status status;

    NetworkNode(Coordinate coordinate,Data data,Speed speed,Role role){
        this.coordinate = coordinate;
        this.speed = speed;
        this.role= role;
        this.id = UUID.randomUUID().toString();
        this.status = Status.AVAILABLE;
        this.data = data;
    }

    void setData(Data data){
        // add validation to throw exception if role is root
        this.data = data;
    }

    void setStatus(){
        this.status = Status.UNAVAILABLE;
    }
}
