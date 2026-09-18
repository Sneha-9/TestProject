package com.sneha.peerNetworkSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class NetworkSystem {
    private ComputationEngine computationEngine;
   // private NodeDatabase nodeDatabase;
    private Network network;

//    void addNode(NetworkNode node){
//        //add validation to check if more than one root exist
//       network.addPeerNode(node);
//
//    }

    //Incorrect function name
    NetworkNode getNode(NetworkNode node){

        return computationEngine.getNode(node);
    }

    List<NetworkNode> getPeer(NetworkNode node){
       return computationEngine.getPeer(node);
    }

    Map<NetworkNode,List<NetworkNode>> getPeerNetwork(){

        return  computationEngine.getPeers();
    }
}
