class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int half = n / 2;

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Check if a palindrome can be formed
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // Number of pairs available for the left half
        int[] pairs = new int[26];

        for (int i = 0; i < 26; i++) {
            pairs[i] = freq[i] / 2;
        }

        // First, try target's left half exactly
        StringBuilder left = new StringBuilder();
        boolean canMatch = true;

        for (int i = 0; i < half; i++) {
            int c = target.charAt(i) - 'a';

            if (pairs[c] == 0) {
                canMatch = false;
                break;
            }

            pairs[c]--;
            left.append((char) ('a' + c));
        }

        // If exact left half exists, check the resulting palindrome
        if (canMatch) {
            String candidate = makePalindrome(left, middle, n);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * Find the rightmost position where we can make
         * the left half larger than target's left half.
         */
        for (int pos = half - 1; pos >= 0; pos--) {

            // Rebuild remaining pair counts for this position.
            int[] remaining = new int[26];

            for (int i = 0; i < 26; i++) {
                remaining[i] = freq[i] / 2;
            }

            // Use target's prefix [0, pos)
            boolean valid = true;

            for (int i = 0; i < pos; i++) {
                int c = target.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    valid = false;
                    break;
                }

                remaining[c]--;
            }

            if (!valid) {
                continue;
            }

            int targetChar = target.charAt(pos) - 'a';

            // Choose the smallest character greater than target[pos]
            for (int c = targetChar + 1; c < 26; c++) {
                if (remaining[c] > 0) {

                    StringBuilder newLeft = new StringBuilder();

                    // Target prefix
                    for (int i = 0; i < pos; i++) {
                        newLeft.append(target.charAt(i));
                    }

                    // First character that makes it greater
                    newLeft.append((char) ('a' + c));
                    remaining[c]--;

                    // Fill the rest in ascending order
                    for (int x = 0; x < 26; x++) {
                        while (remaining[x] > 0) {
                            newLeft.append((char) ('a' + x));
                            remaining[x]--;
                        }
                    }

                    return makePalindrome(newLeft, middle, n);
                }
            }
        }

        return "";
    }

    private String makePalindrome(StringBuilder left, char middle, int n) {
        StringBuilder result = new StringBuilder(left);

        if (n % 2 == 1) {
            result.append(middle);
        }

        result.append(new StringBuilder(left).reverse());

        return result.toString();
    }
}