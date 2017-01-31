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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
			return true;
        return isValidBST_range(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
	
	
	public boolean isValidBST_range(TreeNode root,int smallest,int largest) {
	    //System.out.println("value= "+root.val+" small= "+smallest+" large= "+largest);
		if(root.val>largest||root.val<smallest)
			return false;
		if((root.val==Integer.MIN_VALUE&&root.left!=null)||(root.val==Integer.MAX_VALUE&&root.right!=null))
			return false;
        if(root.left==null&&root.right==null){
        	if(root.val>=smallest&&root.val<=largest)
        		return true;
        	else return false;
        }else if(root.left==null){
        	if(isValidBST_range(root.right,Math.max(smallest,root.val+1),largest))
        		return true;
        	else return false;
        }else if(root.right==null){
        	if(isValidBST_range(root.left,smallest,Math.min(largest, root.val-1)))
        		return true;
        	else return false;
        }else {
        	if(isValidBST_range(root.left,smallest,Math.min(largest, root.val-1))&&
        			isValidBST_range(root.right,Math.max(smallest,root.val+1),largest))
        		return true;
        	else return false;
        }
    }
}
