package Raandom;

// LeetCode 1688: Count of Matches in Tournament
// Full working Java program

class Solution {
    public int numberOfMatches(int n) {
        int match = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                match += n / 2;
                n = n / 2;
            } else {
                match += (n - 1) / 2;
                n = ((n - 1) / 2) + 1;
            }
        }
        return match;
    }
}

public class countMatches {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test cases
        int n1 = 7;
        int n2 = 14;

        System.out.println("Number of matches for " + n1 + " teams = " + sol.numberOfMatches(n1)); // Expected 6
        System.out.println("Number of matches for " + n2 + " teams = " + sol.numberOfMatches(n2)); // Expected 13
    }
}

