package Trees;

// 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree

public class  clonedTree{

    // Inner TreeNode class
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Function to find the target node in the cloned tree
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) return left;

        return getTargetCopy(original.right, cloned.right, target);
    }

    // Helper function to clone a binary tree
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = cloneTree(root.left);
        newNode.right = cloneTree(root.right);
        return newNode;
    }

    // Helper function to print inorder traversal
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Main method for local testing
    public static void main(String[] args) {
        clonedTree sol = new clonedTree();

        // Build original tree
        TreeNode root = sol.new TreeNode(7);
        root.left = sol.new TreeNode(4);
        root.right = sol.new TreeNode(3);
        root.right.left = sol.new TreeNode(6);
        root.right.right = sol.new TreeNode(19);

        // Clone the tree
        TreeNode clonedRoot = sol.cloneTree(root);

        // Target node
        TreeNode target = root.right; // node with value 3

        // Find corresponding node in cloned tree
        TreeNode result = sol.getTargetCopy(root, clonedRoot, target);

        System.out.println("Original Target Node Value: " + target.val);
        System.out.println("Cloned Corresponding Node Value: " + (result != null ? result.val : "null"));

        // Print inorder traversal of original and cloned
        System.out.print("Original Tree (Inorder): ");
        sol.inorder(root);
        System.out.println();

        System.out.print("Cloned Tree (Inorder): ");
        sol.inorder(clonedRoot);
        System.out.println();
    }
}

