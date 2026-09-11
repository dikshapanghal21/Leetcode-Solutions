class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] columns = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1];
        boolean[] diagonal2 = new boolean[2 * n - 1];

        backtrack(0, n, columns, diagonal1, diagonal2);

        return count;
    }

    private void backtrack(int row, int n, boolean[] columns,
                           boolean[] diagonal1, boolean[] diagonal2) {

        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            int diag1 = row - col + n - 1;
            int diag2 = row + col;

            if (columns[col] || diagonal1[diag1] || diagonal2[diag2]) {
                continue;
            }

            // Place Queen
            columns[col] = true;
            diagonal1[diag1] = true;
            diagonal2[diag2] = true;

            backtrack(row + 1, n, columns, diagonal1, diagonal2);

            // Remove Queen (Backtracking)
            columns[col] = false;
            diagonal1[diag1] = false;
            diagonal2[diag2] = false;
        }
    }
}