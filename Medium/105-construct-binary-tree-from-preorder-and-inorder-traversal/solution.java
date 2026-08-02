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

    int preindex = 0 ;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder,inorder,0,inorder.length-1);


    }

    public TreeNode build(int[] preorder , int[] inorder ,int inlow , int inhigh ){

        if(inlow>inhigh){
            return  null;
        }

        int rootval = preorder[preindex];
        preindex++;
        TreeNode root = new TreeNode(rootval);

        int index = -1;

        for(int i = inlow ; i<= inhigh ; i++){
            if(inorder[i]==rootval){
                index=i;
                break;
            }
        }

        root.left = build(preorder,inorder,inlow,index-1);

        root.right = build(preorder,inorder,index+1,inhigh);

        return root;

    }
}
