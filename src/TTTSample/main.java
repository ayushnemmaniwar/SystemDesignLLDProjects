package TTTSample;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Board {
    Cell [][]cells;
    int x,y;

    Board() {
        x=3;
        y=3;
        cells=new Cell[x][y];
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                cells[i][j] = new Cell(PieceType.E);
            }
        }
    }

    public void printBoard() {
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                System.out.print(cells[i][j].getPieceType() + " ");
            }
            System.out.println();
        }
    }

    public boolean validateGame(PieceType playingPiece) {
        for(int i=0;i<x;i++) {
            int f=0;
            for(int j=0;j<y;j++) {
                if(cells[i][j].getPieceType()!=playingPiece) {
                    f=1;
                    break;
                }
            }
            if(f==0)
                return true;
        }
        for(int i=0;i<y;i++) {
            int f=0;
            for(int j=0;j<x;j++) {
                if(cells[j][i].getPieceType()!=playingPiece) {
                    f=1;
                    break;
                }
            }
            if(f==0)
                return true;
        }
        int f=0;
        for(int i=0;i<x;i++) {
            if(cells[i][i].getPieceType()!=playingPiece) {
                f = 1;
                break;
            }
        }
        if(f==0)
            return true;
        f=0;
        for(int i=0;i<x;i++) {
            if(cells[i][x-1-i].getPieceType()!=playingPiece) {
                f=1;
                break;
            }
        }
        if(f==0)
            return true;
        return false;
    }

    public boolean validateDraw() {
        int f=0;
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                if(cells[i][j].getPieceType()==PieceType.E) {
                    f=1;
                    break;
                }
            }
        }
        if(f==0)
            return true;
        return false;
    }
}
class Cell {
    PieceType pieceType;

    public Cell(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
enum PieceType {
    E,X,O
}
class Player {
    String name;
    PieceType playingPiece;

    public Player(String name, PieceType playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return name;
    }

    public PieceType getPlayingPiece() {
        return playingPiece;
    }
}

class Game {
    Queue<Player> playerQueue;
    Board board;
    Game() {
        playerQueue= new ArrayDeque<>();
        board = new Board();
    }

    public void initializeGame() {
        System.out.println("Initialize the Game");
        Player ayush = new Player("Ayush",PieceType.X);
        Player amey = new Player("Amey",PieceType.O);
        playerQueue.add(ayush);
        playerQueue.add(amey);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        board.printBoard();
        while(true) {
            Player player = playerQueue.poll();
            playerQueue.add(player);
            int x,y;
            System.out.println(player.getName()+" Turn choose indexes");
            while(true) {
                System.out.println("Please choose the valid cell");
                x = scanner.nextInt();
                y = scanner.nextInt();
                if(x>=0 && x<=2 && y>=0 && y<=2 && board.cells[x][y].getPieceType()==PieceType.E) {
                    break;
                } else {
                    System.out.println("Invalid cell");
                }
            }
            board.cells[x][y].setPieceType(player.getPlayingPiece());
            board.printBoard();
            Boolean winner  = board.validateGame(player.getPlayingPiece());
            if(winner) {
                System.out.print(player.getName() + " is the winner");
                break;
            }
            boolean draw = board.validateDraw();
            if(draw) {
                System.out.println("Match has drawn");
                break;
            }
        }
    }
}

public class main {
    public static void main(String[]args) {

        System.out.println("Lets start the game");
        Game game=new Game();
        game.initializeGame();
        game.startGame();
    }
}
