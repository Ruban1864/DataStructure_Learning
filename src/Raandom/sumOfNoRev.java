package Raandom;
//Leetcode : 2443. Sum of Number and Its Reverse
public class sumOfNoRev {

    // Main function: check if num can be written as x + reverse(x)
    public boolean sumOfNumberAndReverse(int num) {
        for (int x = 0; x <= num; x++) {
            int rev = 0, temp = x;
            while (temp > 0) {
                rev = rev * 10 + temp % 10;
                temp /= 10;
            }
            if (x + rev == num) {
                return true;
            }
        }
        return false;
    }

    // Testing
    public static void main(String[] args) {
        sumOfNoRev sol = new sumOfNoRev();

        int num1 = 443;
        System.out.println(num1 + " → " + sol.sumOfNumberAndReverse(num1));
        // true, because 172 + 271 = 443

        int num2 = 63;
        System.out.println(num2 + " → " + sol.sumOfNumberAndReverse(num2));
        // false

        int num3 = 0;
        System.out.println(num3 + " → " + sol.sumOfNumberAndReverse(num3));
        // true, because 0 + 0 = 0
    }
}
