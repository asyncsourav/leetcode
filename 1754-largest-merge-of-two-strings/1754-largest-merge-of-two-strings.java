class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        char[] ch1=word1.toCharArray();
        char[] ch2=word2.toCharArray();
        int len1=ch1.length;
        int len2=ch2.length;

        int i=0;
        int j=0;
        while (i<len1 && j<len2) {
            if (ch1[i]==ch2[j]) {
                if (check(ch1,ch2,i,j)) {
                    sb.append(ch2[j]);
                    j++;
                } else {
                    sb.append(ch1[i]);
                    i++;
                }
            } else if (ch1[i]>ch2[j]) {
                sb.append(ch1[i]);
                i++;
            } else {
                sb.append(ch2[j]);
                j++;
            }
        }

        sb.append(word1.substring(i));
        sb.append(word2.substring(j));

        return sb.toString();
    }

    boolean check(char[] ch1, char[] ch2, int i, int j) {
        int len1=ch1.length;
        int len2=ch2.length;

        while (i<len1 && j<len2 && ch1[i]==ch2[j]) {
            i++;
            j++;
        }
        if (i==len1) return true;
        if (j==len2) return false;
        return ch1[i]<ch2[j];
    }
}