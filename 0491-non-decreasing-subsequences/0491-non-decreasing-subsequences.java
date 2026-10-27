class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int start,
                            List<List<Integer>> ans,
                            List<Integer> curr) {
        
        if (curr.size() >= 2)
            ans.add(new ArrayList<>(curr));

        HashSet<Integer> set = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            if (!set.contains(nums[i]) &&  
                (curr.isEmpty() || nums[i] >= curr.get(curr.size() - 1))) {
            
                curr.add(nums[i]);
                set.add(nums[i]);

                backtrack(nums, i + 1, ans, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}