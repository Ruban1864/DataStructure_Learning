package Strings;

import java.util.*;

class Vowel_spellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // 1. Exact match set
        Set<String> exactWords = new HashSet<>();
        // 2. Case-insensitive map
        Map<String, String> caseInsensitive = new HashMap<>();
        // 3. Vowel-error map
        Map<String, String> devowelMap = new HashMap<>();

        // Preprocess wordlist
        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);

            String devowel = devowel(lower);
            devowelMap.putIfAbsent(devowel, word);
        }

        String[] result = new String[queries.length];

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            // Rule 1: Exact match
            if (exactWords.contains(query)) {
                result[i] = query;
                continue;
            }

            // Rule 2: Case-insensitive match
            String lower = query.toLowerCase();
            if (caseInsensitive.containsKey(lower)) {
                result[i] = caseInsensitive.get(lower);
                continue;
            }

            // Rule 3: Vowel-error match
            String devowel = devowel(lower);
            if (devowelMap.containsKey(devowel)) {
                result[i] = devowelMap.get(devowel);
                continue;
            }

            // Rule 4: No match
            result[i] = "";
        }

        return result;
    }

    // Helper function to replace vowels with '*'
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Example test
    public static void main(String[] args) {
        Vowel_spellchecker sol = new Vowel_spellchecker();
        String[] wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        System.out.println(Arrays.toString(sol.spellchecker(wordlist, queries)));
        // Expected: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
    }
}
