import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                emailToName.put(account.get(i), name);
                graph.putIfAbsent(account.get(i), new ArrayList<>());

                if (i > 1) {
                    graph.get(account.get(i)).add(account.get(i - 1));
                    graph.get(account.get(i - 1)).add(account.get(i));
                }
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> merged = new ArrayList<>();
                dfs(email, graph, visited, merged);

                Collections.sort(merged);
                merged.add(0, emailToName.get(email));

                result.add(merged);
            }
        }

        return result;
    }

    private void dfs(String email,
                     Map<String, List<String>> graph,
                     Set<String> visited,
                     List<String> merged) {

        visited.add(email);
        merged.add(email);

        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, merged);
            }
        }
    }
}