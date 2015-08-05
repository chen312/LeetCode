package leetcode;

/**
 * @author Sunshine
 */
public class Count_Primes {
    public int countPrimes(int n) {
        if (n < 3)
            return 0;
        boolean mark[] = new boolean[n];
        for (int i = 2; i < n; i++){
            for (int j = 2; j * i < n; j++){
                if (!mark[j*i])
                    mark[j*i] = true;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++)
            if (mark[i] != true)
                count++;
        return count;
    }
    
    public static void main(String[] args) {
        Count_Primes test = new Count_Primes();
        int n = 32;
        System.out.println(test.countPrimes(n));
    }
}
