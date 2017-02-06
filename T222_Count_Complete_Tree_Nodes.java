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
    public int countNodes(TreeNode root) {
        if(root==null)
			return 0;
		if(root.left==null)
			return 1;
		if(root.right==null)
			return 2;
		if(root.left.left==null)
			return 3;
		
		//first get depth
		
		int depth=0;
		
		TreeNode node=root;
		while(node.left!=null){
			node=node.left;
			depth++;
		}
	
		
		int max=1<<depth;
		int min_bound=0;
		int max_bound=max-1;
		node=root;
		
		while(true){
			
			if(max_bound==min_bound){
				int number_of_nodes_in_bottom_layer=(min_bound+1);
				return (1<<depth)-1+number_of_nodes_in_bottom_layer; 
				
			}
			int middle;
			if((min_bound+max_bound)%2==0)
			  middle=(min_bound+max_bound)/2;
			else middle=(min_bound+max_bound+1)/2;
			
			
			node=root;
			
			for(int i=1;i<depth;i++){
				
				if(((middle<<i)&max)==0)
					node=node.left;
				else node=node.right;
				
			}
			if(((middle<<depth)&max)==0){
				if(node.left==null)
					max_bound=middle-1;
				else min_bound=middle;
			}
			else{
				if(node.right==null)
					max_bound=middle-1;
				else min_bound=middle;
			}
			
			
		}
    }
}
