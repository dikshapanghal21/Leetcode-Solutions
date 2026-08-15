class Solution {

    int cameras = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            cameras++;
        }

        return cameras;
    }

    // 0 = Node is NOT covered
    // 1 = Node has a camera
    // 2 = Node is covered

    private int dfs(TreeNode node) {

        // Null nodes are considered covered
        if (node == null) {
            return 2;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        // If any child is not covered,
        // put a camera at current node
        if (left == 0 || right == 0) {
            cameras++;
            return 1;
        }

        // If any child has a camera,
        // current node is covered
        if (left == 1 || right == 1) {
            return 2;
        }

        // Both children are covered,
        // but current node is not covered
        return 0;
    }
}