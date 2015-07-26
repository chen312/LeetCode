package leetcode;

import java.util.HashMap;

/**
 * @author Sunshine
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0)
            return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
    }
    
    public static TreeNode helper(int[] postorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer,Integer> map){
        if (preL > preR || inL > inR)
            return null;
        TreeNode root = new TreeNode(postorder[preR]);
        int index = map.get(root.val);
        root.left = helper(postorder, preL, preL+index-inL-1, inorder, inL, index-1, map);
        root.right = helper(postorder, preL+index-inL, preR-1, inorder, index+1, inR, map);
        return root;
    }
    
    public static void main(String[] args) {
        
    }
}
