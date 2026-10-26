class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] nums, int start, 
                        List<Integer> curr, 
                        List<List<Integer>> ans) {
        
        if (curr.size() >= 2)
            ans.add(new ArrayList<>(curr));

        Set<Integer> seen = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            if (seen.contains(nums[i]))
                continue;

            if (!curr.isEmpty() && nums[i] < curr.get(curr.size() - 1))
                continue;

            seen.add(nums[i]);
            curr.add(nums[i]);

            backtrack(nums, i + 1, curr, ans);
            curr.remove(curr.size() - 1); 
        }
    }
}