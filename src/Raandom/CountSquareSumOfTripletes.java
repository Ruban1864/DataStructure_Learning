package Raandom;

// 1925. Count Square Sum Triples

public class CountSquareSumOfTripletes {

    public int countTriples(int n) {
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = a + 1; b <= n; b++) {  // ensure unique pairs
                int s = (a * a) + (b * b);
                int sq = (int) Math.sqrt(s);
                if (sq <= n && s == sq * sq) {
                    count += 2; // (a, b, c) and (b, a, c)
                }
            }
        }
        return count;
    }

    // Main method for local testing
    public static void main(String[] args) {
        CountSquareSumOfTripletes sol = new CountSquareSumOfTripletes();

        int n1 = 5;
        int n2 = 10;
        int n3 = 20;

        System.out.println("Count of triples for n = " + n1 + " → " + sol.countTriples(n1)); // Expected 2
        System.out.println("Count of triples for n = " + n2 + " → " + sol.countTriples(n2)); // Expected 4
        System.out.println("Count of triples for n = " + n3 + " → " + sol.countTriples(n3)); // Expected 10
    }
}
