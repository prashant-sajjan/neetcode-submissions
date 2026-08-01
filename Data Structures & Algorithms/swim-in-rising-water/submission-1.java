class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        boolean[][] visit = new boolean[N][N];

        PriorityQueue<int[]> minH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minH.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;

        int[][] dir = {{0,1}, {0, -1}, {1,0},{-1,0}};
        while(!minH.isEmpty()) {
            int[] curr = minH.poll();
            int t = curr[0], r = curr[1], c = curr[2];

            if(r == N-1 && c == N-1) {
                return t;
            }

            for(int[] d: dir) {
                int neiR = r + d[0], neiC = c +d[1];
                if(neiR >= 0 && neiC >= 0 && neiR < N && neiC < N 
                    && !visit[neiR][neiC]) {
                        visit[neiR][neiC] = true;
                        minH.offer(new int[] {Math.max(t, grid[neiR][neiC]), neiR, neiC});
                    }
            }  
        }
        return N * N;
    }
}
