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
    public int maxPathSum(TreeNode root) {
		if(root==null)
			return 0;
		HashMap<TreeNode,Integer> node_max=new HashMap<TreeNode,Integer>();
		int[] max=new int[1];
		max[0]=Integer.MIN_VALUE;
		traverse_build_map(root,node_max,max);
		return max[0];
    }
	public void traverse_build_map(TreeNode node,HashMap<TreeNode,Integer> node_max,int[] max){
		
		if(node.left==null&&node.right==null){
			node_max.put(node, node.val);
			if(node.val>max[0])
				max[0]=node.val;
		}else {
			
			if(node.left==null){
				traverse_build_map(node.right,node_max,max);
				int value=node.val+Math.max(0, node_max.get(node.right));
				node_max.put(node, value);
				if(value>max[0])
					max[0]=value;
				
			}else if(node.right==null){
				traverse_build_map(node.left,node_max,max);
				int value=node.val+Math.max(0, node_max.get(node.left));
				node_max.put(node, value);
				
				if(value>max[0])
					max[0]=value;
				
			}else{
				traverse_build_map(node.left,node_max,max);
				traverse_build_map(node.right,node_max,max);
				
				
				int value_l=Math.max(0, node_max.get(node.left));
				int value_r=node_max.get(node.right);
				int value_path=node.val+value_l+Math.max(0,value_r);
				int value=node.val+Math.max(value_l,value_r);
				node_max.put(node, value);
				if(value_path>max[0])
					max[0]=value_path;
			}
			
			
			
		}
		
		
	}
}
