package leetcode;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Sunshine
 */
public class Longest_Consecutive_Sequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int result = 0;
        for (int i = 0 ; i < nums.length; i++)
            set.add(nums[i]);
        while (!set.isEmpty()){
            Iterator iter = set.iterator();
            int item = (Integer)iter.next();
            int max= item, min = item, count = 1;
            set.remove(item);
            while (set.contains(min-1)){
                count++;
                min--;
                set.remove(min);
            }
            while (set.contains(max+1)){
                count++;
                max++;
                set.remove(max);
            }
            if (count > result)
                result = count;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int nums[] = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
