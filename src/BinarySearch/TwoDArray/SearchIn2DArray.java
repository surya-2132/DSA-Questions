package BinarySearch.TwoDArray;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] mat = {
                            {1, 2,  3,  4},
                            {5, 6,  7,  8},
                            {9, 10, 11, 12}
                        };

        System.out.println(isElementPresentOptimal(mat, 8));
    }

    //TC -> O(N x M)
    public static boolean isElementPresentBrute(int[][] mat, int target){
        int n = mat.length; //total rows
        int m = mat[0].length;  //total nums in each row or can be col (every col's first ele) length

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    //TC -> O(n + Log2m)
    public static boolean isElementPresentBetter(int[][] mat, int target){
        //can check if target is present in between first and last element
        //if is present do BS on that particular row

        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0; i < n; i++){

            //greater than first element and lesser than last element
            if(mat[i][0] <= target && target <= mat[i][m-1]){
                return binarySearch(mat[i], target);//do bs on this current (i'th) row
            }
        }
        return false;
    }
    //helper binary search for better
    private static boolean binarySearch(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return true;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }

    //O(log(m * n))
    public static boolean isElementPresentOptimal(int[][] mat, int target){

        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = n * m -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            //converting imaginary index and 2d coordinate using below formula
            int row = mid / m;
            int col = mid % m;

            if(mat[row][col] == target){
                return true;
            }
            else if(mat[row][col] < target){
                low = mid + 1;
            }
            else{
                high = mid + 1;
            }
        }
        return false;
    }


}
