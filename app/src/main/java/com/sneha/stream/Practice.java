package com.sneha.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

record PlayerRank(String playerId, String tier, int mmr, boolean isOnline) {}

public class Practice {
    public static void main(String[] args) {
        List<PlayerRank> rankings = List.of(
                new PlayerRank("p1_alpha", "Grandmaster", 3200, true),
                new PlayerRank("p2_bravo", "Diamond", 2850, false),
                new PlayerRank("p3_charlie", "Platinum", 2400, true),
                new PlayerRank("p4_delta", "Diamond", 2900, true),
                new PlayerRank("p5_echo", "Gold", 1950, false)
        );


        // count no of players currently online
        long onlinePlayerCount = rankings.stream().filter(ranking -> ranking.isOnline()).count();
        System.out.println(onlinePlayerCount);

        // set of tier
        Set<String> tiers = rankings.stream().map(PlayerRank :: tier).distinct().collect(Collectors.toSet());
        System.out.println(tiers);

        //list of diamond playerId from diamond tier
        List<String> diamondPlayerId = rankings.stream().filter(ranking -> ranking.tier() == "Diamond")
                .map(PlayerRank::playerId).collect(Collectors.toList());
        System.out.println(diamondPlayerId);


        List<PlayerRank> result = rankings. stream().sorted(Comparator.comparing(PlayerRank::mmr).reversed()).toList();

        System.out.println(result);
    }

}
