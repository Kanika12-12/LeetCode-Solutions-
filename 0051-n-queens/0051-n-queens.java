import java.util.*;

class Solution {
    static boolean isSafeToPlace(int rowIndex, int colIndex, int n, char[][] board) {
        int row = rowIndex;
        int col = colIndex;
        while (col >= 0) {
            if (board[row][col] == 'Q') { 
                return false;
            }
            col--;
        }

        row = rowIndex;
        col = colIndex;
        while (row >= 0 && col >= 0) { 
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = rowIndex;
        col = colIndex;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    public static void solve(char[][] board, int n, int colIndex, List<List<String>> ans) {
        if (colIndex >= n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            if (isSafeToPlace(rowIndex, colIndex, n, board)) { 
                board[rowIndex][colIndex] = 'Q';
                solve(board, n, colIndex + 1, ans);
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.'); 
        }
        int colIndex = 0;
        List<List<String>> ans = new ArrayList<>();
        solve(board, n, colIndex, ans);
        return ans;
    }
}