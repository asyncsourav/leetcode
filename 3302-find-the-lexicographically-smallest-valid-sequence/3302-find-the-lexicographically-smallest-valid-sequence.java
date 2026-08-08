class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m + 1];

        // last[j] = latest index in word1 from which
        // word2[j...] can be matched exactly.
        int i = n - 1;

        for (int j = m - 1; j >= 0; j--) {

            while (i >= 0 && word1.charAt(i) != word2.charAt(j)) {
                i--;
            }

            if (i < 0) {
                last[j] = -1;
            } else {
                last[j] = i--;
            }
        }

        int[] ans = new int[m];

        int p = 0;
        boolean mismatchUsed = false;

        for (i = 0; i < n && p < m; i++) {

            if (word1.charAt(i) == word2.charAt(p)) {
                ans[p++] = i;
            }
            else if (!mismatchUsed) {

                // Can we use i as the one mismatch?
                if (p == m - 1 || i < last[p + 1]) {
                    ans[p++] = i;
                    mismatchUsed = true;
                }
            }
        }

        if (p != m) {
            return new int[0];
        }

        return ans;
    }
}