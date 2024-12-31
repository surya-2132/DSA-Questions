package SlidingWindow.WindowProblems;

public class CelebrityProblem {

    public static void main(String[] args) {
        int[][] mat = { {0, 1, 1, 0}, {0, 0, 0, 0}, {1, 1, 0, 0}, {0, 1, 1, 0} };
        System.out.println("Row num "+celebrity(mat) + " is celebrity");
    }


    public static int celebrityBrute(int[][] M) {
        int n = M.length;

        // To store count of people who know person of index i
        int[] knowMe = new int[n];

        // To store count of people who the person of index i knows
        int[] Iknow = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // If person i knows person j
                if (M[i][j] == 1) {
                    knowMe[j]++;
                    Iknow[i]++;
                }
            }
        }

        // Traverse for all persons to find the celebrity
        for (int i = 0; i < n; i++) {
            // Return the index of celebrity
            if (knowMe[i] == n - 1 && Iknow[i] == 0) {
                return i;
            }
        }

        return -1; // Return -1 if no celebrity is found
    }




    public static int celebrity(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int top = 0;
        int bottom = n-1;

        while(top < bottom){
            //check if top knows bottom, which means top cannot be celebrity
            if(mat[top][bottom] == 1){
                top++;
            }
            //check if bottom knows top, which means bottom cannot be celebrity
            else if(mat[bottom][top] == 1){
                bottom--;
            }
            else{
                //if both top and bottom don't know eachother,
                //someone should know the other person
                //if no one knows eachother both cannot be a celebrity
                top++;
                bottom--;
            }
        }

        //if no celebrity is found
        if(top > bottom) return -1;

        for(int i = 0; i < n; i++){
            if(i == top) continue; // diagonal like 0,0 or 1,1, or 2,2 etc...
            //check the entire curr row to ensure it contains 1 or not
            if(mat[top][i] == 0 && mat[i][top] == 1){
                continue;
            }
            else{
                return -1;
            }
        }

        return top; //index of celebrity

    }
}
