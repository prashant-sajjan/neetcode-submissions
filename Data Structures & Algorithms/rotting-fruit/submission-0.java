class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) {
            return -1;
        }

        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        for(int i =0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j]==1) {
                    freshOranges++;
                } else if(grid[i][j] == 2) {
                    q.offer(new int[] {i,j});
                }
            }
        }

        int mins = 0;
        while(!q.isEmpty() && freshOranges > 0) {
            int size = q.size();
            System.out.println("size : "+size);
            for(int i = 0; i < size; i ++) {
                int[] cell = q.poll();
                int[][] dir = {{1,0}, {-1,0},{0,1},{0,-1}};
                for(int[] d : dir) {
                    int x = cell[0] + d[0];
                    int y = cell[1] + d[1];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                    && grid[x][y]==1) {
                        grid[x][y] = 2;
                        q.add(new int[]{x,y});
                        freshOranges--;
                    }
                }
            }
            mins++;
        }

        System.out.println("freshOranges : "+freshOranges);
        System.out.println("mins : "+mins);

        if(freshOranges == 0) {
            return mins;
        } else {
            return -1;
        }
    }
}
