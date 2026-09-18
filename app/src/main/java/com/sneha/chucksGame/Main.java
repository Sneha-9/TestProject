package com.sneha.chucksGame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WicketRule wicketRule = new WicketRule();

        Over overOne = new Over(6);
        List<Over> overs = new ArrayList<>();
        overs.add(overOne);

        WinnerDeciderSystem winnerDeciderSystem = new WinnerDeciderSystem();
        RandomPointGenerator randomPointGenerator = new RandomPointGenerator();

        Innings innings = new Innings();
        Game game = new Game(wicketRule, innings, winnerDeciderSystem, overs);

        Player playerOne = new Player(randomPointGenerator);
        List<Player> playersTeamA = new ArrayList<>();

        Team teamA = new Team(playersTeamA);
        teamA.addPlayer(playerOne);

        Player playerTwo = new Player(randomPointGenerator);
        List<Player> playersTeamB = new ArrayList<>();

        Team teamB = new Team(playersTeamB);
        teamB.addPlayer(playerTwo);

        game.start(teamA, teamB);
    }
}
