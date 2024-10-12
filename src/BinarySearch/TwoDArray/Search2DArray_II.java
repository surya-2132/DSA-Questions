package BinarySearch.TwoDArray;

import java.util.Arrays;

public class Search2DArray_II {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(Arrays.toString(searchIn2DArrayOptimal(matrix, 8)));
    }


    //TC -> O(n x m)
    public static int[] searchIn2DArrayBrute(int[][] mat, int target){
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    //TC -> O(n x log2m) -> x not + we are doing bs on each row
    public static int[] searchIn2DArrayBetter(int[][] mat, int target){
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0; i < n; i++){

            int isElementFoundInBS = binarySearch(mat[i], target); //mat[i] is current row

            //doing binary search on each row which is i here
            if(isElementFoundInBS != -1){   //if we found the target in bs
                return new int[] {i, isElementFoundInBS};
            }
        }
        return new int[] {-1, -1};
    }
    //helper function for better approach -> Binary search
    private static int binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    //TC -> O(n + m)
    public static int[] searchIn2DArrayOptimal(int[][] mat, int target){

        int n = mat.length;
        int m = mat[0].length;

        int row = 0;
        int col = m - 1;

        while(row < n && col >= 0){
            if(mat[row][col] == target){
                return new int[]{row, col};
            }
            //if target is greater than current ele, its entire row will be smaller than target
            //so we won't find target in that row so move row;
            else if (mat[row][col] < target){
                row++;
            }
            //same for col, if target is smaller than curr ele, we won't find target in that col
            //bcoz every element in that col is greater than target so move/reduce col
            else{
                col--;
            }
        }
        return new int[] {-1, -1};
    }

}
