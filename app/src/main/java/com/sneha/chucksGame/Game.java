package com.sneha.chucksGame;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Game {
    private WicketRule wicketRule;
    private Innings innings;
    private WinnerDeciderSystem winnerDeciderSystem;
    private List<Over> overs;

    void start(Team teamA, Team teamB) {

        System.out.println("Team A batting");
        innings.play(teamA, teamB.getPlayer(0), wicketRule, overs);

        System.out.println("Team B batting");
        innings.play(teamB, teamA.getPlayer(0), wicketRule, overs);

        Team team = winnerDeciderSystem.isWinner(teamA, teamB);

        System.out.println("Team A total points " + teamA.getTotalPoints());
        System.out.println("Team B total points " + teamB.getTotalPoints());

        if (team == null) {
            System.out.println("draw");
        } else if (team.getId() == teamA.getId()) {
            System.out.println("Team A won");
        } else {
            System.out.println("Team B won");
        }

    }

}
