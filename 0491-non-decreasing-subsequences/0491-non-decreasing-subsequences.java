class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans,
                        List<Integer> curr, int start) {
        
        if (curr.size() >= 2) 
            ans.add(new ArrayList<>(curr));

        boolean[] used = new boolean[201];

        for (int i = start; i < nums.length; i++) {

            if (!used[nums[i] + 100] && 
                (curr.isEmpty() || nums[i] >= curr.get(curr.size() - 1))) {
                
                curr.add(nums[i]);
                used[nums[i] + 100] = true;

                backtrack(nums, ans, curr, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}