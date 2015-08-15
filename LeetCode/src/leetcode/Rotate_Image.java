package leetcode;

import java.util.Arrays;

/**
 *
 * @author Sunshine
 */
public class Rotate_Image {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        int layerNum = matrix.length/2;
        for (int layer = 0; layer < layerNum; layer++){
            for (int i = layer; i < matrix.length - layer - 1; i++){
                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[matrix.length-i-1][layer];
                matrix[matrix.length-i-1][layer] = matrix[matrix.length-layer-1][matrix.length-i-1];
                matrix[matrix.length-layer-1][matrix.length-i-1] = matrix[i][matrix.length-layer-1];
                matrix[i][matrix.length-layer-1] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        Rotate_Image test = new Rotate_Image();
        int matrix[][] = {{1,1}, {2,2}};
        test.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
