package Recursion.Hard;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F' ,'C' ,'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(wordSearch(board, "ABCCED")); //ASFS for false
    }

    public static boolean wordSearch(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // If the first character matches each time, start the search again
                if(board[i][j] == word.charAt(0)){
                    // If the word is found, return true
                    if(recSearch(0, i, j, board, word)){
                        return true;
                    }
                }
            }
        }
        // If the word is not found, return false
        return false;
    }

    private static boolean recSearch(int index, int i, int j, char[][] board, String word){
        int n = board.length;
        int m = board[0].length;

        if(index == word.length()){
            return true;
        }

        // Boundary conditions and character mismatch check
        if(i < 0 || j < 0 || i >= n || j >= m ||
                board[i][j] == ' ' || board[i][j] != word.charAt(index)){
            return false;
        }

        // Temporarily mark the cell as visited
        char temp = board[i][j];
        board[i][j] = ' ';

        // Check all four possible directions (up, right, down, left)
        boolean ans = recSearch(index + 1, i - 1, j, board, word) ||
                      recSearch(index + 1, i, j + 1, board, word) ||
                      recSearch(index + 1, i + 1, j, board, word) ||
                      recSearch(index + 1, i, j - 1, board, word);

        // Restore the original character in the cell
        board[i][j] = temp;
        return ans;
    }
}
