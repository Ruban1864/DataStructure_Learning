package Raandom;
//Leetcode : 3483. Unique 3-Digit Even Numbers
import java.util.*;

class findEvenNumber {
    public int findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();

        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // Ensure digits are not reused
                    if (i != j && j != k && i != k) {
                        int d1 = digits[i];
                        int d2 = digits[j];
                        int d3 = digits[k];

                        // First digit cannot be zero
                        if (d1 == 0) continue;

                        // Last digit must be even
                        if (d3 % 2 != 0) continue;

                        int num = d1 * 100 + d2 * 10 + d3;
                        set.add(num);
                    }
                }
            }
        }

        return set.size();
    }

    // For quick testing
    public static void main(String[] args) {
        findEvenNumber sol = new findEvenNumber();

        System.out.println(sol.findEvenNumbers(new int[]{1,2,3,4})); // 12
        System.out.println(sol.findEvenNumbers(new int[]{0,2,2}));   // 2
        System.out.println(sol.findEvenNumbers(new int[]{6,6,6}));   // 1
        System.out.println(sol.findEvenNumbers(new int[]{1,3,5}));   // 0
    }
}

