/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
        	return;
        if(root.left==null&&root.right==null)
        	return;
        connect_between_subtrees(root.left,root.right);
        connect(root.left);
        connect(root.right);
        
        
    }
	
	
	public void connect_between_subtrees(TreeLinkNode root_left,TreeLinkNode root_right){
		while(root_left!=null){
			root_left.next=root_right;
			root_left=root_left.right;
			root_right=root_right.left;
		}
	}
}
