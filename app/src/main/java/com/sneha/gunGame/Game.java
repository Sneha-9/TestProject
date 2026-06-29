package com.sneha.gunGame;

import com.sneha.gunGame.roundWinner.RoundData;
import com.sneha.gunGame.roundWinner.RoundWinner;
import com.sneha.gunGame.winningRule.TwoWinnerWinningRule;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Game {

    private List<Player> players;
    private RoundWinner roundWinner;
    private TwoWinnerWinningRule twoWinnerWinningRule;

    void start() {
        while (true) {
            RoundData roundData = new RoundData();
            if(players.get(0).getGun().isEmpty() == true){
                System.out.println("Gun Empty , game over"  );
                break;
            }

            for (int i = 0; i < players.size(); i++) {
                roundData.update(players.get(i), players.get(i).shoot());
            }

            Player roundWinnerPlayer = roundWinner.getRoundWinner(roundData);
            if (roundWinnerPlayer == null) {
                System.out.println("Round draw");
                continue;
            }
            roundWinnerPlayer.incrementPoint();

            System.out.printf("Player %d won, points %d %n", roundWinnerPlayer.getId(), roundWinnerPlayer.getPoint());

            if (roundWinnerPlayer.getGun().isEmpty()) {
                Player winnerPlayer = twoWinnerWinningRule.getWinner(players);
                if (winnerPlayer == null) {
                    System.out.println("Draw");
                    break;
                } else {
                    System.out.println("game over: final point " + winnerPlayer.getPoint());
                    break;
                }
            }

        }

    }


}
