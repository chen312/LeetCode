package leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Sunshine
 */
public class Unique_Binary_Search_Trees_II {
    public static List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    public static List<TreeNode> helper(int left, int right){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (left > right){
            result.add(null);
            return result;
        }
        for (int i = left; i <= right; i++){
            List<TreeNode> leftList = helper(left, i-1);
            List<TreeNode> rightList = helper(i+1, right);
            for (int j = 0; j < leftList.size(); j++){
                for (int k = 0; k < rightList.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateTrees(n));
    }
}
