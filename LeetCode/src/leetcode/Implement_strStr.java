package leetcode;

/**
 *
 * @Sunshine
 */
public class Implement_strStr {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || needle.length() == 0)
            return 0;
        int len = needle.length();
        for (int i = 0; i + len <= haystack.length(); i++){
            if (compare(haystack.substring(i, i+len), needle))
                return i;
        }
        return -1;
    }
    
    public boolean compare(String a, String b){
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                return false;
        return true;
    }
    
    // KMP
    public int strStr2(String haystack, String needle) {
        int i = 0, j = 0;
        int next[] = getNext(needle);
        while (i < haystack.length() && j < needle.length()){
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else
                j = next[j];
        }
        if (j == needle.length())
            return i-j;
        else
            return -1;
    }
    
    public int[] getNext(String p){
        int next[] = new int[p.length()];
        next[0] = -1;
        int k = -1, j = 0;
        while (j < p.length()-1){
            if (k == -1 || p.charAt(j) == p.charAt(k)){
                ++j;
                ++k;
                if (p.charAt(j) != p.charAt(k))
                    next[j] = k;
                else
                    next[j] = next[k];
            }
            else{
                k = next[k];
            }
        }
        return next;
    }
    
    public static void main(String[] args) {
        Implement_strStr test = new Implement_strStr();
        String haystack = "mississippi";
        String needle = "pi";
        System.out.println(test.strStr2(haystack, needle));
    }
}
