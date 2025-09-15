package Trees;
// 113. Path Sum II
import java.util.*;
public class PathSum2 {
    // Inner TreeNode class
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // Main function to return all root-to-leaf paths with given sum
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        helper(root, targetSum, currentPath, result);
        return result;
    }
    // Recursive DFS helper
    private void helper(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        // Check leaf
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(path));
        } else {
            helper(node.left, targetSum - node.val, path, result);
            helper(node.right, targetSum - node.val, path, result);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }

    // Main method for local testing
    public static void main(String[] args) {
        PathSum2 sol = new PathSum2();

        /*
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \    / \
            7    2  5   1
        */
        TreeNode root = sol.new TreeNode(5);
        root.left = sol.new TreeNode(4);
        root.right = sol.new TreeNode(8);
        root.left.left = sol.new TreeNode(11);
        root.left.left.left = sol.new TreeNode(7);
        root.left.left.right = sol.new TreeNode(2);
        root.right.left = sol.new TreeNode(13);
        root.right.right = sol.new TreeNode(4);
        root.right.right.left = sol.new TreeNode(5);
        root.right.right.right = sol.new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> paths = sol.pathSum(root, targetSum);

        System.out.println("Paths with sum " + targetSum + ": " + paths);
    }
}
