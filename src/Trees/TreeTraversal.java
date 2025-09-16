package Trees;
//Leetcode : 144.Preorder Traversal
//Leetcode : 145.Postorder Traversal
//Leetcode : 94 .Inorder Traversal


import java.util.*;

public class TreeTraversal {

    // ✅ Inner TreeNode class
    public static class TreeNode {
        int val;
        TreeNode left, right;

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

    // ✅ Inorder Traversal (Left -> Root -> Right)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }

    // ✅ Preorder Traversal (Root -> Left -> Right)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }
    }

    // ✅ Postorder Traversal (Left -> Right -> Root)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root != null) {
            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
    }

    // ✅ Example usage
    public static void main(String[] args) {
        TreeTraversal sol = new TreeTraversal();

        // Build test tree:
        //       1
        //        \
        //         2
        //        /
        //       3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Traversals
        System.out.println("Inorder Traversal: " + sol.inorderTraversal(root));   // [1, 3, 2]
        System.out.println("Preorder Traversal: " + sol.preorderTraversal(root)); // [1, 2, 3]
        System.out.println("Postorder Traversal: " + sol.postorderTraversal(root)); // [3, 2, 1]
    }
}
