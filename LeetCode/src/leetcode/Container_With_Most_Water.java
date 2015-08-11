package leetcode;

/**
 * @author Sunshine
 */
public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        if (height.length == 0)
            return 0;
        int l = 0, r = height.length-1, max = 0;
        while (l < r){
            max = Math.max(max, Math.min(height[l], height[r]) * (r-l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return max;
    }
}
