class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        Arrays.sort(meetings, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        // count the number of meetings in a particular room 
        int[] count = new int[n];

        // all the available rooms (in increasing order)
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            available.offer(i);

        // all busy rooms with (time when they will be free, room number)
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return Long.compare(a[0], b[0]);

                return Long.compare(a[1], b[1]);
            }
        );

        for (int[] meeting : meetings) {

            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // all the busy rooms that are available now
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }

            // if there is a room available in the available pq
            if (!available.isEmpty()) {

                int currentRoom = available.poll();
                count[currentRoom] += 1;
                busy.offer(new long[]{end, currentRoom});
            }

            // if no room available then we have to wait for another to become empty
            else {
                long[] current = busy.poll();

                long availableTime = current[0];
                long availableRoom = current[1];

                count[(int)availableRoom] += 1;

                busy.offer(new long[]{
                    availableTime + duration, 
                    availableRoom
                });
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > count[ans]) 
                ans = i;    
        }

        return ans;
    }
}