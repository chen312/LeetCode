package leetcode;

import java.util.HashSet;

/**
 *
 * @Sunshine
 */
public class Sudoku_Solver {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    
    public boolean helper(char[][] board, int i, int j){
        if (j >= 9)
            return helper(board, i+1, 0);
        if (i == 9)
            return true;
        if (board[i][j] == '.'){
            for (int num = 1; num <= 9; num++){
                board[i][j] = (char)(num+'0');
                if (isValid(board, i, j)){
                    if (helper(board, i, j+1))
                        return true;
                }
                board[i][j] = '.';
            }
        }
        else
            return helper(board, i, j+1);
        return false;
    }
    
    public boolean isValid(char[][] board, int row, int col){
        HashSet<Integer> set = new HashSet<Integer>();
        
        set.clear();
        for (int i = 0; i < 9; i++){
            if (Character.isDigit(board[row][i])){
                int cur = board[row][i] - '0';
                if (set.contains(cur))
                    return false;
                else
                    set.add(cur);
            }
        }
        
        set.clear();
        for (int i = 0; i < 9; i++){
            if (Character.isDigit(board[i][col])){
                int cur = board[i][col] - '0';
                if (set.contains(cur))
                    return false;
                else
                    set.add(cur);
            }
        }
        
        set.clear();
        for (int i = row/3; i < row/3+3; i++){
            for (int j = col/3; j < col/3+3; j++){
            if (Character.isDigit(board[i][j])){
                    int cur = board[i][j] - '0';
                    if (set.contains(cur))
                        return false;
                    else
                        set.add(cur);
                }
            }
        }
        return true;
    }
}
