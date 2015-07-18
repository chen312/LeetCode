package leetcode;

import java.util.Arrays;

/**
 * @author Sunshine
 */
public class Set_Matrix_Zeroes {
    // Use O(m+n) space
    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        
        int row[] = new int[matrix[0].length];
        int column[] = new int[matrix.length];
        
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    column[i] = 1;
                    row[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (column[i] == 1 || row[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
    
    // Use a constant space
    public static void setZeroes2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        boolean column = false;
        boolean row = false;
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                column = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                row = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (column){
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
        if (row){
            for (int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
    }
    
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3}, {4,0,6}, {0,5,7}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
