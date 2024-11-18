package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        System.out.println("\nPaths that rat can take to go out of maze: \n"+findPath(grid));
    }


    public static List<String> findPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        List<String> list = new ArrayList<>();

        //If 0,0 and n,m end is 0 rat can't go out
        if(grid[0][0] == 0 || grid[n-1][m-1] == 0){
            return list;
        }

        recFindPath(0, 0, "", grid, list);

        return list;

    }

    private static void recFindPath(int i, int j, String path, int[][] grid, List<String> list){
        int n = grid.length;
        int m = grid[0].length;

        //If we reached the end add that path to list
        if(i == n-1 && j == m-1){
            list.add(path);
            return;
        }

        //All boundary checks at once
        if(i < 0 || j < 0 || i >= n || j >= m ||
                grid[i][j] == 0){
            return;
        }


        grid[i][j] = 0; // mark as visited

        // Try all four possible directions
        recFindPath(i - 1, j, path + 'U', grid, list); // UP
        recFindPath(i + 1, j, path + 'D', grid, list); // DOWN
        recFindPath(i, j + 1, path + 'R', grid, list); // RIGHT
        recFindPath(i, j - 1, path + 'L', grid, list); // LEFT

        grid[i][j] = 1; // unmark as visited (backtrack)

    }
}


