class Solution {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Tracks whether first column should be zero
        boolean col0 = false;

        // Step 1: Mark rows and columns
        for (int i = 0; i < rows; i++) {

            // Check first column
            if (matrix[i][0] == 0) {
                col0 = true;
            }

            for (int j = 1; j < cols; j++) {

                if (matrix[i][j] == 0) {

                    // Mark the row
                    matrix[i][0] = 0;

                    // Mark the column
                    matrix[0][j] = 0;
                }
            }
        }


        // Step 2: Set inner matrix to zero
        // Traverse from bottom-right
        for (int i = rows - 1; i >= 0; i--) {

            for (int j = cols - 1; j >= 1; j--) {

                if (matrix[i][0] == 0 ||
                    matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }

            // Handle first column separately
            if (col0) {
                matrix[i][0] = 0;
            }
        }
    }
}