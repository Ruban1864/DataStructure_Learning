package Dynamic_Programming;
//Leetcode 746. Min Cost Climbing Stairs
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        // Base cases
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Fill dp array
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // The top can be reached from last or second-last step
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // Quick test
    public static void main(String[] args) {
        MinCostClimbingStairs solution = new MinCostClimbingStairs();

        System.out.println("The min climbing stairs is "+ solution.minCostClimbingStairs(new int[]{10, 15, 20})); // 15
        System.out.println("The min climbing stairs is "+solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6
    }
}
