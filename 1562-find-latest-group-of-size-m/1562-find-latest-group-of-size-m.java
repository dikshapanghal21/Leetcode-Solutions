class Solution {
    public int findLatestStep(int[] arr, int m) {

        int n = arr.length;

        if (m == n) {
            return n;
        }

        // len[i] = length of the group whose
        // boundary is at position i
        int[] len = new int[n + 2];

        int ans = -1;

        for (int i = 0; i < n; i++) {

            int pos = arr[i];

            // Length of group immediately on left
            int left = len[pos - 1];

            // Length of group immediately on right
            int right = len[pos + 1];

            // Before merging, one of these groups
            // may itself be of size m
            if (left == m || right == m) {
                ans = i;
            }

            // New merged group length
            int total = left + right + 1;

            // Update the two boundaries
            len[pos - left] = total;
            len[pos + right] = total;
        }

        return ans;
    }
}