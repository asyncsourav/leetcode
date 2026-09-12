class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);

        price[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = price.clone();

            for (int[] flight : flights) {
                    
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                if (price[from] != Integer.MAX_VALUE) {
                    temp[to] = Math.min(temp[to], price[from] + cost);
                }
            }
            price = temp;
        }

        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }
}