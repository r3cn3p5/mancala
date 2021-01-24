package gameEngine;

public class BoardSide {
    int pockets[] = new int[6];
    int store;

    BoardSide() {
        for (int x=0; x< pockets.length; x++)
            pockets[x] = 4;

        store = 0;

    }
}
