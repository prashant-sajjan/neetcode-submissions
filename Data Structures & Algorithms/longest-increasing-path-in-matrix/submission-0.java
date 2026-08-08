class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dp = new int[m][n];
        int LIP = 0;

        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                LIP = Math.max(LIP, dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }

        return LIP;
    }

    private int dfs(int[][] matrix, int r, int c, int prevValue) {
        int m = matrix.length, n = matrix[0].length;
        if(r < 0 || c < 0 || r >= m || c >= n ||
            matrix[r][c] <= prevValue) {
                return 0;
        }

        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        int res = 1;

        for(int[] d : directions) {
            int x = r + d[0];
            int y = c + d[1];
            res = Math.max(res, 1 + dfs(matrix, x, y, matrix[r][c]));
        }

        dp[r][c] = res;
        return dp[r][c];
    }
}
