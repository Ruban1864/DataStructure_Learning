package Strings;
//Leetcode : 2785 Sort Vowels in a String
import java.util.Arrays;
public class sortVowelsInAString {
    public String sortVowels(String s) {
        String vowels = "AEIOUaeiou";
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                sb.append(ch);
            }
        }

        char[] vowelArray = sb.toString().toCharArray();
        Arrays.sort(vowelArray);

        char[] result = s.toCharArray();
        int pos = 0;
        for (int i = 0; i < result.length; i++) {
            if (vowels.indexOf(result[i]) != -1) {
                result[i] = vowelArray[pos++];
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        sortVowelsInAString sol = new sortVowelsInAString();

        String s1 = "lEetcOde";
        System.out.println("Input: " + s1 + " → Output: " + sol.sortVowels(s1));
        // Expected: "lEOtcede"

        String s2 = "hello";
        System.out.println("Input: " + s2 + " → Output: " + sol.sortVowels(s2));
        // Expected: "holle"

        String s3 = "leetcode";
        System.out.println("Input: " + s3 + " → Output: " + sol.sortVowels(s3));
        // Expected: "leetcede"

        String s4 = "AEIOUaeiou";
        System.out.println("Input: " + s4 + " → Output: " + sol.sortVowels(s4));
        // Expected: "AEIOUaeiou" (already sorted)
    }
}
