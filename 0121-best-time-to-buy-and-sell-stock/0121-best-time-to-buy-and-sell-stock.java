class Solution {
    public int maxProfit(int[] prices) {

        int lowest = prices[0];
        int maxProfit = 0;

        for (int num : prices) {

            if (num < lowest) {
                lowest = num;
            } else {
                maxProfit = Math.max(maxProfit, num - lowest);
            }
        }

        return maxProfit;
    }
}