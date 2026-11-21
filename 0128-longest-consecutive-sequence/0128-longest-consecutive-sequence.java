class Solution {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0)
            return 0;
            
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;

        for (int num : set) {
            
            if (!set.contains(num - 1)) {
                int count = 1;
                int currentno = num;

                while (set.contains(currentno + 1)) {
                    count += 1;
                    currentno += 1;
                }

                longest = Math.max(count, longest);
            }
        }

        return longest;
    }
}