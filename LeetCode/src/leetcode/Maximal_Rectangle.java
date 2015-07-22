package leetcode;

import java.util.Stack;

/**
 * @author Sunshine
 */
public class Maximal_Rectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int max = 0;
        int height[] = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                height[j] = matrix[i][j] == '0' ? 0 : height[j]+1;
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }
    
    public static int largestRectangleArea(int[] height) {
        int max = 0;
        class pair{
            int height;
            int index;
            public pair(int height, int index) {
                this.height = height;
                this.index = index;
            }
        }
        Stack<pair> stack = new Stack<pair>();
        for (int i = 0; i < height.length; i++){
            while (!stack.empty() && height[i] <= stack.peek().height){
                int index = stack.pop().index;
                int curArea = stack.isEmpty()? i*height[index] : (i-stack.peek().index-1)*height[index];
                max = Math.max(max, curArea);
            }
            stack.push(new pair(height[i], i));
        }
        while (!stack.isEmpty()){
            int index = stack.pop().index;
            int curArea = stack.isEmpty()? height.length*height[index] : (height.length-stack.peek().index-1)*height[index];
            max = Math.max(max, curArea);
        }
        return max;
    }
    
    public static void main(String[] args) {
        char matrix[][] = {{'1','1','0'}, {'1','1','1'}, {'1','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
