class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();

        if(n > m) {
            return 0;
        }

        dp = new int[m][n];

        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs (s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j) {
        if(j == t.length()) {
            return 1;
        }

        if(i == s.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = dfs(s, t, i+1, j);
        if(s.charAt(i) == t.charAt(j)) {
            res += dfs(s, t, i+1, j+1);
        }

        dp[i][j] = res;
        return res;
    }
}
