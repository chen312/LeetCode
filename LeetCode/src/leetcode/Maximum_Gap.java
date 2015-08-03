package leetcode;

/**
 * @author Sunshine
 */
public class Maximum_Gap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        if (nums.length == 2)
            return Math.abs(nums[0] - nums[1]);
        int max = nums[0], min = nums[0];
        for (int i : nums){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int gap = (max - min) / (nums.length - 1);
        gap += ((max - min) % (nums.length - 1) != 0 ? 1 : 0);
        int buckets[][] = new int[(max-min)/gap+1][2];
        for (int i = 0; i < buckets.length; i++){
            buckets[i][0] = Integer.MAX_VALUE;
            buckets[i][1] = Integer.MIN_VALUE;
        }
        for (int x : nums){
            int index = (x - min) / gap;
            if (x < buckets[index][0])
                buckets[index][0] = x;
            if (x > buckets[index][1])
                buckets[index][1] = x;
        }
        int maxGap = 0;
        int pre = 0;
        for (int i = 1; i < buckets.length; i++){
            if (buckets[i][0] != Integer.MAX_VALUE){
                maxGap = Math.max(maxGap, buckets[i][0] - buckets[pre][1]);
                pre = i;
            }
        }
        return maxGap;
    }
    
    public static void main(String[] args) {
        Maximum_Gap test = new Maximum_Gap();
        int nums[] = {1,5,7,8,6,2};
        System.out.println(test.maximumGap(nums));
    }
}
