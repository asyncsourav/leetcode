class CountIntervals {

    TreeMap<Integer, Integer> map;
    int count;

    public CountIntervals() {
        map = new TreeMap<>();
        count = 0;
    }

    public void add(int left, int right) {

        Map.Entry<Integer, Integer> entry = map.floorEntry(right);

        while (entry != null && entry.getValue() >= left) {

            int l = entry.getKey();
            int r = entry.getValue();

            left = Math.min(left, l);
            right = Math.max(right, r);

            count -= r - l + 1;

            map.remove(l);

            entry = map.floorEntry(right);
        }

        map.put(left, right);
        count += right - left + 1;
    }

    public int count() {
        return count;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */