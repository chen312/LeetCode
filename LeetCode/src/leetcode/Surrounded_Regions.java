package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Sunshine
 */
public class Surrounded_Regions {
    class Pos{
        int row;
        int col;
        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    public void solve(char[][] board) {
        if (board.length <= 1 || board[0].length <= 1)
            return;
        for(int i = 0; i < board.length; i++){
            fill(board, i, 0);
            fill(board, i, board[0].length-1);
        }
        for (int i = 0; i < board[0].length; i++){
            fill(board, 0, i);
            fill(board, board.length-1, i);
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    
    public void fill(char[][] board, int i, int j){
        if (board[i][j] != 'O')
            return;
        board[i][j] = '#';
        LinkedList<Pos> queue = new LinkedList<Pos>();
        queue.offer(new Pos(i, j));
        while (!queue.isEmpty()){
            Pos temp = queue.poll();
            int row = temp.row;
            int col = temp.col;
            if (row > 0 && board[row-1][col] == 'O'){
                queue.offer(new Pos(row-1, col));
                board[row-1][col] = '#';
            }
            if (row < board.length-1 && board[row+1][col] == 'O'){
                queue.offer(new Pos(row+1, col));
                board[row+1][col] = '#';
            }
            if (col > 0 && board[row][col-1] == 'O'){
                queue.offer(new Pos(row, col-1));
                board[row][col-1] = '#';
            }
            if (col < board[0].length-1 && board[row][col+1] == 'O'){
                queue.offer(new Pos(row, col+1));
                board[row][col+1] = '#';
            }
        }
    }
    
    public static void main(String[] args) {
        char board[][] = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        Surrounded_Regions test = new Surrounded_Regions();
        test.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
