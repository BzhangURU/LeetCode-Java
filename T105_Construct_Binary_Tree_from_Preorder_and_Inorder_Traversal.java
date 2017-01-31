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
    HashMap<Integer,Integer> index_inorder=new HashMap<Integer,Integer>();
	
	public TreeNode buildTree(int[] preorder, int[] inorder,int pre_start,int pre_end, int in_start,int in_end) {
		if(pre_start>pre_end)
			return null;
		TreeNode root=new TreeNode(preorder[pre_start]);
		//int index=find_index(inorder,in_start,in_end,preorder[pre_start]);
		int index=index_inorder.get(preorder[pre_start]);
		root.left=buildTree(preorder,inorder,pre_start+1,pre_start+index-in_start,in_start,index-1);
		root.right=buildTree(preorder,inorder,pre_start+index-in_start+1,pre_end,index+1,in_end);
		return root;
	}
	
	
	
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        
		if(preorder.length!=inorder.length)
			return null;
		for(int i=0;i<preorder.length;i++){
			index_inorder.put(inorder[i], i);
		}
		
		return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
		
		
		
    }
}
