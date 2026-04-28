class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int stone : stones) {
            queue.offer(-stone);
        }
        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            if (first < second) {
                int diff = first - second;
                queue.offer(diff);
            }
        }
        queue.offer(0);
        return Math.abs(queue.peek());
    }
}
