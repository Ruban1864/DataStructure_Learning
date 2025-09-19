package Raandom;
//Leetcode 258 : Add the Digits
public class AddTheDigits {
    public int addDigits(int num) {
        if (num == 0) return 0;
        return 1 + (num - 1) % 9;  // digital root formula
    }

    public static void main(String[] args) {
        AddTheDigits solution = new AddTheDigits();

        int num1 = 38;
        int num2 = 0;
        int num3 = 99;

        System.out.println("Input: " + num1 + " → Output: " + solution.addDigits(num1)); // 2
        System.out.println("Input: " + num2 + " → Output: " + solution.addDigits(num2)); // 0
        System.out.println("Input: " + num3 + " → Output: " + solution.addDigits(num3)); // 9
    }
}

