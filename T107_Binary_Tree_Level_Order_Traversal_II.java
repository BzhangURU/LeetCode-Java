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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //List<Integer> list=new LinkedList<Integer>();
        List<List<Integer>> LofL=new LinkedList<List<Integer>>();
        if(root==null)
        	return LofL;
        build_traversal(root, 1,LofL);
        List<List<Integer>> LofL_rev=new LinkedList<List<Integer>>();
        for(int i=LofL.size()-1;i>=0;i--){
        	LofL_rev.add(LofL.get(i));
        }
        return LofL_rev;
    }
	
	public void build_traversal(TreeNode root, int level, List<List<Integer>> LofL){
		if(LofL.size()<level){
			List<Integer> list=new LinkedList<Integer>();
			list.add(root.val);
			LofL.add(list);
		}else{
			LofL.get(level-1).add(root.val);
		}
		
		if(root.left!=null)
			build_traversal(root.left, level+1,LofL);
		if(root.right!=null)
			build_traversal(root.right, level+1,LofL);
	}
}
