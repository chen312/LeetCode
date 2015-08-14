package leetcode;

import java.util.HashSet;

/**
 *
 * @Sunshine
 */
public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int row = 0; row < 9; row++){
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
        }
        
        for (int col = 0; col < 9; col++){
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
        }
        
        for (int row = 0; row < 7; row = row+3){
            for (int col = 0; col < 7; col = col+3){
                set.clear();
                for (int i = row; i < row+3; i++){
                    for (int j = col; j < col+3; j++){
                        if (Character.isDigit(board[i][col])){
                            int cur = board[i][col] - '0';
                            if (set.contains(cur))
                                return false;
                            else
                                set.add(cur);
                        }
                    }
                }
            }
        }
        return true;
    }
}
