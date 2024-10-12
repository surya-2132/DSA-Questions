package BinarySearch.TwoDArray;

import java.util.Arrays;

public class PeakIn2DArray {
    public static void main(String[] args) {
        int[][] mat = {
                {4, 2, 5, 1, 4, 5},
                {2, 9, 3, 2, 3, 2},
                {1, 7, 6, 0, 1, 3},
                {3, 6, 2, 3, 7, 2}
        };

        System.out.println(Arrays.toString(findPeakIn2DArray(mat)));
    }

    public static int[] findPeakIn2DArray(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            int maxRowIndex = maxInGivenCol(mat, n, m, mid);
            int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1; // checking index on left side if its exist or not
            int right = mid + 1 < m ? mat[maxRowIndex][mid + 1] : -1; // checking index on right side if its exist or not

            if(mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right){
                return new int[]{maxRowIndex, mid}; //if elem greater than its left and right return as ans
            }
            else if(mat[maxRowIndex][mid] < left){  //if left elem is greater than curr remove right half
                high = mid - 1;
            }
            else{
                low = mid + 1;   //if right elem is greater than curr remove left half
            }
        }
        return new int[] {-1, -1};
    }

    private static int maxInGivenCol(int[][] mat, int n, int m, int col){
        int max = Integer.MIN_VALUE;
        int index = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(mat[i][col] > max){
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}
