package leetcode;

/**
 * @author Sunshine
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < min)
                min = prices[i];
            if (prices[i] - min > profit)
                profit = prices[i] - min;
        }
        return profit;
    }
    
    public static void main(String[] args) {
        int prices[] = {1,2,5,7,9,6,5,2};
        System.out.println(maxProfit(prices));
    }
}
