package com.sneha.card;

import lombok.Getter;

@Getter
public class Card {
    private House house;
    private Figure figure;

    Card(House house, Figure figure){
        this.house = house;
        this.figure = figure;
    }

}
