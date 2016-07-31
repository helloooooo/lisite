package com.bruce.onlinetest.huawei;

import java.util.Scanner;

/**
 * Created by wuteng1 on 2016/7/18.
 */
public class Shudu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int[][] board = new int[9][9];
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    board[i][j] = scanner.nextInt();
                }
            }
            solveSudoku(board);
            System.out.println("---------------");
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    if(j == 8){
                        System.out.println(board[i][j]);
                    }
                    else System.out.print(board[i][j] + " ");
                }
            }
        }

    }

    private static boolean checkValid(int[][] board, int row, int col){
        //check row
        for(int j = 0; j < 9; j++){
            if(j != col && board[row][j] == board[row][col])
                return false;
        }
        //check col
        for(int i = 0; i < 9; i++){
            if(i != row && board[i][col] == board[row][col])
                return false;
        }
        //check grid
        int gridRow = row / 3 * 3, gridCol = col / 3 * 3;
        for(int i =0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i + gridRow != row && j + gridCol != col && board[row][col] == board[i + gridRow][j + gridCol])
                    return false;
            }
        }
        return true;
    }
    private static boolean solveSudoku(int[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == 0){
                    for(int k = 1; k <= 9; k++){
                        board[i][j] = k;
                        if(checkValid(board, i, j) && solveSudoku(board)){
                            return true;
                        }
                        board[i][j] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
