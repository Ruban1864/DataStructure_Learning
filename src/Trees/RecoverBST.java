package Trees;
//Leetcode 99. Recover Binary Search Tree
public class RecoverBST {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);

        // Detect swapped nodes
        if (first == null && prev.val > node.val) {
            first = prev;
        }
        if (first != null && prev.val > node.val) {
            second = node;
        }

        prev = node;

        inorder(node.right);
    }

    // Quick test
    public static void main(String[] args) {
        RecoverBST sol = new RecoverBST();

        /*
             3
            / \
           1   4
              /
             2

           Here, nodes 2 and 3 are swapped.
        */
        TreeNode root = new TreeNode(3,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(2), null)
        );

        sol.recoverTree(root);

        // Inorder after fix should be sorted: 1 2 3 4
        printInorder(root);
    }

    private static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
