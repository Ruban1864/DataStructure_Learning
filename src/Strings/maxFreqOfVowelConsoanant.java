package Strings;

import java.util.*;

public class maxFreqOfVowelConsoanant {
    public int maxFreqSum(String s) {
        Map<Character,Integer> vowel = new HashMap<>();
        Map<Character,Integer> consonant = new HashMap<>();
        String vowels = "aeiou";

        // Count frequencies
        for(char ch : s.toCharArray()) {
            if(vowels.indexOf(ch) != -1) {
                vowel.put(ch, vowel.getOrDefault(ch, 0) + 1);
            } else {
                consonant.put(ch, consonant.getOrDefault(ch, 0) + 1);
            }
        }

        // Find maximum vowel frequency
        int maxVowel = 0;
        for(int freq : vowel.values()) {
            maxVowel = Math.max(maxVowel, freq);
        }

        // Find maximum consonant frequency
        int maxConsonant = 0;
        for(int freq : consonant.values()) {
            maxConsonant = Math.max(maxConsonant, freq);
        }

        return maxVowel + maxConsonant;
    }

    // Example usage
    public static void main(String[] args) {
        maxFreqOfVowelConsoanant sol = new maxFreqOfVowelConsoanant();

        String s1 = "abcdeee";
        System.out.println("Input: " + s1 + " → Output: " + sol.maxFreqSum(s1));
        // Vowels = e(3), Consonants = b(1), c(1), d(1) → Answer = 3 + 1 = 4

        String s2 = "aaabbcccc";
        System.out.println("Input: " + s2 + " → Output: " + sol.maxFreqSum(s2));
        // Vowels = a(3), Consonants = c(4) → Answer = 3 + 4 = 7
    }
}
