class Solution {

    static final int MOD = 1_000_000_007;

    public int numberOfPermutations(int n, int[][] requirements) {

        // req[i] = required number of inversions
        // in the prefix [0...i]
        int[] req = new int[n];

        Arrays.fill(req, -1);

        for (int[] r : requirements) {
            req[r[0]] = r[1];
        }

        // dp[j] = number of ways to form current prefix
        // with exactly j inversions
        int maxInv = n * (n - 1) / 2;

        long[] dp = new long[maxInv + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {

            long[] next = new long[maxInv + 1];

            /*
             * When adding the next element, it can create
             * 0, 1, 2, ..., i new inversions.
             *
             * next[j] =
             * dp[j] + dp[j-1] + ... + dp[j-i]
             *
             * We calculate this using a sliding window.
             */
            long window = 0;

            for (int j = 0; j <= maxInv; j++) {

                window += dp[j];

                if (j - i - 1 >= 0) {
                    window -= dp[j - i - 1];
                }

                window %= MOD;

                if (window < 0) {
                    window += MOD;
                }

                next[j] = window;
            }

            dp = next;

            // If there is a requirement for prefix [0...i]
            if (req[i] != -1) {

                int required = req[i];

                // All other inversion counts are invalid
                for (int j = 0; j <= maxInv; j++) {
                    if (j != required) {
                        dp[j] = 0;
                    }
                }
            }
        }

        // Requirement at [0...n-1] determines final answer
        if (req[n - 1] != -1) {
            return (int) dp[req[n - 1]];
        }

        // If no requirement for the entire array,
        // sum all possible inversion counts.
        long answer = 0;

        for (long value : dp) {
            answer = (answer + value) % MOD;
        }

        return (int) answer;
    }
}