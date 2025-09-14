package Strings;
//Leetcode : 541.Reverse String II.
public class reverseString {

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        // For every block of size 2k, reverse the first k characters
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1); // ensure we don't go out of bounds
            reverse(arr, left, right);
        }

        return new String(arr);
    }

    // Helper method to reverse characters in arr[l..r]
    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    // Testing
    public static void main(String[] args) {
        reverseString sol = new reverseString();

        String s1 = "abcdefg";
        int k1 = 2;
        System.out.println("Input: " + s1 + ", k=" + k1);
        System.out.println("Output: " + sol.reverseStr(s1, k1));
        // Expected: "bacdfeg"

        String s2 = "abcd";
        int k2 = 2;
        System.out.println("\nInput: " + s2 + ", k=" + k2);
        System.out.println("Output: " + sol.reverseStr(s2, k2));
        // Expected: "bacd"
    }
}
