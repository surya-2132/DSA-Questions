package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle_123 {
    public static void main(String[] args) {
        //each row will have row num of values, ex: 2nd row will have 2 elem, 5th row 5 elem, 9th row 9 elem ...
        System.out.println("pascalsTriangle1 : " + pascalsTriangle1(5, 3));
        System.out.println("pascalsTriangle2 : " + Arrays.toString(pascalTriangle2(5)));
        System.out.println("pascalsTriangle3 : " + (pascalTriangle3(5)));
    }


    public static int pascalsTriangle1(int row, int col){
        //// 1) calling a static method into static - true
        return nCr(row-1, col-1);
    }

    ////2) calling static method into a non-static method - true
    public void nonStaticMethod1(){
        System.out.println("calling static method " + nCr(1, 2));
    }

    //// 3) calling a non-static method into another non-static method
    public void nonStaticMethod2(){
        nonStaticMethod1();
    }

    //calculation with the formula of nCr = n! / (r! * (n-r)!)
    public static int nCr(int n, int r){
        ///nonStaticMethod1(); //// 4) calling a non-static method into static - False
        if(r > n-r){r = n-r;}

        if(r == 1){return n;}

        int result = 1;
        for(int i = 0; i < r; i++){ //nCr -> 9c3
            result = result * (n - i); // 9, 8, 7
            result = result / (i + 1); // 1, 2, 3
        }

        return result;
    }


    //Given an integer r, return all the values in the rth row (1-indexed) in Pascal's Triangle in correct order.
    public static int[] pascalTriangle2(int rowNum){
        int[] resultRow = new int[rowNum];
        int row = rowNum - 1; // Because row numbering is 1-indexed not 0 based

        for(int col = 0; col < rowNum; col++){
            resultRow[col] = nCr(row, col);
        }

        return resultRow;
    }


    public static List<List<Integer>> pascalTriangle3(int rowNum){
        List<List<Integer>> ansList = new ArrayList<>();

        for(int i = 0; i < rowNum; i++){
            List<Integer> currRow = new ArrayList<>();

            //i and j are same and j start at 0 and ends at same as i`th value
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){ //represents the first and last elem in curr row
                    currRow.add(1);
                }
                else{
                    //go to the previous row using i-1(since i and j are same)
                    List<Integer> prevRow = ansList.get(i-1);
                    //add two numbers just above to that element and -1'th
                    currRow.add(prevRow.get(j) + prevRow.get(j-1));
                }
            }

            ansList.add(currRow);
        }
        return ansList;
    }




}
