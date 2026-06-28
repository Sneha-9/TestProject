package com.sneha.rangeGameTwo;

import com.sneha.rangeGameTwo.operation.Operation;
import com.sneha.rangeGameTwo.operation.SumOperation;
import com.sneha.rangeGameTwo.roundRule.NPlayerRuleRoundWinnerComputer;
import com.sneha.rangeGameTwo.rule.EqualToZeroRule;
import com.sneha.rangeGameTwo.rule.GreaterThanZeroRule;
import com.sneha.rangeGameTwo.rule.LessThanZeroRule;
import com.sneha.rangeGameTwo.rule.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter winner point ");
        int winningPoint = sc.nextInt();

        System.out.println("No of players");
        int noOfPlayers = sc.nextInt();

        PointRange pointRange = new PointRange(-5, 5);
        PointGenerator pointGenerator = new RandomPointGenerator(pointRange);
        Operation operation = new SumOperation();
//        PointStore pointStore = new PointStore();

        WinnerRule winnerRule = new WinnerRule();


        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < noOfPlayers; i++) {
            playerList.add(new Player());
        }
        //ODDEVEN GAME
//        Player one = new Player();
//        Player two = new Player();
//
//        RoundWinnerComputer roundWinnerComputer = new OddEvenRoundWinnerComputer(one, two);

        NPlayerRuleRoundWinnerComputer roundWinnerComputer = new NPlayerRuleRoundWinnerComputer();
        List<Rule> nPlayerRules = new ArrayList<>();

        nPlayerRules.add(new GreaterThanZeroRule());
        nPlayerRules.add(new EqualToZeroRule());
        nPlayerRules.add(new LessThanZeroRule());

        for (int i = 0; i < playerList.size(); i++) {
            roundWinnerComputer.addEntry(playerList.get(i), nPlayerRules.get(i));
        }
        Game game = new Game(pointGenerator, operation, winnerRule, roundWinnerComputer, playerList, winningPoint);
        game.start();
    }
}
