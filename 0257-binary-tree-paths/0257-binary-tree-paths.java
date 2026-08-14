class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        dfs(root, "", result);

        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {

        if (node == null) {
            return;
        }

        // Add current node to path
        if (path.length() == 0) {
            path = String.valueOf(node.val);
        } else {
            path = path + "->" + node.val;
        }

        // If leaf node, store the path
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // Go left
        dfs(node.left, path, result);

        // Go right
        dfs(node.right, path, result);
    }
}