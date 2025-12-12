package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class RepeatingAndMissing2DArr {
    public static void main(String[] args) {

        int[][] grid = {
                {9,1,7},
                {8,9,2},  // 3 is repeated, 4 is missing (for a 2x2 grid)
                {3,4,6}
        };

        int[] result = findMissingAndRepeatedValues(grid);

        System.out.println("Repeated: " + result[0]);
        System.out.println("Missing: " + result[1]);
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {

        int max2DArrLen = grid.length * grid.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }


        int[] result = new int[2];
        for(int i = 1; i <= max2DArrLen; i++){
            int count = map.getOrDefault(i, 0);

            if(count == 2) result[0] = i; //repeated
            if(count == 0) result[1] = i; //missing
        }

        return result;
    }
}
