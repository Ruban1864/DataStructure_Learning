package Raandom;

public class avgValEvenNoDivisibleBy3 {
    public int averageValue(int[] nums) {
        int count = 0, sum = 0;
        for (int num : nums) {
            if (num % 6 == 0) { // divisible by both 2 and 3
                sum += num;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

    public static void main(String[] args) {
        avgValEvenNoDivisibleBy3 sol = new avgValEvenNoDivisibleBy3();

        int[] nums1 = {1, 3, 6, 10, 12, 15};
        System.out.println("Average Value (nums1): " + sol.averageValue(nums1));
        // (6+12)/2 = 9

        int[] nums2 = {2, 4, 5, 7, 11};
        System.out.println("Average Value (nums2): " + sol.averageValue(nums2));
        // no numbers divisible by 6 → 0

        int[] nums3 = {18, 24, 30};
        System.out.println("Average Value (nums3): " + sol.averageValue(nums3));
        // (18+24+30)/3 = 24

        int[] nums4 = {};
        System.out.println("Average Value (nums4): " + sol.averageValue(nums4));
        // empty → 0

        int[] nums5 = {6};
        System.out.println("Average Value (nums5): " + sol.averageValue(nums5));
        // single element divisible by 6 → 6
    }
}

