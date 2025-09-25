package Trees;

//Leetcode : 501. Find Mode in Binary Search Tree
import java.util.*;

public class ModesOfBST {

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

    private Integer prev = null;
    private int count = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        inorder(root);

        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            res[i] = modes.get(i);
        }
        return res;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // process node
        if (prev == null || node.val != prev) {
            count = 1;
        } else {
            count++;
        }

        if (count > maxCount) {
            maxCount = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == maxCount) {
            modes.add(node.val);
        }

        prev = node.val;

        inorder(node.right);
    }

    // Main method for quick testing
    public static void main(String[] args) {
        ModesOfBST sol = new ModesOfBST();

        // Example BST: [1,null,2,2]
        TreeNode root = new TreeNode(1, null,
                new TreeNode(2, new TreeNode(2), null)
        );

        int[] result = sol.findMode(root);
        System.out.println(Arrays.toString(result)); // [2]

        // Another test: [1,1,2,2]
        TreeNode root2 = new TreeNode(1,
                new TreeNode(1),
                new TreeNode(2, new TreeNode(2), null)
        );
        int[] result2 = sol.findMode(root2);
        System.out.println(Arrays.toString(result2)); // [1, 2]
    }
}
