class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i = 0; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            if(i >= k - 1) {
                while(queue.peek()[1] <= i - k) {
                    queue.poll();
                }
                result[left++] = queue.peek()[0];
            }
        }
        return result;
    }
}
