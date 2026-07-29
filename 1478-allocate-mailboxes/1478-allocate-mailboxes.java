import java.util.*;

class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);

        int n = houses.length;
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int median = houses[(i + j) / 2];

                for (int x = i; x <= j; x++) {
                    cost[i][j] += Math.abs(houses[x] - median);
                }
            }
        }

        int[][] dp = new int[k + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }

        dp[0][0] = 0;

        for (int m = 1; m <= k; m++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[m][i] = Math.min(
                        dp[m][i],
                        dp[m - 1][j] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}