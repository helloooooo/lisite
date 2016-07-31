package com.bruce.leetcode;

/**
 * Created by wuteng1 on 2016/7/18.
 */
public class SudokuSolver37 {
    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board){
        //find one is ok
        solveSudokuSingle(board);
    }

    public boolean solveSudokuSingle(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(int k = 1; k <= 9; k++){
                        board[i][j] = (char)('0' + k);
                        if(checkValid(board, i, j) && solveSudokuSingle(board))
                            return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkValid(char[][] board, int row, int col){
        //check col
        for(int i = 0; i < 9; i++){
            if(i != row && board[i][col] == board[row][col])
                return false;
        }
        //check row
        for(int j = 0; j < 9; j++){
            if(j != col && board[row][j] == board[row][col])
                return false;
        }
        //check small matrix
        int rownum = row / 3 * 3, colnum = col / 3 * 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i + rownum != row && j + colnum != col && board[row][col] == board[rownum+i][colnum+j]){
                    return false;
                }
            }
        }
        return true;

    }
}
