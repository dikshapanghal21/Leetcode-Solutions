class Solution {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {

        inorder(root);

        return min;
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // Left
        inorder(root.left);

        // Root
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }

        prev = root;

        // Right
        inorder(root.right);
    }
}