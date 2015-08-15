package leetcode;

/**
 *
 * @Sunshine
 */
public class Multiply_Strings {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0)
            return "";
        while (num1.length() > 1 && num1.charAt(0) == '0')
            num1 = num1.substring(1);
        while (num2.length() > 1 && num2.charAt(0) == '0')
            num2 = num2.substring(1);
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int product[] = new int[num1.length()+num2.length()+1];
        int carry = 0;
        for (int i = 0; i < num2.length(); i++){
            int n2 = num2.charAt(i) - '0';
            for (int j = 0; j < num1.length(); j++){
                int n1 = num1.charAt(j) - '0';
                int sum = product[i+j] + n2*n1 + carry;
                product[i+j] = sum % 10;
                carry = sum / 10;
            }
            if (carry > 0)
                product[i+num1.length()] = carry;
            carry = 0;
        }
        String result = "";
        int cur = product.length-1;
        while (cur >= 0 && product[cur] == 0)
            cur--;
        if (cur < 0)
            return "0";
        while (cur >= 0){
            result += product[cur];
            cur--;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Multiply_Strings test = new Multiply_Strings();
        String num1 = "4";
        String num2 = "25";
        System.out.println(test.multiply(num1, num2));
    }
}
