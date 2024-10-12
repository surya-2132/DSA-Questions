package BinarySearch.TwoDArray;

import BinarySearch.Easy.LowerBound;

public class FindMaxOnesRow {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1}, {0, 1, 1}, {0, 1, 1}};
        System.out.println(maxOnesRowOptimal(matrix));
    }

    public static int maxOnesRowBrute(int[][] mat){
        int max = 0;
        int maxOnesRow = -1; //if set to 0 it will return first row, so to avoid we used -1
        for(int i = 0; i < mat.length; i++){

            int count = -1; //since max is zero if count more than max(0) then only we have to set count = max
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }

            if(count > max){
                max = count;
                maxOnesRow = i; //when we get more count set current row ans max one occurred row;
            }
        }
        return maxOnesRow;
    }

    public static int maxOnesRowOptimal(int[][] mat){
        int max = 0;
        int maxOnesRow = -1; //if set to 0 it will return first row, so to avoid we used -1
        for(int i = 0; i < mat.length; i++){

            int count = mat[0].length - lowerBound(mat[i], 1);  //last index - first occurred one's index
            if(count > max){
                max = count;
                maxOnesRow = i; //when we get more count set current row ans max one occurred row;
            }
        }
        return maxOnesRow;
    }

    public static int lowerBound(int[] nums, int target){
        return LowerBound.lowerBound(nums, target);
    }
}
