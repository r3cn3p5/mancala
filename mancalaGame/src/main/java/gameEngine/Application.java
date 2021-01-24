package gameEngine;

public class Application {
    public static void main(String[] args) {
        Board board = new Board();

        board.play(0,3);

        board.printBoard();
    }
}
