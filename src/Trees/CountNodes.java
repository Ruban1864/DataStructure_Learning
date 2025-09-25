package Trees;
//Leetcode 222. Count Complete Tree Nodes
public class CountNodes {
    // Inner TreeNode class
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

    // Count nodes function
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Quick test
    public static void main(String[] args) {
        CountNodes sol = new CountNodes();

        // Build sample tree: [1,2,3,4,5,6]
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null)
        );

        System.out.println("The Total Number of Nodes in the tree is "+sol.countNodes(root)); // Output: 6
    }
}

