package leetcode;

/**
 * @author Sunshine
 */
public class Edit_Distance {
    // Use DP
    public static int minDistance(String word1, String word2) {
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();
        int result[][] = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++)
            result[i][0] = i;
        for (int i = 0; i <= word2.length(); i++)
            result[0][i] = i;
        for (int i = 0; i < word1.length(); i++){
            for (int j = 0; j < word2.length(); j++){
                if (word1.charAt(i) == word2.charAt(j))
                    result[i+1][j+1] = result[i][j];
                else
                    result[i+1][j+1] = Math.min(result[i][j], Math.min(result[i][j+1], result[i+1][j]))+1;
            }
        }
        return result[word1.length()][word2.length()];
    }
    
    public static void main(String[] args) {
        String word1 = "abv", word2 = "dse";
        System.out.println(minDistance(word1, word2));
    }
}
