package leetcode;

import java.util.Arrays;

/**
 * @author Sunshine
 */
public class Merge_Sorted_Array {
    // Space complexity is O(n)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int temp[] = new int[m+n];
        while (i < m && j < n){
            if (nums1[i] < nums2[j]){
                temp[i+j] = nums1[i];
                i++;
            }
            else{
                temp[i+j] = nums2[j];
                j++;
            }
        }
        while (i < m){
            temp[i+j] = nums1[i];
            i++;
        }
        while (j < n){
            temp[i+j] = nums2[j];
            j++;
        }
        for (int k = 0; k < temp.length; k++)
            nums1[k] = temp[k];
    }
    
    // Space complexity is O(1)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0)
            return;
        int i1 = m-1, i2 = n-1, len = m+n-1;
        while (i1 >= 0 && i2 >= 0){
            if (nums1[i1] > nums2[i2])
                nums1[len--] = nums1[i1--];
            else
                nums1[len--] = nums2[i2--];
        }
        while (i2 >= 0)
            nums1[len--] = nums2[i2--];
    }
    
    public static void main(String[] args) {
        int nums1[] = new int[5];
        int nums2[] = {3,4};
        nums1[0] = 1;
        nums1[1] = 2;
        nums1[2] = 5;
        merge2(nums1, 3, nums2, 2);
        System.out.println(Arrays.toString(nums1));
    }
}
