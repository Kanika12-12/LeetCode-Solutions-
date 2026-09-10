class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[] dirs = {0, 1, 0, -1, 0};
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                int[] curr = queue.poll();
                dist[curr[0]][curr[1]] = level;
                for (int d = 0; d < 4; d++) {
                    int nx = curr[0] + dirs[d];
                    int ny = curr[1] + dirs[d+1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && 
                        !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            level++;
        }
        
        return dist;
    }
}