package leetcode;

/**
 * @author Sunshine
 */
public class Unique_Binary_Search_Trees {
    public static int numTrees(int n) {
        if (n < 3)
            return n;
        int result[] = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++){
            int count = 0;
            for (int j = i-1; j >= 0; j--){
                count += result[j]*result[i-j-1];
            }
            result[i] = count;
        }
        return result[n];
    }
    
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTrees(n));
    }
}
