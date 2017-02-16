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
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root==null)
        	return 0;
        int count=0;
        if(root.left!=null)
        	count+=count_left(root.left);
        if(root.right!=null)
        	count+=count_right(root.right);
        return count;
    }
	public int count_left(TreeNode leftnode){
		if(leftnode.left==null&&leftnode.right==null)
			return leftnode.val;
		else if(leftnode.left==null)
			return count_right(leftnode.right);
		else if(leftnode.right==null)
			return count_left(leftnode.left);
		else return count_left(leftnode.left)+count_right(leftnode.right);
	}
	public int count_right(TreeNode rightnode){
		if(rightnode.left==null&&rightnode.right==null)
			return 0;
		else if(rightnode.left==null)
			return count_right(rightnode.right);
		else if(rightnode.right==null)
			return count_left(rightnode.left);
		else return count_left(rightnode.left)+count_right(rightnode.right);
	}
    
}
