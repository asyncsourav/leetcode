class Solution {
    public String largestMerge(String word1, String word2) {
        
        int i = 0; // word 1
        int j = 0; // word 2

        StringBuilder merge = new StringBuilder();

        while (i < word1.length() && j < word2.length()) {

            if (word1.charAt(i) > word2.charAt(j))
                merge.append(word1.charAt(i++));

            else if (word1.charAt(i) < word2.charAt(j))
                merge.append(word2.charAt(j++));

            else if (word1.charAt(i) == word2.charAt(j)) {
                int word = check(word1, word2, i, j);

                if (word == 1)
                    merge.append(word1.charAt(i++));
                else 
                    merge.append(word2.charAt(j++));
            }
        }

        while (i < word1.length()) {
            merge.append(word1.charAt(i++));
        }

        while (j < word2.length()) {
            merge.append(word2.charAt(j++));
        }

        return merge.toString();
    }

    private int check(String word1, String word2, int i, int j) {

        while (i < word1.length() && j < word2.length()) {

            if (word1.charAt(i) > word2.charAt(j)) 
                return 1;

            else if (word1.charAt(i) < word2.charAt(j)) 
                return 2;
            
            i++;
            j++;
        }

        return (i == word1.length()) ? 2 : 1;
    }
}