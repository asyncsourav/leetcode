class Solution {
    public long maximumImportance(int n, int[][] roads) {
        
        long[] degree = new long[n];

        for (int[] arr : roads) {
            degree[arr[0]]++;
            degree[arr[1]]++;
        }

        Arrays.sort(degree);

        long num = 1;
        long ans = 0;

        for (long val : degree) {
            ans = ans + (num * val);
            num = num + 1;
        }

        return ans;
    }
}