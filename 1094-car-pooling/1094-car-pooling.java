class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        List<int[]> start = new ArrayList<>();
        List<int[]> end = new ArrayList<>();

        for (int[] trip : trips) {
            start.add(new int[]{trip[1], trip[0]}); 
            end.add(new int[]{trip[2], trip[0]});
        }

        start.sort((a, b) -> a[0] - b[0]);
        end.sort((a, b) -> a[0] - b[0]);

        int s = 0;
        int e = 0;
        int curr = 0;

        while (s < start.size()) {

            while (e < end.size() && end.get(e)[0] <= start.get(s)[0]) {
                curr -= end.get(e)[1];
                e++;
            }

            curr += start.get(s)[1];

            if (curr > capacity) {
                return false;
            }

            s++;
        }

        return true;
    }
}