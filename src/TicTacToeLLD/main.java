package TicTacToeLLD;

public class main {
    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.initializeGame();
        System.out.println("Let's Start the Game");
        ticTacToeGame.startGame();
    }
}
