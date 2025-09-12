package Strings;
//Leetcode : 3227. Vowels Game in a String
class VowelsGameInAString {
    public boolean doesAliceWin(String s) {
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                return true; // Alice wins as soon as a vowel is found
            }
        }
        return false; // no vowels found → Alice loses
    }

    // Testing
    public static void main(String[] args) {
        VowelsGameInAString sol = new VowelsGameInAString();

        System.out.println(sol.doesAliceWin("hello"));   // true (contains 'e', 'o')
        System.out.println(sol.doesAliceWin("sky"));     // false (no vowels)
        System.out.println(sol.doesAliceWin("AEIOU"));   // true (all vowels)
        System.out.println(sol.doesAliceWin("bcdfg"));   // false (no vowels)
    }
}
