package leetcode;

/**
 * @author Sunshine
 */
public class Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if ((len1 + len2) % 2 == 1)
            return helper(nums1, 0, len1-1, nums2, 0, len2-1, (len1+len2)/2);
        else
            return (helper(nums1, 0, len1-1, nums2, 0, len2-1, (len1+len2)/2) + helper(nums1, 0, len1-1, nums2, 0, len2-1, (len1+len2)/2-1)) * 0.5;
    }
    
    public double helper(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        
        if (len1 == 0)
            return nums2[start2+k];
        if (len2 == 0)
            return nums1[start1+k];
        if (k == 0)
            return Math.min(nums1[start1], nums2[start2]);
        
        int mid1 = len1 * k / (len1+len2);
        int mid2 = k - 1 - mid1;
        mid1 += start1;
        mid2 += start2;
        
        if (nums1[mid1] > nums2[mid2]){
            k -= (mid2 - start2 + 1);
            end1 = mid1;
            start2 = mid2+1;
        }
        else{
            k -= (mid1 - start1 + 1);
            start1 = mid1+1;
            end2 = mid2;
        }
        
        return helper(nums1, start1, end1, nums2, start2, end2, k);
    }
    
    public static void main(String[] args) {
        Median_of_Two_Sorted_Arrays test = new Median_of_Two_Sorted_Arrays();
        int nums1[] = {1,3,4,7,9};
        int nums2[] = {2,5,6,8};
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }
}
