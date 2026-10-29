class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int r = 1; r < n; r++) {
            for (int c = 0; c < n; c++) {
               
                int minAbove = matrix[r - 1][c]; 
                
                if (c > 0) {
                    minAbove = Math.min(minAbove, matrix[r - 1][c - 1]); 
                }
                if (c < n - 1) {
                    minAbove = Math.min(minAbove, matrix[r - 1][c + 1]); 
                }
                
               
                matrix[r][c] += minAbove;
            }
        }
        
        
        int minSum = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            minSum = Math.min(minSum, matrix[n - 1][c]);
        }
        
        return minSum;
    }
}