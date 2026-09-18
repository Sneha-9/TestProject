package com.sneha.peerNetworkSystem;

public interface Node {
    Coordinate getCoordinate();
    Data getData();
    Speed getSpeed();
    Role getRole();
    String getId();

    Status getStatus();
}
