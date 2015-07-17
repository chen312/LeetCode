package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunshine
 */
public class Text_Justification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        if (words.length == 0)
            return result;
        int count = 0, last = 0;
        for (int i = 0; i < words.length; i++){
            if (count + words[i].length() + (i - last) > maxWidth){
                int spaceNum = 0, extraNum = 0;
                if ((i-1) - last > 0){
                    spaceNum = (maxWidth - count) / (i-1 - last);
                    extraNum = (maxWidth - count) % (i-1 - last);
                }
                StringBuilder str = new StringBuilder();
                for (int j = last; j < i; j++){
                    str.append(words[j]);
                    if (j < i-1){
                        for (int k = 0; k < spaceNum; k++)
                            str.append(" ");
                        if (extraNum > 0){
                            str.append(" ");
                            extraNum--;
                        }
                    }
                }
                for (int j = str.length(); j < maxWidth; j++)
                    str.append(" ");
                result.add(str.toString());
                count = 0;
                last = i;
            }
            count += words[i].length();
        }
        StringBuilder str = new StringBuilder();
        for (int i = last; i < words.length; i++){
            str.append(words[i]);
            if (str.length() < maxWidth)
                str.append(" ");
        }
        for (int i = str.length(); i < maxWidth; i++)
            str.append(" ");
        result.add(str.toString());
        return result;
    }
    
    public static void main(String[] args) {
        String words[] = {"a","b","c","d","e"};
        int maxWidth = 3;
        System.out.println(fullJustify(words, maxWidth));
    }
}
