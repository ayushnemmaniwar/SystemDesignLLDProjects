package SnakeAndLadder.Entity;

import java.util.Random;

public class Dice {
    int diceCount;
    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }
    public int rollDice() {
        Random random = new Random();
        int totalSum = 0;
        int count = 0;
        while(count<diceCount) {
            totalSum = totalSum + random.nextInt(6)+1;
            count++;
        }
        return totalSum;
    }
}
