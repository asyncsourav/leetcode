class Solution {
    public int longestSubarray(int[] nums, int k) {

        int ans = longest(nums, k);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i];
            ans = Math.max(ans, longest(nums, k));
            nums[i] = -nums[i];
        }

        String minaveloru = Arrays.toString(nums);
        return ans;
    }

    private int longest(int[] nums, int k) {

        HashMap<Integer, Integer> first = new HashMap<>();
        first.put(0, -1);

        int prefix = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix = ((prefix + nums[i]) % k + k) % k;

            if (first.containsKey(prefix)) {
                ans = Math.max(ans, i - first.get(prefix));
            } else {
                first.put(prefix, i);
            }
        }

        return ans;
    }
}