package Raandom;
//Leetcode : 1323. Maximum 69 Number
public class max69Number {
    public int maximum69Number(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '6') {
                ch[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(ch));
    }

    public static void main(String[] args) {
        max69Number sol = new max69Number();

        int num1 = 9669;
        System.out.println("Input: " + num1 + " → Output: " + sol.maximum69Number(num1));
        // 9969

        int num2 = 9996;
        System.out.println("Input: " + num2 + " → Output: " + sol.maximum69Number(num2));
        // 9999

        int num3 = 9999;
        System.out.println("Input: " + num3 + " → Output: " + sol.maximum69Number(num3));
        // 9999 (no change)

        int num4 = 6969;
        System.out.println("Input: " + num4 + " → Output: " + sol.maximum69Number(num4));
        // 9969
    }
}

