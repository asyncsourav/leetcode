class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        Arrays.sort(heaters);
        int ans = 0;

        for (int house : houses) {
            
            int idx = lowerBound(heaters, house);

            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;

            if (idx > 0) 
                left = house - heaters[idx - 1];

            if (idx < heaters.length)
                right = heaters[idx] - house;

            int closest = Math.min(left, right);

            ans = Math.max(ans, closest);
        }

        return ans;
    }

    private int lowerBound(int[] heaters, int target) {

        int low = 0;
        int high = heaters.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (heaters[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}