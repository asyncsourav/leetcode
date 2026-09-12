import java.util.*;

class Solution {

    static class Interval {
        int start;
        int end;
        int weight;
        int index;

        Interval(int start, int end, int weight, int index) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.index = index;
        }
    }

    Interval[] arr;
    List<Integer>[][] dp;
    long[] weight;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        arr = new Interval[n];
        weight = new long[n];

        for (int i = 0; i < n; i++) {

            int l = intervals.get(i).get(0);
            int r = intervals.get(i).get(1);
            int w = intervals.get(i).get(2);

            arr[i] = new Interval(l, r, w, i);
            weight[i] = w;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.start != b.start)
                return Integer.compare(a.start, b.start);

            return Integer.compare(a.end, b.end);
        });

        dp = new ArrayList[n + 1][5];

        List<Integer> answer = solve(0, 4);

        Collections.sort(answer);

        return answer.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }

    private List<Integer> solve(int i, int remaining) {

        if (i == arr.length || remaining == 0)
            return new ArrayList<>();

        if (dp[i][remaining] != null)
            return dp[i][remaining];

        // Don't take
        List<Integer> notTake = solve(i + 1, remaining);

        // Take
        int next = findNext(i);

        List<Integer> take = new ArrayList<>();
        take.add(arr[i].index);
        take.addAll(solve(next, remaining - 1));

        dp[i][remaining] = better(take, notTake);

        return dp[i][remaining];
    }

    private int findNext(int i) {

        int low = i + 1;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid].start > arr[i].end)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    private List<Integer> better(List<Integer> a, List<Integer> b) {

        long scoreA = getScore(a);
        long scoreB = getScore(b);

        if (scoreA > scoreB)
            return a;

        if (scoreB > scoreA)
            return b;

        List<Integer> x = new ArrayList<>(a);
        List<Integer> y = new ArrayList<>(b);

        Collections.sort(x);
        Collections.sort(y);

        int size = Math.min(x.size(), y.size());

        for (int i = 0; i < size; i++) {

            if (!x.get(i).equals(y.get(i)))
                return x.get(i) < y.get(i) ? a : b;
        }

        return x.size() <= y.size() ? a : b;
    }

    private long getScore(List<Integer> indices) {

        long total = 0;

        for (int index : indices)
            total += weight[index];

        return total;
    }
}