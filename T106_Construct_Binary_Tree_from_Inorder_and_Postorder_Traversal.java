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
    //my solution
		HashMap<Integer,Integer> index_inorder=new HashMap<Integer,Integer>();
		
		public TreeNode buildTree(int[] postorder,int post_start,int post_end, int in_start,int in_end) {
			if(post_start>post_end)
				return null;
			TreeNode root=new TreeNode(postorder[post_end]);
			int index=index_inorder.get(postorder[post_end]);
			root.left=buildTree(postorder,post_start,post_start+index-in_start-1,in_start,index-1);
			root.right=buildTree(postorder,post_start+index-in_start,post_end-1,index+1,in_end);
			return root;
		}
		
		
		
		
		public TreeNode buildTree(int[] inorder, int[] postorder) {
	        
			if(postorder.length!=inorder.length)
				return null;
			for(int i=0;i<inorder.length;i++){
				index_inorder.put(inorder[i], i);
			}
			
			return buildTree(postorder,0,postorder.length-1,0,inorder.length-1);
			
			
			
	    }
}
