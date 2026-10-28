class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        int n = flowers.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] ans = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            int a = upper(start, people[i]);
            int b = lower(end, people[i]);

            ans[i] = a - b;
        }

        return ans;
    }

    private int upper(int[] start, int num) {
        int low = 0;
        int high = start.length;

        while (low < high) {
            int mid = low + (high - low)/2;

            if (start[mid] <= num)  
                low = mid + 1;
            else 
                high = mid;
        }

        return low;
    }

    private int lower(int[] end, int num) {
        int low = 0;
        int high = end.length;

        while (low < high) {
            int mid = low + (high - low)/2;

            if (end[mid] < num)  
                low = mid + 1;
            else 
                high = mid;
        }

        return low;
    }
}