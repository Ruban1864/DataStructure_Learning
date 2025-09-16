package Raandom;
//Leetcode : Power of Two → 231. Power of Two
//Leetcode : Power of Three → 326. Power of Three
//Leetcode : Power of Four → 342. Power of Four
public class PowerOf234 {

    // ✅ Check if n is a power of two
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    // ✅ Check if n is a power of three
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    // ✅ Check if n is a power of four
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    // ✅ Example usage
    public static void main(String[] args) {
        PowerOf234 sol = new PowerOf234();

        System.out.println("Power of 2:");
        System.out.println("16 -> " + sol.isPowerOfTwo(16)); // true
        System.out.println("18 -> " + sol.isPowerOfTwo(18)); // false

        System.out.println("\nPower of 3:");
        System.out.println("27 -> " + sol.isPowerOfThree(27)); // true
        System.out.println("28 -> " + sol.isPowerOfThree(28)); // false

        System.out.println("\nPower of 4:");
        System.out.println("64 -> " + sol.isPowerOfFour(64)); // true
        System.out.println("72 -> " + sol.isPowerOfFour(72)); // false
    }
}
