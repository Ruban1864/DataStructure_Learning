package Strings;


import java.util.HashSet;

public class LongestSubStringWithoutDuplicates {
    public static void main(String[] args) {
        String str = "character";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If duplicate found, move left pointer
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
