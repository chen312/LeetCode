package leetcode;

import java.util.HashMap;

/**
 * @author Sunshine
 */
public class Fraction_to_Recurring_Decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        HashMap<Long, Integer> record = new HashMap<Long, Integer>();
        long n = numerator;
        long d = denominator;
        if (n % d == 0){
            result.append(String.valueOf(n / d));
            return result.toString();
        }
        if ((d > 0 && n < 0) || (d < 0 && n > 0))
            result.append("-");
        if (n < 0)
            n = Math.abs(n);
        if (d < 0)
            d = Math.abs(d);
        if (d > n)
            result.append("0.");
        else {
            result.append(String.valueOf(n / d));
            result.append(".");
        }
        
        return helper(result, n % d * 10, d, record, result.length());
    }
    
    public String helper(StringBuilder result, long numerator, long denominator, HashMap<Long, Integer> record, int pos){
        //System.out.println("n:" + numerator + " d:" + denominator);
        long newNumerator = numerator % denominator * 10;
        if (newNumerator == 0){
            result.append(String.valueOf(numerator / denominator));
            return result.toString();
        }
        else{
            if (record.containsKey(numerator)){
                result.insert(record.get(numerator), "(");
                result.append(")");
                return result.toString();
            }
            else{
                record.put(numerator, pos);
                result.append(String.valueOf(numerator / denominator));
                return helper(result, newNumerator, denominator, record, pos+1);
            }
        }
    }
    
    public static void main(String[] args) {
        Fraction_to_Recurring_Decimal test = new Fraction_to_Recurring_Decimal();
        int numerator = -2147483648;
        int denominator = -1;
        System.out.println(test.fractionToDecimal(numerator, denominator));
    }
}
