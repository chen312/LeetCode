
package leetcode;

/**
 * @author Sunshine
 */
public class Recover_Binary_Search_Tree {
    public static void recoverTree(TreeNode root) {
        // We use the restore[0] and [1] to restore the swap node
        // We use the restore[2] to restore the previous node
        TreeNode restore[] = new TreeNode[3];
        helper(root, restore);
        int temp = restore[0].val;
        restore[0].val = restore[1].val;
        restore[1].val = temp;
    }
    
    public static void helper(TreeNode root, TreeNode[] restore){
        if (root == null)
            return;
        helper(root.left, restore);
        if (restore[2] != null && root.val < restore[2].val){
            if (restore[0] == null){
                restore[0] = restore[2];
            }
            restore[1] = root;
        }
        restore[2] = root;
        helper(root.right, restore);
    }
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        
        recoverTree(node1);
        
    }
}
