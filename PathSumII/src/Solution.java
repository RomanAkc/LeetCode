import java.util.*;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        traverse(root, targetSum, result, stack);

        return result;
    }

    public void traverse(TreeNode node, int targetSum, List<List<Integer>> result, Stack<Integer> stack) {
        if(node == null)
            return;

        targetSum -= node.val;
        stack.add(node.val);

        if(node.left == null && node.right == null && targetSum == 0) {
            result.add(stack.stream().toList());
            stack.pop();
            return;
        }

        traverse(node.left, targetSum, result, stack);
        traverse(node.right, targetSum, result, stack);

        stack.pop();
    }
}
