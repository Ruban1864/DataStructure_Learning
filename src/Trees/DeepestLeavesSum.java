package Trees;

// LeetCode 1302: Deepest Leaves Sum
// Full working Java program from tree creation to execution

class TreeNode {
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

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int height = maxHeight(root);
        return depthSum(root, 1, height);
    }

    private int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }

    private int depthSum(TreeNode root, int depth, int maxDepth) {
        if (root == null) return 0;
        if (depth == maxDepth) return root.val;
        return depthSum(root.left, depth + 1, maxDepth) +
                depthSum(root.right, depth + 1, maxDepth);
    }
}

public class DeepestLeavesSum {
    public static void main(String[] args) {
        /*
              Example tree:
                    1
                   / \
                  2   3
                 / \   \
                4   5   6
               /         \
              7           8

              Deepest leaves are: 7 and 8 → sum = 15
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        Solution sol = new Solution();
        int result = sol.deepestLeavesSum(root);
        System.out.println("Deepest leaves sum = " + result);
    }
}

