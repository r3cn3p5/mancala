package com.p31prime.mancala.model;

public class Board {

    private BoardSide sides[] = new BoardSide[2];

    public Board() {
        for (int s=0; s<2 ; s++)
            sides[s] = new BoardSide();
    }

    public void play(int player, int pocket) {

        // player can only by 0 or 1
        int side = player;

        // lets get the initial
        int stones = 0;
        stones = sides[side].pockets[pocket];
        sides[side].pockets[pocket] = 0;
        pocket++;

        // ok we have some stones lets keep moving

        while (stones > 0) {

            if (pocket >= 6) {

                // drop into store if players side
                if (side == player)
                    sides[side].store++;

                stones--;
                pocket = 0;

                // switch sides and continue
                side = side==0 ? 1: 0;

                continue;
            }

            if (side == player && stones == 1 && sides[side].pockets[pocket] == 0) {
                sides[side].store++;
                sides[side].pockets[pocket] = 0;

                sides[side].store = sides[side==0 ? 1: 0].pockets[pocket];
                sides[side==0 ? 1: 0].pockets[pocket] = 0;

            } else {
                sides[side].pockets[pocket]++;
            }

            stones--;
            pocket++;

        }

    }

    public boolean detectEndGame() {

        return false;
    }

    public void printBoard() {

        for (int s=0; s<2; s++) {

            System.out.print("S(" + sides[s].store + ") ");

            for (int p=0; p < 6; p++)
                System.out.print("P"+p+"("+sides[s].pockets[p]+")");

            System.out.println();

        }
    }

}
