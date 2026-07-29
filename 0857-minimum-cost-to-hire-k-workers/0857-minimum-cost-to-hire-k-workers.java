class Solution {

    static class Worker implements Comparable<Worker> {
        int quality;
        int wage;
        double ratio;

        Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = (double) wage / quality;
        }

        @Override
        public int compareTo(Worker other) {
            return Double.compare(this.ratio, other.ratio);
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        int n = quality.length;
        Worker[] workers = new Worker[n];

        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int totalQuality = 0;
        double ans = Double.MAX_VALUE;

        for (Worker worker : workers) {

            maxHeap.offer(worker.quality);
            totalQuality += worker.quality;

            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                ans = Math.min(ans, totalQuality * worker.ratio);
            }
        }

        return ans;
    }
}