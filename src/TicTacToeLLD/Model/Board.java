package TicTacToeLLD.Model;

public class Board {
    int size;
    PlayingPiece [][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }
    public boolean isBoardFull() {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(board[i][j]==null)
                    return false;
            }
        }
        return true;
    }

    public Boolean isCellValid(int row, int col) {
        if(row <0 || row>=size || col<0 || col>size || board[row][col]!=null)
            return false;
        return true;
    }

    public void addCell(int row, int col, PlayingPiece playingPiece) {
        board[row][col]=playingPiece;
    }

    public void printBoard() {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(board[i][j]==null) {
                    System.out.print(" |");
                } else
                    System.out.print(board[i][j].getPieceType()+"|");
            }
            System.out.println();
        }
    }

    public Boolean checkForTheWinner(PlayingPiece playingPiece) {
        Boolean winner = false;
        for(int i=0;i<size;i++) {
            int rowCount=0;
            int colCount=0;
            for(int j=0;j<size;j++) {
                if(board[i][j]!=null && board[i][j].getPieceType().equals(playingPiece.getPieceType())) {
                    rowCount++;
                }
                if(board[j][i]!=null && board[j][i].getPieceType().equals(playingPiece.getPieceType())) {
                    colCount++;
                }
            }
            if(rowCount==size || colCount==size)
                winner=true;
        }
        int diagonalCount=0,crossDiagonalCount=0;
        for(int i=0;i<size;i++) {
            if(board[i][i]!=null && board[i][i].getPieceType().equals(playingPiece.getPieceType())) {
                diagonalCount++;
            }
            if(board[i][size-i-1]!=null && board[i][size-i-1].getPieceType().equals(playingPiece.getPieceType())) {
                crossDiagonalCount++;
            }
        }
        if(diagonalCount==size || crossDiagonalCount==size)
            winner=true;
        return winner;
    }
}
