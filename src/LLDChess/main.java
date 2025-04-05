package LLDChess;
//Board->cell->Piece(color)->player


import java.util.ArrayDeque;
import java.util.Queue;

class Board {
    Cell cell[][];
    Board() {
        this.cell = new Cell[8][8];
    }
}

class Cell {
    int row;
    int col;
    Piece piece;

    public Cell(Piece piece) {
        this.piece = piece;
    }
}

enum PieceColor {
    Black,White
}

abstract class Piece {
    //verifyMove,move
    PieceColor pieceColor;
    int row;
    int col;
}

class Rook extends Piece {


}
class Knight extends Piece {

}
class Camel extends Piece {

}
class Pawn extends Piece {

}
class King extends Piece {

}
class Queen extends Piece {

}

class Player {
    String playerId;
    String name;
    PieceColor playingPieceColor;
}



class Game {
    Board board;
    Queue<Player> players;
    Game() {
        board= new Board();
        players = new ArrayDeque<>();
    }


}
public class main {
}
