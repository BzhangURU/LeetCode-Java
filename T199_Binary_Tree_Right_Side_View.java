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
    public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list =new ArrayList<Integer>();
		pre_order(root,0,list);
		return list;
		
		
    }
	public void pre_order(TreeNode node, int level,List<Integer> list){
		if(node==null)
			return;
		if(level>list.size()-1)
			list.add(node.val);
		else list.set(level, node.val);
		pre_order(node.left,level+1,list);
		pre_order(node.right,level+1,list);
		
		
	}
}
