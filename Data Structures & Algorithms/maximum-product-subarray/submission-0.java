class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = 1, curMin = 1;

        for(int num : nums) {
            int tmp = curMax * num;
            curMax = Math.max(Math.max(curMax*num, curMin*num), num);
            curMin = Math.min(Math.min(curMin*num, tmp), num);
            res = Math.max(res, curMax);
        }

        return res;
    }
}
