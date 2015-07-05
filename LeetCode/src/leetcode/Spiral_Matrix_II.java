package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sunshine
 */
public class Spiral_Matrix_II {
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int UP = 4;
    
    public static void write(int[][] matrix, int x, int y, int direction, int count){
        matrix[x][y] = count;
        if (count == matrix.length * matrix.length)
            return;
        switch (direction){
        case RIGHT:
            if (y+1 < matrix[0].length && matrix[x][y+1] == 0)
                write(matrix, x, y+1, RIGHT, count+1);
            else
                write(matrix, x+1, y, DOWN, count+1);
            break;
        case DOWN:
            if (x+1 < matrix.length && matrix[x+1][y] == 0)
                write(matrix, x+1, y, DOWN, count+1);
            else
                write(matrix, x, y-1, LEFT, count+1);
            break;
        case LEFT:
            if (y-1 >= 0 && matrix[x][y-1] == 0)
                write(matrix, x, y-1, LEFT, count+1);
            else
                write(matrix, x-1, y, UP, count+1);
            break;
        case UP:
            if (x-1 >= 0 && matrix[x-1][y] == 0)
                write(matrix, x-1, y, UP, count+1);
            else
                write(matrix, x, y+1, RIGHT, count+1);
            break;
        }
    }
    public static int[][] generateMatrix(int n) {
        int result[][] = new int[n][n];
        if (n == 0)
            return result;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = 0;
        write(result, 0, 0, RIGHT, 1);
        return result;
    }
    
    public static void main(String[] args) {
        int n = 2;
        int result[][] = generateMatrix(n);
        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(result[i]));
    }
}
