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

    int postindex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       postindex = postorder.length - 1;

       return  build(inorder,postorder,0,inorder.length-1);
        
    }

    public TreeNode build(int[] inorder,int[] postorder , int inlow , int inhigh){

        if(inlow>inhigh){
            return null;
        }

        int rootval = postorder[postindex];
        postindex--;

        TreeNode root = new TreeNode(rootval);
        int index = -1;

        for(int i=inlow;i<=inhigh;i++){
            if(inorder[i]==rootval){
                index=i;
                break;
            }
        }
        

        root.right = build(inorder,postorder,index+1,inhigh);
        root.left=build(inorder,postorder,inlow,index-1);
        

        return root;




        

    }
}
