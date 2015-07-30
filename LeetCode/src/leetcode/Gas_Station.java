package leetcode;

/**
 * @author Sunshine
 */
public class Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        boolean restore[] = new boolean[gas.length];
        for (int i = 0; i < gas.length; i++){
            if (restore[i] != true && helper(i, gas, cost, restore) == gas.length){
                return i;
            }
        }
        return -1;
    }
    
    public int helper(int start, int[] gas, int[] cost, boolean[] restore){
        int remain = gas[start] - cost[start];
        int current = (start+1) % gas.length;
        restore[start] = true;
        while (current != start && remain >= 0){
            restore[current] = true;
            remain += (gas[current] - cost[current]);
            current = (current+1) % gas.length;
        }
        if (remain < 0)
            return current;
        return gas.length;
    }
    
    public static void main(String[] args) {
        //[1,2,3,3], [2,1,5,1]
        int gas[] = {1,2,3,3};
        int cost[] = {2,1,5,1};
        Gas_Station test = new Gas_Station();
        System.out.println(test.canCompleteCircuit(gas, cost));
    }
}
