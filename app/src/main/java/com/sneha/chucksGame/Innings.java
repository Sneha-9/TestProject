package com.sneha.chucksGame;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Innings {

    void play(Team team, Player bowler, WicketRule wicketRule, List<Over> overs) {

//        int totalBalls = 0;
//
//        for (Over over : overs) {
//            totalBalls = totalBalls + over.getNoOfBalls();
//        }

        int totalBalls = overs.stream()
                .mapToInt(Over::getNoOfBalls)
                .sum();

        int currentTeamSize = 0;

        while (totalBalls > 0 || currentTeamSize < team.getSize()) {
            if (currentTeamSize >= team.getSize()) {
                break;
            }

            Player batter = team.getPlayer(currentTeamSize);
            if (totalBalls <= 0) {
                break;
            }

            totalBalls--;

            int batterPoint = batter.play();
            System.out.println("Batter Point " + batterPoint);

            int bowlerPoint = bowler.play();
            System.out.println("Bowler Point " + bowlerPoint);

            if (wicketRule.isBold(batterPoint, bowlerPoint)) {
                System.out.println("Player Out");
                currentTeamSize++;

            } else {
                batter.incrementPoint(batterPoint);
            }

        }


    }

}
