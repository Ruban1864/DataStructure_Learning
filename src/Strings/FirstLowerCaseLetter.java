package Strings;

import java.util.HashMap;
import java.util.Map;

public class FirstLowerCaseLetter {
    public static void main(String[] args) {
        String str = "aabbccc";
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch , 0)+1 );
        }

        for(int i = 0 ; i < map.size() ; i++){
            char ch = str.charAt(i);
            if(map.get(ch) == 1){
                System.out.println(ch);
                return;
            }
        }
        System.out.println("$");
    }
}

//
//public class FirstLowerCaseLetter {
//    public static void main(String[] args) {
//        String str = "geeksforgeeks";
//
//        // Step 1: Count frequencies using array
//        int[] freq = new int[26]; // for a-z
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            freq[ch - 'a']++;
//        }
//
//        // Step 2: Traverse string again to maintain order
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            if (freq[ch - 'a'] == 1) {
//                System.out.println(ch); // first non-repeating character
//                return;
//            }
//        }
//
//        // If none found
//        System.out.println("$");
//    }
//}
//';
