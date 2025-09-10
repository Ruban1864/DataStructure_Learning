package Raandom;

import java.util.*;

// LeetCode 728: Self Dividing Numbers
class Solution1 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (ishelper(i))
                res.add(i);
        }
        return res;
    }

    private boolean ishelper(int n) {
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || n % digit != 0)
                return false;
            temp /= 10;
        }
        return true;
    }
}

public class selfDividingNumber {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        int left = 1, right = 22;
        List<Integer> result = sol.selfDividingNumbers(left, right);

        System.out.println("Self-dividing numbers between " + left + " and " + right + ": " + result);
    }
}

