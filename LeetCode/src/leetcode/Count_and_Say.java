package leetcode;

/**
 *
 * @Sunshine
 */
public class Count_and_Say {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++){
            String temp = new String(result);
            result = "";
            int count = 0;
            for (int j = 0; j < temp.length(); j++){
                count++;
                if (j != temp.length()-1 && temp.charAt(j) != temp.charAt(j+1)){
                    result += count;
                    result += temp.charAt(j);
                    count = 0;
                }
            }
            result += count;
            result += temp.charAt(temp.length()-1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        Count_and_Say test = new Count_and_Say();
        int n = 4;
        System.out.println(test.countAndSay(n));
    }
}
