class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int baseSatisfied = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                baseSatisfied += customers[i];
            }
        }

        int extra = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                extra += customers[i];
            }
        }

        int maxExtra = extra;

        for (int i = minutes; i < customers.length; i++) {
            // Remove left element
            if (grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes];
            }

            // Add right element
            if (grumpy[i] == 1) {
                extra += customers[i];
            }

            maxExtra = Math.max(maxExtra, extra);
        }

        return baseSatisfied + maxExtra;
    }
}