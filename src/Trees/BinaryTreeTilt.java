package Trees;

//Leetcode : 563. Binary Tree Tilt

public class BinaryTreeTilt {

    // Definition for a binary tree node.
    static class TreeNode {
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

    private int totalTilt = 0;  // holds the accumulated tilt

    public int findTilt(TreeNode root) {
        dfs(root);
        return totalTilt;
    }

    // DFS helper: returns sum of subtree rooted at "node"
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        totalTilt += Math.abs(leftSum - rightSum);

        return leftSum + rightSum + node.val;
    }

    // Example usage
    public static void main(String[] args) {
        // Build tree: [1,2,3]
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));

        BinaryTreeTilt tree = new BinaryTreeTilt();
        System.out.println("Tilt of [1,2,3] = " + tree.findTilt(root)); // Expected: 1

        // Another test: [4,2,9,3,5,null,7]
        TreeNode root2 = new TreeNode(4,
                new TreeNode(2, new TreeNode(3), new TreeNode(5)),
                new TreeNode(9, null, new TreeNode(7))
        );

        BinaryTreeTilt tree2 = new BinaryTreeTilt();
        System.out.println("Tilt of [4,2,9,3,5,null,7] = " + tree2.findTilt(root2)); // Expected: 15
    }
}
