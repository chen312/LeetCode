package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sunshine
 */
public class NQueens {
    
    public static boolean isValid(char[][] item, int x, int y, int n){
        for (int i = 0; i < n; i++){
            if (i != y && item[x][i] == 'Q'){
                return false;
            }
        }
        for (int i = 0; i < n; i++){
            if (i != x){
                if (item[i][y] == 'Q'){
                    return false;
                }
            }
        }
        // For queens on the diagonal line, we only need to consider the upper part
        for (int i = x-1, j = y-1; i>=0 && j>=0; i--, j--){
            if (item[i][j] == 'Q'){
                return false;
            }
        }
        for (int i = x-1, j = y+1; i>=0 && j<n; i--, j++){
            if (item[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        char item[][] = new char[n][n];
        
        if (n == 0)
            return result;
        helper(result, item, n, 0);
        return result;
    }
    
    public static void helper(List<List<String>> result, char[][] item, int n, int count){
        if (count == n){
            List<String> current = new ArrayList<String>();
            for (int i = 0; i < n; i++){
                String row = "";
                for (int j = 0; j < n; j++){
                    if (item[i][j] == 'Q')
                        row += item[i][j];
                    else
                        row += '.';
                }
                current.add(row);
            }
            result.add(current);
            return;
        }
        for (int i = 0; i < n; i++){
            if (isValid(item, count, i, n)){
                item[count][i] = 'Q';
                helper(result, item, n, count+1);
                item[count][i] = '.';
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
