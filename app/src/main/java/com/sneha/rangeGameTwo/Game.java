package com.sneha.rangeGameTwo;

import com.sneha.rangeGameTwo.operation.Operation;
import com.sneha.rangeGameTwo.roundRule.RoundWinnerComputer;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Game {

    private PointGenerator pointGenerator;
    private Operation operation;
//    private PointStore pointStore;
    private WinnerRule winnerRule;
    private RoundWinnerComputer roundWinnerComputer;
    List<Player> players;
    int winningPoint;


    void start() {

        while (true) {

//            int playerOneRoundPoint = pointGenerator.generate();
//            System.out.println("Player One Round Point:" + playerOneRoundPoint);
//
//            int playerTwoRoundPoint = pointGenerator.generate();
//            System.out.println("Player Two Round Point:" + playerTwoRoundPoint);



            List<Integer> pointsList = new ArrayList<>();

            for(int i=0;i< players.size();i++){
                pointsList.add(pointGenerator.generate());
            }
            System.out.println("Random Points"+pointsList);
            for(Player player: players){

                System.out.println("Player points"+ player.getPoints());
            }

            //Issue
            int totalRoundPoint = operation.operate(pointsList);
            System.out.println("Sum of Round" + totalRoundPoint);
            Player roundWinner = roundWinnerComputer.getRoundWinner(totalRoundPoint);

            roundWinner.incrementPoint();

//            System.out.println("Player 1 Point " + one.getPoints());
//            System.out.println("Player 2 Point " + two.getPoints());

           // List<Player> players = pointStore.getPlayers();

            if (winnerRule.getGameWinner(roundWinner, winningPoint) != null) {
                System.out.println("Winner");
                break;
            }

        }
    }
}
