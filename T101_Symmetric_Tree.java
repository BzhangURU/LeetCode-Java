/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        	return true;
        else return two_parts_Symmetric(root.left,root.right);
    }
	
	public boolean two_parts_Symmetric(TreeNode root_left,TreeNode root_right) {
        if(root_left==null&&root_right==null)
        	return true;
        if(root_left==null||root_right==null)
        	return false;
        if(root_left.val!=root_right.val)
        	return false;
        else{
        	if(two_parts_Symmetric(root_left.right,root_right.left)&&
        			two_parts_Symmetric(root_left.left,root_right.right))
        		return true;
        	else return false;
        }
    }
}
