package Trees;

// LeetCode 96: Unique Binary Search Trees
class uBST{
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty tree
        dp[1] = 1; // single node tree

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}

public class uniqueBST {
    public static void main(String[] args) {
        uBST sol = new uBST();

        int n1 = 3;
        int n2 = 5;

        System.out.println("Number of unique BSTs with " + n1 + " nodes = " + sol.numTrees(n1)); // Expected 5
        System.out.println("Number of unique BSTs with " + n2 + " nodes = " + sol.numTrees(n2)); // Expected 42
    }
}
