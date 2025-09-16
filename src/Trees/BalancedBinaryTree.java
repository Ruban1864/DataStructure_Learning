package Trees;
//Leetcode : 110. Balanced Binary Tree
public class BalancedBinaryTree {

    // ✅ Inner TreeNode class
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ✅ Main function to check if tree is balanced
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // ✅ Helper function that returns height OR -1 if unbalanced
    private int checkHeight(TreeNode root) {
        if (root == null) return 0;

        int left = checkHeight(root.left);
        if (left == -1) return -1;  // left subtree unbalanced

        int right = checkHeight(root.right);
        if (right == -1) return -1; // right subtree unbalanced

        if (Math.abs(left - right) > 1) return -1; // current node unbalanced

        return Math.max(left, right) + 1;
    }

    // ✅ Example usage
    public static void main(String[] args) {
        BalancedBinaryTree sol = new BalancedBinaryTree();

        // Example 1: Balanced Tree
        //       3
        //      / \
        //     9  20
        //       /  \
        //      15   7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        System.out.println("Example 1 - Is Balanced? " + sol.isBalanced(root1));
        // Expected: true

        // Example 2: Unbalanced Tree
        //       1
        //      /
        //     2
        //    /
        //   3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);

        System.out.println("Example 2 - Is Balanced? " + sol.isBalanced(root2));
        // Expected: false
    }
}

