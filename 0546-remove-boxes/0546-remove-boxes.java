class Solution {
    int[][][] dp;

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp = new int[n][n][n];

        return solve(boxes, 0, n - 1, 0);
    }

    private int solve(int[] boxes, int l, int r, int k) {

        if (l > r) {
            return 0;
        }

        if (dp[l][r][k] != 0) {
            return dp[l][r][k];
        }

        // Combine boxes[l] with consecutive boxes of the same color
        int originalL = l;
        int originalK = k;

        while (l + 1 <= r && boxes[l] == boxes[l + 1]) {
            l++;
            k++;
        }

        // Option 1:
        // Remove the current group first
        int result = (k + 1) * (k + 1)
                   + solve(boxes, l + 1, r, 0);

        // Option 2:
        // Keep boxes[l] and merge it with a later
        // box of the same color
        for (int i = l + 1; i <= r; i++) {

            if (boxes[i] == boxes[l]) {

                int points = solve(boxes, l + 1, i - 1, 0)
                           + solve(boxes, i, r, k + 1);

                result = Math.max(result, points);
            }
        }

        dp[originalL][r][originalK] = result;

        return result;
    }
}