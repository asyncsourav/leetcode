class Solution {
    public int[][] intervalIntersection(int[][] fir, int[][] sec) {
        
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < fir.length && j < sec.length) {
            int start = Math.max(fir[i][0], sec[j][0]);
            int last = Math.min(fir[i][1], sec[j][1]);

            if (start <= last)
                ans.add(new int[]{start, last});

            if (fir[i][1] < sec[j][1]) 
                i++;
            else 
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}