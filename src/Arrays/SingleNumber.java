package Arrays;
//Leetcode : 136. Single Number
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;

        // XOR all numbers
        for (int num : nums) {
            result ^= num;  // cancel out duplicates
        }

        return result;
    }

    // Quick test
    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();

        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        int[] nums3 = {1};

        System.out.println("Input: [2,2,1] → Output: " + solution.singleNumber(nums1)); // 1
        System.out.println("Input: [4,1,2,1,2] → Output: " + solution.singleNumber(nums2)); // 4
        System.out.println("Input: [1] → Output: " + solution.singleNumber(nums3)); // 1
    }
}

