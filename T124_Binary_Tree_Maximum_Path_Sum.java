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
		//max_start_from_this, can only go down
		int[] max=new int[1];
		max[0]=Integer.MIN_VALUE;
		traverse_build_map(root,max);
		return max[0];
    }
	
	public int traverse_build_map(TreeNode node,int[] max){
		
		if(node.left==null&&node.right==null){
			if(node.val>max[0])
				max[0]=node.val;
			return node.val;
		}else {
			
			if(node.left==null){
				int value=node.val+Math.max(0, traverse_build_map(node.right,max));
				if(value>max[0])
					max[0]=value;
				return value;
			}else if(node.right==null){
				int value=node.val+Math.max(0, traverse_build_map(node.left,max));
				if(value>max[0])
					max[0]=value;
				return value;
				
			}else{
				int value_l=traverse_build_map(node.left,max);
				int value_r=traverse_build_map(node.right,max);
				/*int value_path=node.val+Math.max(0, node_max.get(node.left))+
						Math.max(0,node_max.get(node.right));*/
				int value_path=node.val+Math.max(0,value_l)+Math.max(0,value_r);
				int value=node.val+Math.max(0,Math.max(value_l,value_r));
				if(value_path>max[0])
					max[0]=value_path;
				return value;
			}
			
			
			
		}
		
		
	}
}
