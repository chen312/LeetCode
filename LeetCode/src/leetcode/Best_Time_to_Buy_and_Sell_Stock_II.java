package leetcode;

/**
 * @author Sunshine
 */
public class Best_Time_to_Buy_and_Sell_Stock_II {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int result = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i-1])
                result += (prices[i] - prices[i-1]);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int prices[] = {1,2,5,7,9,6,5,2};
        System.out.println(maxProfit(prices));
    }
}
