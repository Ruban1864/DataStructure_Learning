package Trees;

// 2331. Evaluate Boolean Binary Tree

public class EvaluateBooleanBinaryTree {

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

    // Main function
    public boolean evaluateTree(TreeNode root) {
        if (root == null) return false;
        return helper(root);
    }

    // Recursive helper
    private boolean helper(TreeNode root) {
        // Leaf nodes are always 0 (false) or 1 (true)
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (root.val == 2) { // OR
            return left || right;
        } else { // val == 3, AND
            return left && right;
        }
    }

    // Main method for local testing
    public static void main(String[] args) {
        EvaluateBooleanBinaryTree sol = new EvaluateBooleanBinaryTree();

        /*
              2 (OR)
             /   \
            1     3 (AND)
                 /   \
                0     1
        */
        TreeNode root = sol.new TreeNode(2);
        root.left = sol.new TreeNode(1);
        root.right = sol.new TreeNode(3);
        root.right.left = sol.new TreeNode(0);
        root.right.right = sol.new TreeNode(1);

        boolean result = sol.evaluateTree(root);
        System.out.println("Tree evaluates to: " + result); // Expected: true
    }
}

