package leetcode;

import java.util.Stack;

/**
 * @author Sunshine
 */
public class Largest_Rectangle_in_Histogram {
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
        int height[] = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }
}
