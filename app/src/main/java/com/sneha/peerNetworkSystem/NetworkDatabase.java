package com.sneha.peerNetworkSystem;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDatabase {
    Map<NetworkNode, List<NetworkNode>> networkDatabase = new HashMap<>();


    void add(NetworkNode networkNode, NetworkNode peerNode){
        if(networkDatabase.containsKey(networkNode)){
            List<NetworkNode> peers = networkDatabase.get(networkNode);
            peers.add(peerNode);
            networkDatabase.put(networkNode, peers);
        }
        else{
            networkDatabase.put(networkNode, new ArrayList<>());
        }
    }

}
