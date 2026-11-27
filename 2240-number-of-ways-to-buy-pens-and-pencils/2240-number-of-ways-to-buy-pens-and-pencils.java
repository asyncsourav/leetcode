class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {

        long count = 0;

        for (int i = 0; i <= total / cost1; i++) {
            count += (total - (cost1 * i)) / cost2 + 1;
        }

        return count;
    }
}