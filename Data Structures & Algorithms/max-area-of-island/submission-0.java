class Solution {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area, dfs(grid, i, j));
                }
            }
        }
        return area;
    }
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int result = 1;
        for (int[] dir : directions) {
            result += dfs(grid, i + dir[0], j + dir[1]);
        }
        return result;
    }
}
