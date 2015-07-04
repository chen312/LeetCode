package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunshine
 */
public class Spiral_Matrix {
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int UP = 4;
    
    public static void read(List<Integer> result, int[][] matrix, boolean[][] used, int x, int y, int direction, int count){
        result.add(matrix[x][y]);
        used[x][y] = true;
        if (count == matrix.length * matrix[0].length)
            return;
        switch (direction){
        case RIGHT:
            if (y+1 < matrix[0].length && !used[x][y+1])
                read(result, matrix, used, x, y+1, RIGHT, count+1);
            else
                read(result, matrix, used, x+1, y, DOWN, count+1);
            break;
        case DOWN:
            if (x+1 < matrix.length && !used[x+1][y])
                read(result, matrix, used, x+1, y, DOWN, count+1);
            else
                read(result, matrix, used, x, y-1, LEFT, count+1);
            break;
        case LEFT:
            if (y-1 >= 0 && !used[x][y-1])
                read(result, matrix, used, x, y-1, LEFT, count+1);
            else
                read(result, matrix, used, x-1, y, UP, count+1);
            break;
        case UP:
            if (x-1 >= 0 && !used[x-1][y])
                read(result, matrix, used, x-1, y, UP, count+1);
            else
                read(result, matrix, used, x, y+1, RIGHT, count+1);
            break;
        }
    }
    
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (matrix.length == 0)
            return result;
        
        boolean used[][] = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                used[i][j] = false;
        
        read(result, matrix, used, 0, 0, RIGHT, 1);
        return result;
    }
    
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
