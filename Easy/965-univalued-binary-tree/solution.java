class Solution {

    Integer prev = null;
    boolean ans = true;

    public boolean isUnivalTree(TreeNode root) {

        inorder(root);
        return ans;
    }

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev == null) {
            prev = root.val;
        } else if (prev != root.val) {
            ans = false;
            return;
        }

        inorder(root.right);
    }
}
