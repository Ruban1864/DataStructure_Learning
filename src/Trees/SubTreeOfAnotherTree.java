package Trees;
//Leetcode 572. Subtree of Another Treef
public class SubTreeOfAnotherTree {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        // Either trees are the same, or subtree exists in left or right
        if (isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;

        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }

    // Quick test
    public static void main(String[] args) {
        SubTreeOfAnotherTree sol = new SubTreeOfAnotherTree();

        // Root tree: [3,4,5,1,2]
        TreeNode root = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2)
                ),
                new TreeNode(5)
        );

        // Subtree: [4,1,2]
        TreeNode subRoot = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2)
        );

        System.out.println(sol.isSubtree(root, subRoot)); // true
    }
}

