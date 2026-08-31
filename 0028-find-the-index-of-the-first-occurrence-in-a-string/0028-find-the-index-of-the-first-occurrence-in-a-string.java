class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // Try every possible starting position
        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            // Check whether needle matches from position i
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // Entire needle matched
            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}