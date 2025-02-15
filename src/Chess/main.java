package Chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

enum Color {
    WHITE,BLACK
}

class Cell {
    int x;
    int y;
    Piece piece;

    public Cell(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
class Board {
    Cell [][]cells;
    void initializeBoard() {
        cells = new Cell[8][8];
        cells[0][0]= new Cell(0,0,new Rook(false,Color.WHITE));
    }
}
abstract class Piece {
    boolean isKilled;
    Color color;
    Piece(boolean isKilled,Color color) {
        this.isKilled=isKilled;
        this.color=color;
    }

    abstract boolean canMove(Board board,Cell src,Cell dest);
}

class Pawn extends Piece {
    Pawn(boolean isKilled,Color color) {
        super(isKilled,color);
    }

    @Override
    boolean canMove(Board board, Cell src, Cell dest) {
        return false;
    }
}

class Rook extends Piece {
    Rook(boolean isKilled,Color color) {
        super(isKilled,color);
    }

    @Override
    boolean canMove(Board board, Cell src, Cell dest) {
        return false;
    }
}

//Similarly all other pieces are inherited
class Person {
    String userId;
    String name;
    String email;
    String password;

}
class Player {
    Person person;
    Color color;
    Stack<Cell> stack;

    public Player(Person person, Color color, Stack<Cell> stack) {
        this.person = person;
        this.color = color;
        this.stack = new Stack<>();
    }
    void addMove(Cell cell) {
        this.stack.add(cell);
    }
}

class Game {

    int gameId;
    List<Player>playerList;
    int currentTurn;
    Board board;
    Game() {
        playerList= new ArrayList<>();
        board = new Board();
        currentTurn=0;
    }
    void startGame() {
        board.initializeBoard();
        while(true) {
            Player currentPlayer  = playerList.get(currentTurn);
            Cell src = board.cells[0][0];
            Cell dest = board.cells[0][5];
            Piece piece = src.getPiece();
            boolean isPossible  = piece.canMove(board,src,dest);
            currentPlayer.addMove(src);
            currentTurn=(currentTurn+1)%2;
        }
    }
}



public class main {
}
