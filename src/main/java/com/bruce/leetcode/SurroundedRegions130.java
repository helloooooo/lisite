package com.bruce.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuteng1 on 2016/6/25.
 */
public class SurroundedRegions130 {
    static class Solution{
        public void solve(char[][] board){
            if(board == null || board.length <= 1)
                return;
            for(int i = 0; i < board.length; i++){
                flip(board, i, 0);
                flip(board, i, board[0].length-1);
            }
            for(int j = 0; j < board[0].length; j++){
                flip(board, 0, j);
                flip(board, board.length-1, j);
            }
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                    else if(board[i][j] == '#'){
                        board[i][j] = 'O';
                    }
                }
            }
        }
        public void flip(char[][] board, int i, int j){
            if(board[i][j] != 'O')
                return;
            board[i][j] = '#';
            LinkedList<Integer> list = new LinkedList<Integer>();
            Integer cur = i * board[0].length + j;
            list.offer(cur);
            while(!list.isEmpty()){
                cur = list.poll();
                int row = cur / board[0].length;
                int col = cur % board[0].length;
                if(row >= 1 && board[row-1][col] == 'O'){
                    board[row-1][col] = '#';
                    list.offer((row-1) * board[0].length + col);
                }
                if(col >= 1 && board[row][col - 1] == 'O'){
                    board[row][col-1] = '#';
                    list.offer(row*board[0].length + col-1);
                }
                if(row < board.length-1 && board[row + 1][col] == 'O'){
                    board[row+1][col] = '#';
                    list.offer((row+1)*board[0].length + col);
                }
                if(col < board[0].length-1 && board[row][col+1] == 'O'){
                    board[row][col+1] = '#';
                    list.offer(row*board[0].length + col + 1);
                }
            }
        }
    }
}
