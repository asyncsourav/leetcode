class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(nums[b], nums[a])
        );

        for (int i = 0; i < n; i++) {
            pq.offer(i);

            while (!pq.isEmpty() && pq.peek() <= i - k) {
                pq.poll();
            }

            if (i >= k - 1) {
                ans[i - k + 1] = nums[pq.peek()];
            }
        }

        return ans;
    }
}