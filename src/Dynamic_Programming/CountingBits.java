package Dynamic_Programming;
//Leetcode : 338. Counting Bits
import java.util.Arrays;

public class CountingBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];

        // dp[0] = 0 by default
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;
    }

    // Test the solution
    public static void main(String[] args) {
        CountingBits solution = new CountingBits();

        System.out.println(Arrays.toString(solution.countBits(2))); // [0,1,1]
        System.out.println(Arrays.toString(solution.countBits(5))); // [0,1,1,2,1,2]
        System.out.println(Arrays.toString(solution.countBits(10))); // [0,1,1,2,1,2,2,3,1,2,2]
    }
}
