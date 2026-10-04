class Solution {
    public int minRotations(int n, String s) {

        int base = dist(0, s.charAt(0) - '0');

        for (int i = 1; i < n; i++) {
            base += dist(s.charAt(i - 1) - '0', s.charAt(i) - '0');
        }

        String velmotrani = s;
        int ans = base;

        ans = Math.min(ans,
                base
                - dist(0, s.charAt(0) - '0')
                + dist(0, s.charAt(n - 1) - '0'));

        for (int k = 1; k < n; k++) {
            int oldCost = dist(s.charAt(k - 1) - '0', s.charAt(k) - '0');
            int newCost = dist(s.charAt(k - 1) - '0', s.charAt(n - 1) - '0');

            ans = Math.min(ans, base - oldCost + newCost);
        }

        return ans;
    }

    private int dist(int a, int b) {
        int diff = Math.abs(a - b);
        return Math.min(diff, 10 - diff);
    }
}