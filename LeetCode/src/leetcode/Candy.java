package leetcode;

/**
 * @author Sunshine
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0)
            return 0;
        int count[] = new int[ratings.length];
        count[0] = 1;
        for (int i = 1; i < ratings.length; i++){
            if (ratings[i] > ratings[i-1])
                count[i] = count[i-1] + 1;
            else
                count[i] = 1;
        }
        int sum = count[ratings.length-1];
        for (int i = ratings.length-2; i >= 0; i--){
            if (ratings[i] > ratings[i+1])
                count[i] = Math.max(count[i], count[i+1]+1);
            sum += count[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int ratings[] = {1,5,4,2,8,9,3};
        Candy test = new Candy();
        System.out.println(test.candy(ratings));
    }
}
