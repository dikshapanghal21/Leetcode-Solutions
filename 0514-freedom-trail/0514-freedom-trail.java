import java.util.*;

class Solution {

    public int findRotateSteps(String ring, String key) {

        int n = ring.length();

        // Store all positions of each character in the ring
        List<Integer>[] positions = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            positions[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            positions[ring.charAt(i) - 'a'].add(i);
        }

        // memo[keyIndex][ringPosition]
        int[][] memo = new int[key.length()][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(ring, key, 0, 0, positions, memo);
    }

    private int dfs(
        String ring,
        String key,
        int keyIndex,
        int currentPos,
        List<Integer>[] positions,
        int[][] memo
    ) {

        // All characters of key have been processed
        if (keyIndex == key.length()) {
            return 0;
        }

        if (memo[keyIndex][currentPos] != -1) {
            return memo[keyIndex][currentPos];
        }

        char target = key.charAt(keyIndex);

        int answer = Integer.MAX_VALUE;

        // Try every occurrence of target in the ring
        for (int nextPos : positions[target - 'a']) {

            // Clockwise distance
            int clockwise = Math.abs(nextPos - currentPos);

            // Counter-clockwise distance
            int counterClockwise =
                ring.length() - clockwise;

            // Minimum rotation needed
            int rotation =
                Math.min(clockwise, counterClockwise);

            // +1 for pressing the button
            int total =
                rotation
                + 1
                + dfs(
                    ring,
                    key,
                    keyIndex + 1,
                    nextPos,
                    positions,
                    memo
                );

            answer = Math.min(answer, total);
        }

        memo[keyIndex][currentPos] = answer;

        return answer;
    }
}