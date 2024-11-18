package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(140));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ansList = new ArrayList<>();
        List<String> board = new ArrayList<>();

        String str = ".".repeat(n);
        for(int i = 0; i < n; i++){
            board.add(str);
        }

        recSolve(0, n, board, ansList);
        return ansList;
    }

    public static void recSolve(int row, int n, List<String> board, List<List<String>> ansList){

        // If all queens are placed in every row, add the board to the result
        if(row == n){
            ansList.add(new ArrayList<>(board));
            return;
        }

        // Try placing a queen if possible on each column of the current row - but only one Q will be placed at last.
        for(int col = 0; col < n; col++){
            if(isPlacingPossible(row, col, board)){

                char[] currRow = board.get(row).toCharArray(); // [. . . .]
                currRow[col] = 'Q'; // [. . Q .] -> Placing queen at correct possible pos on this iteration
                board.set(row, new String(currRow)); // Set/Save that into board list

                recSolve(row + 1, n, board, ansList); //do the same thing on next row

                currRow[col] = '.'; //for backtracking reset the prev col to '.' to explore other paths
                board.set(row, new String(currRow)); // Set/Save that into board list

            }
        }
    }

    // Check if it's possible to place a queen at (row, col)
    public static boolean isPlacingPossible(int row, int col, List<String> board) {

        //Check direct upwards on above rows same col
        int r = row;
        int c = col;
        while(r >= 0){
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
        }

        // Check the left upper diagonal
        r = row;
        c = col;
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        // Check the right upper diagonal
        r = row;
        c = col;
        while (r >= 0 && c <= board.size()-1) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
            c++;
        }

        // If no conflicts, it's safe to place the queen
        return true;
    }
}
