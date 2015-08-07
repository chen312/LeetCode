package leetcode;

/**
 * @author Sunshine
 */
public class Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        if (countLeft(root.left) == countRight(root.right))
            return (1 << countLeft(root))-1;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    public int countLeft(TreeNode root){
        int h = 0;
        while (root != null){
            root = root.left;
            h++;
        }
        return h;
    }
    
    public int countRight(TreeNode root){
        int h = 0;
        while (root != null){
            root = root.right;
            h++;
        }
        return h;
    }
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        
        Count_Complete_Tree_Nodes test = new Count_Complete_Tree_Nodes();
        System.out.println(test.countNodes(node1));
    }
}
