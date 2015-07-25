package leetcode;

/**
 * @author Sunshine
 */
public class Same_Tree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            if (p == q)
                return true;
            else
                return false;
        }
        
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public static void main(String[] args) {
        
    }
}
