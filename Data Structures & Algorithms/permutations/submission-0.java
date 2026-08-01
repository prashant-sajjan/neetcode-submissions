class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        
        res = new ArrayList<>();

        backTrack(new ArrayList<Integer>(), nums, new boolean[nums.length]);

        return res;
    }

    private void backTrack(List<Integer> per, int[] nums, boolean[] pick) {

        if(per.size() == nums.length) {
            res.add(new ArrayList<>(per));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!pick[i]) {
                per.add(nums[i]);
                pick[i] = true;
                backTrack(per, nums, pick);
                per.remove(per.size() - 1);
                pick[i] = false;
            }
        }
    } 
}
