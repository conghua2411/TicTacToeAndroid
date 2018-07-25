package com.funnything.hoangcong.tic_tac_toe.tic_tac_toe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class gameBoard {

    public String[][] board;

    public gameBoard() {
        board = new String[3][];
        board[0] = new String[]{"", "", ""};
        board[1] = new String[]{"", "", ""};
        board[2] = new String[]{"", "", ""};
    }

    public gameBoard(gameBoard game) {
        board = new String[3][];

        board[0] = new String[]{"", "", ""};
        board[1] = new String[]{"", "", ""};
        board[2] = new String[]{"", "", ""};

        for(int i = 0 ; i < 3 ; i++) {
            for(int j = 0 ; j < 3 ; j++) {
                board[i][j] = game.board[i][j];
            }
        }
    }

    public void reset() {
        board = new String[3][];
        board[0] = new String[]{"", "", ""};
        board[1] = new String[]{"", "", ""};
        board[2] = new String[]{"", "", ""};
    }

    public void setPos(int x, int y, String type) {
        board[x][y] = type;
    }

    private boolean isFull() {
        for(int i = 0 ; i < 3 ; i++) {
            for(int j = 0 ; j < 3 ; j++) {
                if(board[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkInArray(String[] array, String type) {
        int x;
        int y;
        for (String str: array) {
            x = Integer.parseInt(str)/10;
            y = Integer.parseInt(str)%10;
            if (!board[x][y].equals(type)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkTypeWin(String type) {

        // 00,01,02
        // 10,11,12
        // 20,21,22
        // 00,10,20
        // 01,11,21
        // 02,12,22
        // 00,11,22
        // 02,11,00

        List<List<String>> WinCase = new ArrayList<>();
        WinCase.add(Arrays.asList("00","01","02"));
        WinCase.add(Arrays.asList("10","11","12"));
        WinCase.add(Arrays.asList("20","21","22"));
        WinCase.add(Arrays.asList("00","10","20"));
        WinCase.add(Arrays.asList("01","11","21"));
        WinCase.add(Arrays.asList("02","12","22"));
        WinCase.add(Arrays.asList("00","11","22"));
        WinCase.add(Arrays.asList("02","11","20"));

        for(int i = 0 ; i < 8 ; i++) {
            if(checkInArray(WinCase.get(i).toArray(new String[0]),type)) {
                return true;
            }
        }

        return false;
    }

    public int checkWin() {
        if(checkTypeWin("X")) {
            return 1;
        } else if(checkTypeWin("O")) {
            return -1;
        } else {
            if(isFull()) {
                return 0;
            }
            else {
                return -2;
            }
        }
    }
}
