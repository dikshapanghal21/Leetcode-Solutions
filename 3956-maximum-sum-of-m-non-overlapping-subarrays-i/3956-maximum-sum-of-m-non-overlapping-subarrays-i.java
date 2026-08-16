import java.util.*;

class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {

        int n = nums.length;

        // Prefix Sum
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // dp[k][i] = maximum sum using at most k subarrays
        // from index i to n-1
        long[][] dp = new long[m + 1][n + 1];

        long answer = Long.MIN_VALUE;

        for (int k = 1; k <= m; k++) {

            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = n - 1; i >= 0; i--) {

                // We need at least l elements
                if (i + l <= n) {

                    int idx = i + l;

                    // Remove indices outside [i+l, i+r]
                    while (!deque.isEmpty()
                            && deque.peekFirst() > i + r) {
                        deque.pollFirst();
                    }

                    /*
                     * Candidate:
                     *
                     * subarray = [i ... idx-1]
                     * remaining = dp[k-1][idx]
                     */
                    long current =
                            prefix[idx]
                            - prefix[i]
                            + dp[k - 1][idx];

                    // Remove worse candidates
                    while (!deque.isEmpty()) {

                        int last = deque.peekLast();

                        long lastValue =
                                prefix[last]
                                + dp[k - 1][last];

                        long currentValue =
                                prefix[idx]
                                + dp[k - 1][idx];

                        if (lastValue > currentValue) {
                            break;
                        }

                        deque.pollLast();
                    }

                    deque.offerLast(idx);
                }

                // Option 1: Don't start a subarray at i
                dp[k][i] = dp[k][i + 1];

                // Option 2: Start a subarray at i
                if (!deque.isEmpty()) {

                    int idx = deque.peekFirst();

                    long value =
                            prefix[idx]
                            - prefix[i]
                            + dp[k - 1][idx];

                    dp[k][i] = Math.max(dp[k][i], value);
                }
            }

            answer = Math.max(answer, dp[k][0]);
        }

        /*
         * Since dp uses 0 as "choose nothing",
         * all-negative arrays need special handling.
         */
        if (answer == 0) {

            long best = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {

                for (int len = l;
                     len <= r && i + len <= n;
                     len++) {

                    best = Math.max(
                        best,
                        prefix[i + len] - prefix[i]
                    );
                }
            }

            return best;
        }

        return answer;
    }
}