package TicTacToeLLD;

import TicTacToeLLD.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> playerList;
    Board board;


    public void initializeGame() {
        playerList = new LinkedList<>();
        board = new Board(3);
        PlayingPiece playingPieceX = new PlayingPieceX();
        PlayingPiece playingPieceO = new PlayingPieceO();
        Player player1 = new Player("Ayush",playingPieceX);
        Player player2 = new Player("Anurag",playingPieceO);
        playerList.addLast(player1);
        playerList.addLast(player2);
    }


    public void startGame() {
        Boolean isEnd = false;
        board.printBoard();
        while(!isEnd) {
            boolean isBoardFull = board.isBoardFull();
            if(isBoardFull) {
                isEnd=true;
                System.out.println("Match has been Draw 🙂");
                continue;
            }
            Player player = playerList.peekFirst();
            System.out.println(player.getName() +"'s turn select row and column: ");
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();
            Boolean isCellValid = board.isCellValid(row,col);
            if(!isCellValid) {
                System.out.println("This cell is already fill or invalid, Please select another cell");
                continue;
            }
            board.addCell(row,col,player.getPlayingPiece());
            board.printBoard();
            Boolean validateWinner = board.checkForTheWinner(player.getPlayingPiece());
            if(validateWinner) {
                System.out.println(player.getName() + " is the Winner");
                isEnd=true;
            }
            playerList.removeFirst();
            playerList.addLast(player);
        }
    }
}
