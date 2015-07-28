package leetcode;

/**
 * @author Sunshine
 */
public class Best_Time_to_Buy_and_Sell_Stock_III {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int min = prices[0];
        int result1[] = new int[prices.length];
        int result2[] = new int[prices.length];
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < min)
                min = prices[i];
            if (prices[i] - min > result1[i-1])
                result1[i] = prices[i] - min;
            else
                result1[i] = result1[i-1];
        }
        int max = prices[prices.length-1];
        for (int i = prices.length-2; i >= 0; i--){
            if (prices[i] > max)
                max = prices[i];
            if (max - prices[i] > result2[i+1])
                result2[i] = max - prices[i];
            else
                result2[i] = result2[i+1];
        }
        max = 0;
        for (int i = 0; i < prices.length; i++)
            if (result1[i] + result2[i] > max)
                max = result1[i] + result2[i];
        return max;
    }
    
    public static void main(String[] args) {
        int prices[] = {1,2,5,7,9,6,5,2};
        System.out.println(maxProfit(prices));
    }
}
