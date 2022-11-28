public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isEqualNode(p, q);
    }

    boolean isEqualNode(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;

        if(p.val != q.val)
            return false;

        return isEqualNode(p.left, q.left) && isEqualNode(p.right, q.right);
    }
}
