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
    public void flatten(TreeNode root) {
        if(root==null)
        	return;
        flatten_helper(root);
        
    }
	//this function returns the end node of flattened tree
	public TreeNode flatten_helper(TreeNode root) {
        if(root==null)
        	return null;
        if(root.left==null&&root.right==null)
        	return root;
        else if(root.right==null){
        	root.right=root.left;
        	root.left=null;
        	return flatten_helper(root.right);
        }else if(root.left==null)
        	return flatten_helper(root.right);
        else{
        	TreeNode node_right=root.right;
        	TreeNode node_left_end=flatten_helper(root.left);
        	TreeNode node_right_end=flatten_helper(root.right);
        	root.right=root.left;
        	root.left=null;
        	node_left_end.right=node_right;
        	return node_right_end;
        }
        	
        
        
        
        
        
    }
}
