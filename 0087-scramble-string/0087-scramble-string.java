class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();

        if (n != s2.length()) return false;
        if (s1.equals(s2)) return true;

        Boolean[][][] memo = new Boolean[n][n][n + 1];

        return solve(s1, s2, 0, 0, n, memo);
    }

    private boolean solve(String s1, String s2, int i, int j, int len,
                          Boolean[][][] memo) {

        if (memo[i][j][len] != null) {
            return memo[i][j][len];
        }

        // Check if substrings are equal
        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            return memo[i][j][len] = true;
        }

        // Check character frequencies
        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int x : count) {
            if (x != 0) {
                return memo[i][j][len] = false;
            }
        }

        // Try every possible split
        for (int k = 1; k < len; k++) {

            // Without swapping
            if (solve(s1, s2, i, j, k, memo) &&
                solve(s1, s2, i + k, j + k, len - k, memo)) {
                return memo[i][j][len] = true;
            }

            // With swapping
            if (solve(s1, s2, i, j + len - k, k, memo) &&
                solve(s1, s2, i + k, j, len - k, memo)) {
                return memo[i][j][len] = true;
            }
        }

        return memo[i][j][len] = false;
    }
}