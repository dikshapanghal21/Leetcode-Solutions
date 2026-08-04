import java.util.*;

class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int ans = Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int[] dist = new int[n];
            Arrays.fill(dist, -1);

            int[] parent = new int[n];
            Arrays.fill(parent, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            dist[start] = 0;

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int next : graph[node]) {
                    if (dist[next] == -1) {
                        dist[next] = dist[node] + 1;
                        parent[next] = node;
                        queue.offer(next);
                    } else if (parent[node] != next) {
                        ans = Math.min(ans, dist[node] + dist[next] + 1);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}