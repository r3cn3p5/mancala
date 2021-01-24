package gameEngine;

public class Board {

    private BoardSide sides[] = new BoardSide[2];

    public Board() {
        for (int s=0; s<2 ; s++)
            sides[s] = new BoardSide();
    }

    public boolean play(int player, int pocket) {

        boolean replay = false;

        // player can only by 0 or 1
        int side = player;

        // lets get the initial
        int stones = 0;
        stones = sides[side].pockets[pocket];
        sides[side].pockets[pocket] = 0;
        pocket++;

        while (stones > 0) {

            if (pocket >= 6) {

                // drop into store if players side
                if (side == player) {
                    sides[side].store++;

                    // last stone the player gets another go
                    replay = stones == 1 ? true : false;
                }

                stones--;
                pocket = 0;

                // switch sides and continue
                side = side==0 ? 1: 0;
                continue;
            }

            // if last stone on player pocket take other side.
            if (side == player && stones == 1 && sides[side].pockets[pocket] == 0) {
                sides[side].store++;
                sides[side].pockets[pocket] = 0;

                sides[side].store = sides[side==0 ? 1: 0].pockets[pocket];
                sides[side==0 ? 1: 0].pockets[pocket] = 0;
                break;
            }

            // standard old go.
            sides[side].pockets[pocket]++;
            stones--;
            pocket++;

        }

        // if one player has empty side then the other takes all there remaining stones.
        for (int s=0; s<2; s++ ) {

            int t=0;
            for (int p=0; p<6; p++)
                t+=sides[s].pockets[p];

            if (t==0) {
                for (int p=0; p<6; p++) {
                    t += sides[s == 0 ? 1 : 0].pockets[p];
                    sides[s == 0 ? 1 : 0].pockets[p] = 0;
                }
                sides[s==0 ? 1: 0].store += t;
                break;
            }
        }

        return replay;
    }

    public void printBoard() {

        System.out.format("S(%2d) ",sides[0].store);
        for (int p=5; p >= 0; p--)
            System.out.format("(%2d) ",sides[0].pockets[p]);
        System.out.println();

        System.out.print("      ");
        for (int p=0; p < 6; p++)
            System.out.format("(%2d) ",sides[1].pockets[p]);
        System.out.format("S(%2d)",sides[1].store);
        System.out.println();

    }

}
