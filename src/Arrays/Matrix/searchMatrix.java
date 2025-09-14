package Arrays.Matrix;
//Leetcode : 74. Search a 2D Matrix
class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // Go row by row
        for (int[] ints : matrix) {
            if (findTarget(ints, n, target)) {
                return true;
            }
        }
        return false;
    }
    // Binary search in a row
    private boolean findTarget(int[] row, int n, int target) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] == target) return true;
            else if (row[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
    // Testing
    public static void main(String[] args) {
        searchMatrix sol = new searchMatrix();
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(sol.searchMatrix(matrix, 11));   // true
        System.out.println(sol.searchMatrix(matrix, 13));  // false
    }
}

