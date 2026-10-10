import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = Integer.MIN_VALUE;

        // Make the squared dimension the smaller one
        if (rows > cols) {
            int[][] transposed = new int[cols][rows];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    transposed[j][i] = matrix[i][j];
                }
            }

            matrix = transposed;
            rows = matrix.length;
            cols = matrix[0].length;
        }

        for (int left = 0; left < cols; left++) {
            int[] sums = new int[rows];

            for (int right = left; right < cols; right++) {
                for (int r = 0; r < rows; r++) {
                    sums[r] += matrix[r][right];
                }

                TreeSet<Integer> prefixSums = new TreeSet<>();
                prefixSums.add(0);

                int prefix = 0;

                for (int sum : sums) {
                    prefix += sum;

                    // Find the smallest previous prefix >= prefix - k
                    Integer prev = prefixSums.ceiling(prefix - k);

                    if (prev != null) {
                        result = Math.max(result, prefix - prev);
                    }

                    if (result == k) {
                        return k;
                    }

                    prefixSums.add(prefix);
                }
            }
        }

        return result;
    }
}