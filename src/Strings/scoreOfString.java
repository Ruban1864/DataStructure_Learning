package Strings;

// LeetCode Problem: Score of a String
// Full working Java program

class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }
}

public class scoreOfString   {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test cases
        String s1 = "hello";
        String s2 = "abc";
        String s3 = "zaz";

        System.out.println("Score of \"" + s1 + "\" = " + sol.scoreOfString(s1)); // Expected 13
        System.out.println("Score of \"" + s2 + "\" = " + sol.scoreOfString(s2)); // Expected 2
        System.out.println("Score of \"" + s3 + "\" = " + sol.scoreOfString(s3)); // Expected 50
    }
}
