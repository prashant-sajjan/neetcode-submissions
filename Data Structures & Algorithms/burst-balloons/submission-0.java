class Solution {

    private int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for(int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        dp = new int[n + 2][n + 2];

        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs(newNums, 1, newNums.length - 2);
    }

    private int dfs(int[] nums, int l, int r) {
        if(l > r) {
            return 0;
        }

        if(dp[l][r] != -1) {
            return dp[l][r];
        }

        dp[l][r] = 0;

        for(int i = l; i <= r; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(nums, l, i - 1) + dfs(nums, i + 1, r);

            dp[l][r] = Math.max(dp[l][r], coins);
        }

        return dp[l][r];
    }
}
