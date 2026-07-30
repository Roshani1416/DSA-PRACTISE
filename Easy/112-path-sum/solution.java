class Solution {

    boolean ans = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        fun(root, 0, targetSum);
        return ans;
    }

    public void fun(TreeNode root, int sum, int target) {

        if (root == null) {
            return;
        }

        sum = sum + root.val;

        if (root.left == null && root.right == null) {
            if (sum == target) {
                ans = true;
            }
            return;
        }

        fun(root.left, sum, target);
        fun(root.right, sum, target);
    }
}
