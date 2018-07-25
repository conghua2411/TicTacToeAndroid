package com.funnything.hoangcong.tic_tac_toe.tic_tac_toe;


import java.util.Random;

public class bot {
    public bot() {

    }

    private int[] randomMove() {
        int[] ranMove = new int[] {-1,-1};

        Random rand = new Random();

        ranMove[0] = rand.nextInt(3);
        ranMove[1] = rand.nextInt(3);

        return ranMove;
    }

    public int[] makeMove(gameBoard game) {

        if(game.checkWin() == 0) {
            return new int[] {-1,-1};
        }

        if(game.board[1][1].equals("")) {
            return new int[] {1,1};
        }

        int[] move;

        gameBoard gameTemp;


        //check bot can win
        for(int i = 0 ; i < 3 ; i ++) {
            for(int j = 0 ; j < 3 ; j++) {
                if(game.board[i][j].equals("")) {

                    gameTemp = new gameBoard(game);

                    gameTemp.setPos(i,j,"O");
                    if(gameTemp.checkWin() == -1) {
                        move = new int[]{i,j};
                        return move;
                    }

                }
            }
        }

        //check player can win
        for(int i = 0 ; i < 3 ; i ++) {
            for(int j = 0 ; j < 3 ; j++) {
                if(game.board[i][j].equals("")) {

                    gameTemp = new gameBoard(game);

                    gameTemp.setPos(i,j,"X");
                    if(gameTemp.checkWin() == 1) {
                        move = new int[]{i,j};
                        return move;
                    }

                }
            }
        }

        // random move

        do {
            move = randomMove();
        }while (!game.board[move[0]][move[1]].equals(""));


        return move;
    }
}
