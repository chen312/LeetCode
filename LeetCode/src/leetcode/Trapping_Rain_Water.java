package leetcode;

/**
 *
 * @Sunshine
 */
public class Trapping_Rain_Water {
    
    // Time complexity: O(2 * n)
    public int trap(int[] height) {
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++){
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        
        max = 0;
        for (int i = height.length-1; i >= 0; i--){
            max = Math.max(max, height[i]);
            right[i] = max;
        }
        
        int result = 0;
        for (int i = 0; i < height.length; i++){
            int cur = Math.min(left[i], right[i]);
            result += (cur - height[i]);
        }
        return result;
    }
    
    // Time complexity: O(n)
    public int trap2(int[] height) {
        if (height.length == 0)
            return 0;
        int l = 0, r = height.length-1, result = 0;
        while (l < r){
            int min = Math.min(height[l], height[r]);
            if (height[l] < height[r]){
                l++;
                while (l < r && height[l] < min){
                    result += (min - height[l]);
                    l++;
                }
            }
            else{
                r--;
                while (l < r && height[r] < min){
                    result += (min - height[r]);
                    r--;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Trapping_Rain_Water test = new Trapping_Rain_Water();
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(test.trap(height));
    }
}
