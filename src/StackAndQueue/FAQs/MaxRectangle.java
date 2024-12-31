package StackAndQueue.FAQs;

public class MaxRectangle {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        System.out.println(maxRectangle(mat));
    }

    public static int maxRectangle(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefixSumMat = new int[n][m];
        //traverse all cols first col0-> row 0 to n, col1 -> row 0 to n, col2-> row 0 to n etc...
        for(int j = 0; j < m; j++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += mat[i][j];

                //if we see 0, make that cell as 0 in prefixSum,
                //because it can't create histogram bar.
                if(mat[i][j] == 0){
                    prefixSumMat[i][j] = 0;
                }
                //else assign the sum to the respective 2D cell in prefixSumMat
                prefixSumMat[i][j] = sum;
            }
        }

        //find max on each prefixSum row
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            maxArea = Math.max(maxArea,
                    LargestAreaOfHistogram.largestRectangleAreaOptimal(prefixSumMat[i]));
        }
        return maxArea;
    }
}
