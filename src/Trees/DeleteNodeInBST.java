package Trees;
//Leetcode : 450. Delete Node in a BST
public class DeleteNodeInBST {

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

    // ✅ Function to delete a node
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {  // go left
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {  // go right
            root.right = deleteNode(root.right, key);
        } else { // Found the node
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                // Find minimum in right subtree
                int min = minimum(root.right);
                root.val = min; // replace value
                root.right = deleteNode(root.right, min); // delete successor
            }
        }
        return root;
    }

    // ✅ Find the minimum value in a subtree
    private int minimum(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    // ✅ Example usage
    public static void main(String[] args) {
        DeleteNodeInBST sol = new DeleteNodeInBST();

        // Build BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        root.right = new TreeNode(6, null, new TreeNode(7));

        // Delete node with value 3
        root = sol.deleteNode(root, 3);

        // Print inorder traversal after deletion
        inorder(root);  // Expected: 2 4 5 6 7
    }

    // ✅ Inorder traversal (for testing)
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

