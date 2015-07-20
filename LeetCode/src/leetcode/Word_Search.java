package leetcode;

/**
 * @author Sunshine
 */
public class Word_Search {
    public static boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        if (board.length == 0 || board[0].length == 0)
            return false;
        boolean record[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0))
                    if (find(board, record, i, j, word, 0))
                        return true;
            }
        }
        return false;
    }
    
    public static boolean find(char[][] board, boolean[][] record, int x, int y, String word, int len){
        if (len == word.length())
            return true;
        if ((x>=0 && x<board.length) && (y>=0 && y<board[0].length) && board[x][y] == word.charAt(len) && record[x][y] != true){
            record[x][y] = true;
            boolean result = find(board, record, x+1, y, word, len+1) || find(board, record, x-1, y, word, len+1)
                    || find(board, record, x, y+1, word, len+1) || find(board, record, x, y-1, word, len+1);
            record[x][y] = false;
            return result;
        }
        else{
            return false;
        }
    }
    
    public static void main(String[] args) {
        char board[][] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        System.out.println(exist(board, word));
    }
}
