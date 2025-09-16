package Trees;

import java.util.*;
//Leetcode : 230. Kth Smallest Element in a BST:
public class kthSmallest {

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

    // Fields to track state during inorder traversal
    private int count = 0;
    private int result = -1;

    // ✅ Main function to find kth smallest element
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    // ✅ Inorder traversal (L -> Node -> R)
    private void inorder(TreeNode root, int target) {
        if (root == null || result != -1) return; // stop if found already

        inorder(root.left, target);

        count++;
        if (count == target) {
            result = root.val;
            return;
        }

        inorder(root.right, target);
    }

    // ✅ Example usage
    public static void main(String[] args) {
        kthSmallest sol = new kthSmallest();

        // Build BST
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        int k = 1;
        System.out.println("Kth Smallest Element: " + sol.kthSmallest(root, k));
        // Expected output: 1
    }
}
