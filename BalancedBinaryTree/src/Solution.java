import com.sun.source.tree.Tree;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);

        if(Math.abs(lHeight - rHeight) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    int getHeight(TreeNode node) {
        if(node == null)
            return 0;

        return Math.max(getHeight(node.left) + 1, getHeight(node.right) + 1) ;
    }

}
