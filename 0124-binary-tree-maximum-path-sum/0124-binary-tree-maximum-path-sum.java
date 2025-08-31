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
    public int maxPathSum(TreeNode root) {
        int[] maxValue=new int[1];
        maxValue[0]=Integer.MIN_VALUE;
        maxPathDown(root,maxValue);
        return maxValue[0];
    }
    public int maxPathDown(TreeNode node,int[] maxValue){
        if(node==null) return 0;
        int lhs=Math.max(0,maxPathDown(node.left,maxValue));
        int rhs=Math.max(0,maxPathDown(node.right,maxValue));
        maxValue[0]=Math.max(maxValue[0],node.val+lhs+rhs);
        return node.val+Math.max(lhs,rhs);
    }
}