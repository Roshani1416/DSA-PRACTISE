/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Stack<TreeNode> asc= new Stack<>();
    Stack<TreeNode> desc = new Stack<>();


    public boolean findTarget(TreeNode root, int k) {

        pushleft(root);
        pushright(root);

        TreeNode small= getnext();
        TreeNode big = getprev();

        while ( small!=null && big!=null && small!=big){

            int sum = small.val + big.val;

            if(sum==k){
                return true;

            }

            if(sum<k){
                small=getnext();
            }

            else{
                big=getprev();
            }
        }

        return false;

        
        
    }

    private void pushleft(TreeNode node){
        while(node!=null){
            asc.push(node);
            node=node.left;
        }
    }

    private void pushright(TreeNode node){
        while(node!=null){
            desc.push(node);
            node=node.right;
        }
    }

    private TreeNode getnext() {

        if (asc.isEmpty()) {
            return null;
        }

        TreeNode small = asc.pop();

        TreeNode rightChild = small.right;

        while (rightChild != null) {
            asc.push(rightChild);
            rightChild = rightChild.left;
        }

        return small;
    }

    // Next largest node
    private TreeNode getprev() {

        if (desc.isEmpty()) {
            return null;
        }

        TreeNode big = desc.pop();

        TreeNode leftChild = big.left;

        while (leftChild != null) {
            desc.push(leftChild);
            leftChild = leftChild.right;
        }

        return big;
    }
}
