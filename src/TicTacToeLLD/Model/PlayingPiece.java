package TicTacToeLLD.Model;

public class PlayingPiece {
    PieceType pieceType;

    PlayingPiece(PieceType pieceType) {
        this.pieceType=pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
