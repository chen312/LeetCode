package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunshine
 */
public class Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        StringBuilder item = new StringBuilder();
        List<Integer> restore = new ArrayList<Integer>();
        if (nums.length == 0)
            return result;
        restore.add(nums[0]);
        item.append(nums[0]);
        for (int i = 1; i < nums.length; i++){
            if (restore.size() == 1){
                if (nums[i] - restore.get(0) == 1)
                    restore.add(nums[i]);
                else{
                    result.add(item.toString());
                    item.delete(0, item.length());
                    item.append(nums[i]);
                    restore.clear();
                    restore.add(nums[i]);
                }
            }
            else{
                if (nums[i] - restore.get(1) == 1){
                    restore.remove(1);
                    restore.add(nums[i]);
                }
                else{
                    item.append("->");
                    item.append(restore.get(1));
                    result.add(item.toString());
                    item.delete(0, item.length());
                    item.append(nums[i]);
                    restore.clear();
                    restore.add(nums[i]);
                }
            }
        }
        if (restore.size() == 1)
            result.add(item.toString());
        else{
            item.append("->");
            item.append(restore.get(1));
            result.add(item.toString());
        }
        return result;
    }
    
    public static void main(String[] args) {
        Summary_Ranges test = new Summary_Ranges();
        int nums[] = {0,1,2,4,5,7};
        System.out.println(test.summaryRanges(nums));
    }
}
