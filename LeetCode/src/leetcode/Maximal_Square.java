package leetcode;

import java.util.LinkedList;

/**
 * @author Sunshine
 */
public class Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int max = 0;
        int height[] = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                height[j] = (matrix[i][j] == '0' ? 0 : height[j]+1);
            }
            max = Math.max(max, largestSquareArea(height));
        }
        return max;
    }
    
    public int largestSquareArea(int[] height){
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int index = stack.pop();
                int area;
                if (stack.isEmpty())
                    area = (int)Math.pow(Math.min(i, height[index]), 2);
                else
                    area = (int)Math.pow(Math.min(i-stack.peek()-1, height[index]), 2);
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
                int area;
                if (stack.isEmpty())
                    area = (int)Math.pow(Math.min(height.length, height[index]), 2);
                else
                    area = (int)Math.pow(Math.min(height.length-stack.peek()-1, height[index]), 2);
                max = Math.max(max, area);
        }
        return max;
    }
    
    // DP
    public int maximalSquare2(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int max = 0;
        int dp[][] = new int[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == '1'){
                dp[i][0] = 1;
                max = 1;
            }
        }
        
        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == '1'){
                dp[0][i] = 1;
                max = 1;
            }
        }
        
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == '0')
                    dp[i][j] = 0;
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
