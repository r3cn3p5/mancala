package com.p31prime.mancala.model;

public class Board {

    private BoardSide sides[] = new BoardSide[2];

    public void play(int player, int pocket) {

        // player can only by 0 or 1

        // lets get the initial
        int stones = 0;
        stones = sides[player].pockets[pocket];
        sides[player].pockets[pocket] = 0;

        // ok we have some stones lets keep moving

        while (stones > 0) {

            // increase pocket

            // drop stone
               // next cell
               // store


        }



    }

    // start is zero index
    private int move(BoardSide , int stones, int start) {

        for (int p=start; p < 6; p++) {

            pockets[p] += 1;
            stones--;

            if (stones==0)
                break;
        }

        return stones;
    }

}
