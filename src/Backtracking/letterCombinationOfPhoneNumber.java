package Backtracking;

import java.util.*;

class letterCombinationOfPhoneNumber {
    private static final Map<Character, String> map = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, String digits, int index, StringBuilder path) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = map.get(digits.charAt(index));
        for (char ch : letters.toCharArray()) {
            path.append(ch);
            backtrack(result, digits, index + 1, path);
            path.deleteCharAt(path.length() - 1); // backtrack step
        }
    }

    // For testing
    public static void main(String[] args) {
        letterCombinationOfPhoneNumber sol = new letterCombinationOfPhoneNumber();
        System.out.println(sol.letterCombinations("35"));
    }
}
