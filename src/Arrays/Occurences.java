package Arrays;

public class Occurences {
    public static void main(String[] args) {
        int n = 9;
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int x = 5;

        int first = -1, last = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                if (first == -1) {
                    first = i;   // first time we see x
                }
                last = i;        // keep updating until last
            }
        }

        System.out.println("First Occurrence = " + first);
        System.out.println("Last Occurrence = " + last);
    }
}
