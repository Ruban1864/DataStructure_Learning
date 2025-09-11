package Trees;
//LeetCode : 111. Minimum Depth of Binary Tree
class minDepthOfTree {

    // Inner TreeNode class
    class TreeNode {
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

    // Recursive solution for minimum depth
    public int minDepth(TreeNode root) {
        if (root == null) return 0; // Empty tree

        // If one child is null, take the depth of the other
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        // Otherwise, take the minimum of both sides
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    // Example test run
    public static void main(String[] args) {
        minDepthOfTree sol = new minDepthOfTree();

        // Build tree:
        //      3
        //     / \
        //    9  20
        //       / \
        //      15  7
        TreeNode root = sol.new TreeNode(3);
        root.left = sol.new TreeNode(9);
        root.right = sol.new TreeNode(20, sol.new TreeNode(15), sol.new TreeNode(7));

        System.out.println("Minimum Depth = " + sol.minDepth(root));
        // Expected output: 2 (path 3 -> 9)
    }
}
