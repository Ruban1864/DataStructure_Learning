package Trees;

// 112. Path Sum

public class PathSum {

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

    // Main function to check if path sum exists
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return helper(root, targetSum);
    }

    // Recursive helper
    private boolean helper(TreeNode root, int target) {
        if (root == null) return false;
        target -= root.val;
        // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            return target == 0;
        }
        return helper(root.left, target) || helper(root.right, target);
    }

    // Main method for local testing
    public static void main(String[] args) {
        PathSum sol = new PathSum();

        // Build test tree
        /*
                  5
                 / \
                4   8
               /   / \
              11  13  4
             /  \      \
            7    2      1
        */
        TreeNode root = sol.new TreeNode(5);
        root.left = sol.new TreeNode(4);
        root.right = sol.new TreeNode(8);
        root.left.left = sol.new TreeNode(11);
        root.left.left.left = sol.new TreeNode(7);
        root.left.left.right = sol.new TreeNode(2);
        root.right.left = sol.new TreeNode(13);
        root.right.right = sol.new TreeNode(4);
        root.right.right.right = sol.new TreeNode(1);

        int targetSum1 = 22; // True (5 -> 4 -> 11 -> 2)
        int targetSum2 = 26; // True (5 -> 8 -> 13)
        int targetSum3 = 18; // False

        System.out.println("Has path sum " + targetSum1 + "? " + sol.hasPathSum(root, targetSum1));
        System.out.println("Has path sum " + targetSum2 + "? " + sol.hasPathSum(root, targetSum2));
        System.out.println("Has path sum " + targetSum3 + "? " + sol.hasPathSum(root, targetSum3));
    }
}

