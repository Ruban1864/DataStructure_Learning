package Trees;
//Leetcode : 101.Symmetric Tree
class SymmetricTree {
    // Definition for a binary tree node
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // empty tree is symmetric
        return isHelper(root.left, root.right);
    }

    private boolean isHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isHelper(left.left, right.right) && isHelper(left.right, right.left);
    }

    // Testing
    public static void main(String[] args) {
        SymmetricTree st = new SymmetricTree();

        // Example tree: symmetric
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );

        System.out.println(st.isSymmetric(root)); // true

        // Example tree: not symmetric
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))
        );

        System.out.println(st.isSymmetric(root2)); // false
    }
}
