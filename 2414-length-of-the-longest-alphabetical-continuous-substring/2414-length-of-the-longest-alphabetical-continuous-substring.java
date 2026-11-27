class Solution {
    public int longestContinuousSubstring(String s) {
        
        int count = 1;
        int ans = 1;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) - s.charAt(i - 1) == 1)
                count++;
            else {
                ans = Math.max(count, ans);
                count = 1;
            }
        }

        ans = Math.max(count, ans);
        return ans;
    }
}