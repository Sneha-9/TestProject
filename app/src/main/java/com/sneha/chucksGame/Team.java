package com.sneha.chucksGame;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter

public class Team {
    private String id;
    private List<Player> players;

    Team(List<Player> playersList){
        this.id = UUID.randomUUID().toString();
        this.players = playersList;
    }

    void addPlayer(Player player){
        players.add(player);
    }

    int getTotalPoints(){
      int totalPoint =0;
        for(Player player: players){
            totalPoint = totalPoint + player.getPoint();
        }
        return totalPoint;
    }

    Player getPlayer(int index){
       return  players.get(index);
    }

    int getSize(){
        return players.size();
    }

}
