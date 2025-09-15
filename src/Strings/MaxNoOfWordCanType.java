package Strings;

import java.util.*;
//Leetcode : 1935. Maximum Number of Words You Can Type
public class MaxNoOfWordCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Put broken letters into a set for O(1) lookup
        Set<Character> brokenSet = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            brokenSet.add(c);
        }

        // Split text into words
        String[] words = text.split(" ");
        int result = 0;

        // Check each word
        for (String word : words) {
            boolean canType = true;
            for (char c : word.toCharArray()) {
                if (brokenSet.contains(c)) {
                    canType = false;
                    break;
                }
            }
            if (canType) result++;
        }
        return result;
    }

    // Example usage
    public static void main(String[] args) {
        MaxNoOfWordCanType sol = new MaxNoOfWordCanType();

        String text1 = "hello world";
        String broken1 = "ad";
        System.out.println("Input: \"" + text1 + "\", broken = \"" + broken1 + "\" → Output: "
                + sol.canBeTypedWords(text1, broken1));
        // "hello" (no 'a' or 'd'), "world" (no 'a' or 'd') → Answer = 2

        String text2 = "leet code";
        String broken2 = "lt";
        System.out.println("Input: \"" + text2 + "\", broken = \"" + broken2 + "\" → Output: "
                + sol.canBeTypedWords(text2, broken2));
        // "leet" (has 'l' and 't'), "code" (ok) → Answer = 1

        String text3 = "leet code";
        String broken3 = "e";
        System.out.println("In~~put: \"" + text3 + "\", broken = \"" + broken3 + "\" → Output: "
                + sol.canBeTypedWords(text3, broken3));
        // Both "leet" and "code" contain 'e' → Answer = 0
    }
}
