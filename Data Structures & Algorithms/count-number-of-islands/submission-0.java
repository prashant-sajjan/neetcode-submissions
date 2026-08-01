class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return -1;
        }    

        int m = grid.length;
        int n = grid[0].length;

        int maxCount = 0;
        for (int i = 0; i < m ; i++) {
            for(int j = 0; j <n; j++) {
                 if(grid[i][j] == '1') {
                     dfs(grid, i, j);
                     maxCount++;
                }
            }
        }    

        return maxCount;
    }

    private void dfs(char[][] grid, int row, int col) {
        if(row >= 0 && row<grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
            grid[row][col] ='2';
            dfs(grid, row-1, col);
            dfs(grid, row + 1, col);
            dfs(grid, row, col -1);
            dfs(grid, row, col + 1);
        }
    }
}

