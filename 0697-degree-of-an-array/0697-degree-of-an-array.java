class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!map.containsKey(num)) {
                map.put(num, new int[]{1, i, i});
            } 
            else {
                int[] arr = map.get(num);
                arr[0]++;
                arr[2] = i;
            }
        }

        int degree = 0;
        int minLength = Integer.MAX_VALUE;

        for (int[] arr : map.values()) {

            if (arr[0] > degree) {
                degree = arr[0];
                minLength = arr[2] - arr[1] + 1;
            } 
            else if (arr[0] == degree) {
                minLength = Math.min(minLength, arr[2] - arr[1] + 1);
            }
        }

        return minLength;
    }
}