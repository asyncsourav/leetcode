class Solution {
    public void moveZeroes(int[] nums) {
        
        int idx = 0; // idx = non - zero elements

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                Swap(nums, i, idx);
                idx++;
            }
        }
    }

    private void Swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}