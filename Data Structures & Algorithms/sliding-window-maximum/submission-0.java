class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n = nums.length;
       Deque<Integer> q = new LinkedList<>();
       int[] res = new int[n - k + 1];
       int l = 0, r = 0;

       while(r < n) {

        while(!q.isEmpty() && nums[q.getLast()] < nums[r]) {
            q.removeLast();
        }

        q.addLast(r);

        if(l > q.getFirst()) {
            q.removeFirst();
        }

        if(r + 1 >= k) {
            res[l] = nums[q.getFirst()];
            l++;
        }
        r++;
       }
        return res;
    }
}
