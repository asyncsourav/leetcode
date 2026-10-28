class Solution {
    public String largestMerge(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();

        int i = 0; // word 1
        int j = 0; // word 2

        StringBuilder sb = new StringBuilder();

        while (i < m && j < n) {

            if (word1.charAt(i) > word2.charAt(j))
                sb.append(word1.charAt(i++));

            else if (word1.charAt(i) < word2.charAt(j))
                sb.append(word2.charAt(j++));

            else {
                if (check(word1, word2, m, n, i, j) == 1)
                    sb.append(word1.charAt(i++));
                else
                    sb.append(word2.charAt(j++));
            }
        }

        while (i < m) {
            sb.append(word1.charAt(i++));
        }

        while (j < n) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }

    private int check(String word1, String word2, 
                    int m, int n, int i, int j) {
        
        while (i < m && j < n && 
                word1.charAt(i) == word2.charAt(j)) {
            
            i++;
            j++;
        }

        if (i == m) 
            return 2;
        else if (j == n)
            return 1;

        return (word1.charAt(i) > word2.charAt(j)) ? 1 : 2;
    }
}