import java.util.Stack;

public class Solution {
    public boolean isSymmetric2(TreeNode root) {
        if(root == null)
            return true;

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;

        if(left == null || right == null)
            return false;

        if(left.val != right.val)
            return false;

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.empty()) {

            TreeNode leftNode = stack.pop();
            TreeNode rightNode = stack.pop();

            if (leftNode == null && rightNode == null) {
                continue;
            }

            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }

            stack.push(leftNode.left);
            stack.push(rightNode.right);
            stack.push(leftNode.right);
            stack.push(rightNode.left);
        }
        return true;
    }


}
