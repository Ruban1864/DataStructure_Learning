package Dynamic_Programming;

public class regexExp {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // empty string matches empty pattern

        // Initialize for patterns like a*, a*b*, etc.
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Case 1: '*' counts as zero occurrence
                    dp[i][j] = dp[i][j - 2];

                    // Case 2: '*' counts as one or more occurrence
                    char prev = p.charAt(j - 2);
                    if (prev == '.' || prev == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        regexExp sol = new regexExp();

        System.out.println(sol.isMatch("aa", "a"));       // false
        System.out.println(sol.isMatch("aa", "a*"));      // true
        System.out.println(sol.isMatch("ab", ".*"));      // true
        System.out.println(sol.isMatch("aab", "c*a*b"));  // true
        System.out.println(sol.isMatch("mississippi", "mis*is*p*.")); // false
    }
}
