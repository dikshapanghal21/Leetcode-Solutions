class Solution {
    private int rows, cols;
    private int originalColor;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        rows = grid.length;
        cols = grid[0].length;
        originalColor = grid[row][col];

        boolean[][] visited = new boolean[rows][cols];
        dfs(grid, row, col, visited);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == -originalColor) {
                    grid[i][j] = color;
                }
            }
        }

        return grid;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean isBorder = false;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                isBorder = true;
            } else if (Math.abs(grid[nr][nc]) != originalColor) {
                isBorder = true;
            } else if (!visited[nr][nc]) {
                dfs(grid, nr, nc, visited);
            }
        }

        if (isBorder) {
            grid[r][c] = -originalColor;
        }
    }
}