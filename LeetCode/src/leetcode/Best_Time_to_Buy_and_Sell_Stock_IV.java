package leetcode;

/**
 *
 * @author Sunshine
 */
public class Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        if (k > prices.length/2){
            int result = 0;
            for (int i = 1; i < prices.length; i++){
                if (prices[i] > prices[i-1])
                    result += (prices[i] - prices[i-1]);
            }
            return result;
        }
        int local[] = new int[k+1];
        int global[] = new int[k+1];
        for (int i = 0; i < prices.length-1; i++){
            int diff = prices[i+1] - prices[i];
            for (int j = k; j >= 1; j--){
                local[j] = Math.max(global[j-1] + (diff>0 ? diff : 0), local[j]+diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }
    
    public static void main(String[] args) {
        int prices[] = {1,2,5,7,9,6,5,2};
        Best_Time_to_Buy_and_Sell_Stock_IV test = new Best_Time_to_Buy_and_Sell_Stock_IV();
        System.out.println(test.maxProfit(3, prices));
    }
}
