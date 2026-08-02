import java.util.*;

class Solution {
    private static final int LIMIT = 20000;
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockedSet = new HashSet<>();

        for (int[] b : blocked) {
            blockedSet.add(hash(b[0], b[1]));
        }

        return bfs(source, target, blockedSet) &&
               bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] start, int[] finish, Set<Long> blockedSet) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();

        queue.offer(start);
        visited.add(hash(start[0], start[1]));

        while (!queue.isEmpty() && visited.size() <= LIMIT) {
            int[] cur = queue.poll();

            if (cur[0] == finish[0] && cur[1] == finish[1]) {
                return true;
            }

            for (int[] d : DIRS) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr < 0 || nr >= 1000000 || nc < 0 || nc >= 1000000) {
                    continue;
                }

                long key = hash(nr, nc);

                if (blockedSet.contains(key) || visited.contains(key)) {
                    continue;
                }

                visited.add(key);
                queue.offer(new int[]{nr, nc});
            }
        }

        return visited.size() > LIMIT;
    }

    private long hash(int x, int y) {
        return ((long) x << 20) | y;
    }
}