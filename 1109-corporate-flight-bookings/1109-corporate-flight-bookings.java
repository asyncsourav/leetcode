class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] ans = new int[n];

        for (int[] booking : bookings) {
            int start = booking[0] - 1;
            int end = booking[1];
            int num = booking[2];

            for (int i = start; i < end; i++) {
                ans[i] = ans[i] + num;
            }
        }

        return ans;
    }
}