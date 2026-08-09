class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] rank = new int[26];

        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {

            String a = words[i];
            String b = words[i + 1];

            int len = Math.min(a.length(), b.length());
            boolean different = false;

            for (int j = 0; j < len; j++) {
                if (a.charAt(j) != b.charAt(j)) {

                    if (rank[a.charAt(j) - 'a'] > rank[b.charAt(j) - 'a'])
                        return false;

                    different = true;
                    break;
                }
            }

            if (!different && a.length() > b.length())
                return false;
        }

        return true;
    }
}