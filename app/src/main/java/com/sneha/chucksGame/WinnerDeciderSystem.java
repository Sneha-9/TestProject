package com.sneha.chucksGame;

public class WinnerDeciderSystem {

    Team isWinner(Team teamA, Team teamB) {
        if (teamA.getTotalPoints() > teamB.getTotalPoints()) {
            return teamA;
        } else if (teamA.getTotalPoints() < teamB.getTotalPoints()) {
            return teamB;
        } else return null;
    }
}
