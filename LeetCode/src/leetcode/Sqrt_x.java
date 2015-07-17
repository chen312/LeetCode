package leetcode;

/**
 * @author Sunshine
 */
public class Sqrt_x {
    public static int mySqrt(int x) {
        int low = 0, high = x/2 + 1;
        if (x == 1 || x == 0)
            return x;
        while (high >= low){
            int middle = (high + low) / 2;
            // We can not use middle * middle here, because it may bigger than the maximun value of integer.
            if (middle <= x / middle && (middle+1) > x / (middle+1))
                return middle;
            if (middle > x/middle)
                high = middle-1;
            else
                low = middle+1;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int x = 2147395600;
        System.out.println(mySqrt(x));
    }
}
