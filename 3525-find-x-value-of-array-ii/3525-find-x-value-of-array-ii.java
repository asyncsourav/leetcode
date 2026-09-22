class Solution {

    static class Node {
        int product;
        int[] count;

        Node(int k) {
            count = new int[k];
        }
    }

    int n;
    int k;
    int[] nums;
    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.nums = nums;
        this.k = k;
        this.n = nums.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Persistent update
            nums[index] = value;
            update(1, 0, n - 1, index, value);

            // Query [start, n - 1]
            Node ans = query(1, 0, n - 1, start, n - 1);

            result[q] = ans.count[x];
        }

        return result;
    }

    // ---------------- BUILD ----------------

    private void build(int node, int left, int right) {
        if (left == right) {
            tree[node] = createLeaf(nums[left]);
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // ---------------- UPDATE ----------------

    private void update(int node, int left, int right, int index, int value) {
        if (left == right) {
            tree[node] = createLeaf(value);
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // ---------------- QUERY ----------------

    private Node query(int node, int left, int right, int ql, int qr) {

        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        if (qr <= mid) {
            return query(node * 2, left, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, right, ql, qr);
        }

        Node leftNode = query(node * 2, left, mid, ql, qr);
        Node rightNode = query(node * 2 + 1, mid + 1, right, ql, qr);

        return merge(leftNode, rightNode);
    }

    // ---------------- LEAF ----------------

    private Node createLeaf(int value) {
        Node node = new Node(k);

        int remainder = value % k;

        node.product = remainder;
        node.count[remainder] = 1;

        return node;
    }

    // ---------------- MERGE ----------------

    private Node merge(Node left, Node right) {
        Node result = new Node(k);
        result.product = (int) ((long) left.product * right.product % k);

        for (int r = 0; r < k; r++) {
            result.count[r] += left.count[r];
        }

        for (int r = 0; r < k; r++) {
            if (right.count[r] == 0) {
                continue;
            }

            int newRemainder =
                    (int) ((long) left.product * r % k);

            result.count[newRemainder] += right.count[r];
        }

        return result;
    }
}