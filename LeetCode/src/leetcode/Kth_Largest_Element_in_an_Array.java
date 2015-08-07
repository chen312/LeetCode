package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author Sunshine
 */
public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++)
            queue.offer(nums[i]);
        for (int i = 0; i < nums.length-k; i++){
            queue.remove();
        }
        return queue.peek();
    }
    
    public static void main(String[] args) {
        Kth_Largest_Element_in_an_Array test = new Kth_Largest_Element_in_an_Array();
        int nums[] = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(test.findKthLargest(nums, k));
    }
}
