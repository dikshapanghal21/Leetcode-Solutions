class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        if (n == 0 || k == 0) return 0;

        // If k is large enough, treat it as unlimited transactions
        if (k >= n / 2) {
            int profit = 0;

            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }

        int[][] dp = new int[k + 1][n];

        for (int transaction = 1; transaction <= k; transaction++) {
            int maxDiff = -prices[0];

            for (int day = 1; day < n; day++) {
                dp[transaction][day] = Math.max(
                    dp[transaction][day - 1],
                    prices[day] + maxDiff
                );

                maxDiff = Math.max(
                    maxDiff,
                    dp[transaction - 1][day] - prices[day]
                );
            }
        }

        return dp[k][n - 1];
    }
}