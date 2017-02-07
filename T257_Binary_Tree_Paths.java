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
    public List<String> binaryTreePaths(TreeNode root) {
		List<String> list=new LinkedList<String>();
		
		if(root==null)
			return list;
		buildpath(root,list,"");
		return list;
		
    }
	
	public void buildpath(TreeNode node, List<String> list, String str){
		if(str.isEmpty())
			str+=Integer.toString(node.val);
		else str+="->"+Integer.toString(node.val);
		
		if(node.left==null&&node.right==null){
			list.add(str);
		}else{ 
			if(node.left!=null){
				buildpath(node.left,list,str);
			}
			
			if(node.right!=null){
				buildpath(node.right,list,str);
			}
		}
			
		
		
		
	}
}
