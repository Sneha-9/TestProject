package com.sneha.peerNetworkSystem;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ComputationEngine {

    private NetworkDatabase networkDatabase;
    private Network network;

    NetworkNode getNode(NetworkNode node) {

        if (network.size() == 1) {
            NetworkNode root = network.getRoot();
            Data data = root.getData();
            node.setData(data);
            node.setStatus();
            networkDatabase.add(node, root);
            return root;
        } else {
            List<NetworkNode> availableNode = getAvailableNode();
            NetworkNode nodeBySpeed = getNodeAsPerSpeed(availableNode);
            if (nodeBySpeed != null) {
                Data data = nodeBySpeed.getData();
                node.setData(data);
                node.setStatus();
                networkDatabase.add(node, nodeBySpeed);
                return nodeBySpeed;
            }
            NetworkNode nodeByDistance = getNodeAsPerDistance(availableNode);
            if (nodeByDistance != null) {

                Data data = nodeByDistance.getData();

                node.setData(data);
                node.setStatus();

                networkDatabase.add(node, nodeByDistance);
                return nodeByDistance;
            }
            return null;
        }
    }

    List<NetworkNode> getPeer(NetworkNode node){
     // List<NetworkNode> nodes =   networkDatabase.getNodes(node.getId());
      return null;
    }

    Map<NetworkNode, List<NetworkNode>> getPeers(){
        Map<NetworkNode, List<NetworkNode>> peerNetwork = new HashMap<>();
//        for(NetworkNode node: network.getNodes()){
//            peerNetwork.put(node, getPeer(node));
//        }

        return peerNetwork;

    }

    NetworkNode getNodeAsPerSpeed(List<NetworkNode> availableNodes){
        int minSpeed = Integer.MIN_VALUE;
        NetworkNode networkNode = null;

        for(NetworkNode n: availableNodes){
            if(minSpeed > n.getSpeed().getUploadValue()){
                minSpeed = n.getSpeed().getUploadValue();
                networkNode = n;
            }
        }
        return networkNode;
    }

    NetworkNode getNodeAsPerDistance(List<NetworkNode> availableNodes){
        int minXDistance = Integer.MIN_VALUE;
        int minYDistance = Integer.MIN_VALUE;
        NetworkNode networkNode = null;

        for(NetworkNode n: availableNodes){
            if(minXDistance > n.getCoordinate().getX() && minYDistance >  n.getCoordinate().getY()){
                minXDistance = n.getCoordinate().getX();
                minYDistance = n.getCoordinate().getY();

                networkNode = n;
            }
        }
        return networkNode;
    }

    List<NetworkNode> getAvailableNode(){
        List<NetworkNode> result = new ArrayList<>();

//        for(NetworkNode n: network.getNodes()){
//            if(n.getStatus().equals(Status.AVAILABLE)){
//                result.add(n);
//            }
//        }
        return result;
    }

}
