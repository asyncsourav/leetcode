class Solution {
    public int bestClosingTime(String customers) {

        int n = customers.length();

        int[] st = new int[n + 1];
        int[] end = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st[i] = st[i - 1];

            if (customers.charAt(i - 1) == 'N') {
                st[i]++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            end[i] = end[i + 1];

            if (customers.charAt(i) == 'Y') {
                end[i]++;
            }
        }

        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;

        for (int i = 0; i <= n; i++) {
            int penalty = st[i] + end[i];

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i;
            }
        }

        return bestHour;
    }
}