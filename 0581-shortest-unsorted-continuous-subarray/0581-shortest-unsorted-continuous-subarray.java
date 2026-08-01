class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        int lo = -1;
        int hi = -1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                lo = i;
                break;
            }
        }
        if (lo == -1) return 0;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                hi = i;
                break;
            }
        }

        int small = nums[lo], big = nums[hi];

        for (int i = lo; i <= hi; i++) {
            small = Math.min(small, nums[i]);
            big = Math.max(big, nums[i]);
        }

        while (lo > 0 && nums[lo - 1] > small) {
            lo--;
        }
        
        while (hi < n - 1 && nums[hi + 1] < big) {
            hi++;
        }

        return hi - lo + 1;
    }
}