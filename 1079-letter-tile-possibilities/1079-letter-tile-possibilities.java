class Solution {
    public int numTilePossibilities(String tiles) {
        
        int[] freq = new int[26];
        for (char ch : tiles.toCharArray()) {
            freq[ch - 'A']++;
        }

        return backtrack(freq);
    }

    private int backtrack(int[] freq) {
        int count = 0;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0)
                continue;

            count += 1;
            freq[i]--;

            count += backtrack(freq);
            freq[i]++;
        }

        return count;
    }
}