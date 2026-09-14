class Solution {
    private int n;
    private int[][] grid;
    private Map<Integer, Integer> islandSizes = new HashMap<>();
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        int color = 2;
        int maxIsland = 0;
        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(i, j, color);
                    islandSizes.put(color, size);
                    maxIsland = Math.max(maxIsland, size);
                    color++;
                } else {
                    hasZero = true;
                }
            }
        }
        if (!hasZero) return maxIsland;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> visitedIslands = new HashSet<>();
                    int newSize = 1;

                    for (int[] dir : directions) {
                        int x = i + dir[0], y = j + dir[1];
                        if (isValid(x, y) && grid[x][y] > 1) {
                            int islandColor = grid[x][y];
                            if (!visitedIslands.contains(islandColor)) {
                                visitedIslands.add(islandColor);
                                newSize += islandSizes.get(islandColor);
                            }
                        }
                    }
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }

        return maxIsland;
    }

    private int dfs(int r, int c, int color) {
        grid[r][c] = color;
        int size = 1;
        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if (isValid(nr, nc) && grid[nr][nc] == 1) {
                size += dfs(nr, nc, color);
            }
        }
        return size;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}