package Arrays;

public class searchInsert {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert1(arr,2));
    }
    public static int searchInsert1(int[] nums, int target) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid; // found
                } else if (nums[mid] < target) {
                    left = mid + 1; // go right
                } else {
                    right = mid - 1; // go left
                }
            }

            // left is the insert position
            return left;
        }
    }


