package com.sneha.chucksGame;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public class Player {
    private  int point;
    private RandomPointGenerator randomPointGenerator;

    Player(RandomPointGenerator randomPointGenerator){
        this.point =0;
        this.randomPointGenerator = randomPointGenerator;
    }

    void incrementPoint(int value){
      this.point =   point + value;
    }

    int play(){
       return randomPointGenerator.generate();
    }

}
