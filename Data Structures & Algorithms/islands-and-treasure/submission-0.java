class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i =0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(grid[i][j]==0) {
                    q.offer(new int[] {i,j});
                }
            }
        }

        int[][] directions = { {1,0}, {-1,0}, {0, 1}, {0, -1}}; 

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] dir: directions) {
                int x = row + dir[0];
                int y = col + dir [1];

                if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[x][y] = grid[row][col] + 1;
                q.offer(new int[]{x,y});
            }

        }

    }
}
