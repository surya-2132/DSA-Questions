package BinarySearch.TwoDArray;

public class MedianMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {8, 9, 11, 12, 13},
                {21, 23, 25, 27, 29}
        };
        System.out.println(findMedian(matrix));

    }

    // Helper function to count the number of elements <= mid
    public static int findMedian(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find the smallest and largest elements in the matrix
        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]); // First element of each row
            high = Math.max(high, matrix[i][m - 1]); // Last element of each row
        }

        int req = (m * n) / 2; // Half the total number of elements
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int smallEqual = countSmallerEquals(matrix, mid);
            if (smallEqual <= req) {
                low = mid + 1; // Search the right half
            } else {
                high = mid - 1; // Search the left half
            }
        }
        return low; // When low > high, low is the median
    }


    public static int countSmallerEquals(int[][] matrix, int midX) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += upperBound(matrix[i], midX);
        }
        return count;
    }


    // Helper function to find the upper bound (first element greater than target)
    public static int upperBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid-element is a potential answer
            if (target < nums[mid]) { // Strictly less than
                ans = mid;
                high = mid - 1; // Search left half
            } else {
                low = mid + 1; // Search right half
            }
        }
        return ans;

    }
}
