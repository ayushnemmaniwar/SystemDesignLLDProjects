package SnakeAndLadder;

import SnakeAndLadder.Entity.Dice;
import SnakeAndLadder.Entity.Player;

import java.util.*;

public class SnakeAndLadderGame {
    Map<Integer,Integer> snakes;
    Map<Integer,Integer> ladders;
    Deque<Player> playerList;

    Dice dice;

    public void initialize() {
        dice = new Dice(1);
        createPlayers();
        System.out.println("How many Snakes you want to create: ");
        Scanner scanner = new Scanner(System.in);
        int snakeCount = scanner.nextInt();
        createSnakes(snakeCount);
        System.out.println("How many Ladders you want to create: ");
        int ladderCount = scanner.nextInt();
        createLadder(ladderCount);
    }

    private void createLadder(int ladderCount) {
        ladders = new HashMap<>();
        int count = 0;
        Random random = new Random();
        while(count<ladderCount) {
            int start = random.nextInt(98)+2;
            int end = random.nextInt(98)+2;
            if(start<end && !ladders.containsKey(start) && !snakes.containsKey(start)) {
                ladders.put(start,end);
                count++;
            }
        }
    }

    private void createSnakes(int snakeCount) {
        snakes = new HashMap<>();
        int count = 0;
        Random random = new Random();
        while(count<snakeCount) {
            int start = random.nextInt(98)+2;
            int end = random.nextInt(98)+2;
            if(start>end && !snakes.containsKey(start)) {
                snakes.put(start,end);
                count++;
            }
        }
    }

    private void createPlayers() {
        playerList = new LinkedList<>();
        Player player1 = new Player("Ayush",0);
        Player player2 = new Player("Anurag",0);
        Player player3 = new Player("Yashwanth",0);
        Player player4 = new Player("Manihar",10);
        playerList.addLast(player1);
        playerList.addLast(player2);
        playerList.addLast(player3);
        playerList.addLast(player4);
    }

    public void startGame() {
        Boolean gameOn = true;
        while(gameOn) {
            Player player = playerList.removeFirst();
            int currPos = player.getCurrPos();
            int result = dice.rollDice();
            System.out.println(player.getName()+" is rolling the dice");
            System.out.println("Dice Result is: "+result);
            int nextPos = currPos + result;
            if(nextPos>=100) {
                gameOn=false;
                System.out.println("Won by "+player.getName());
                continue;
            }
            if(snakes.containsKey(nextPos)) {
                nextPos = snakes.get(nextPos);
                System.out.println("You have eaten by snake 🥲 fallen to: "+ nextPos);
            }
            else if(ladders.containsKey(nextPos)) {
                nextPos = ladders.get(nextPos);
                System.out.println("You encountered ladder woahh 🥳 to: "+ nextPos);
            }
            player.setCurrPos(nextPos);
            System.out.println(player.getName()+" position updated to "+nextPos);
            playerList.addLast(player);

        }
    }
}
