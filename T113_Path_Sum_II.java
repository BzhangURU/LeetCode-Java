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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> LofL=new LinkedList<List<Integer>>();
		List<Integer> List =new LinkedList<Integer>();
		get_PathSum(root,sum,LofL,List);
		return LofL;
    }
	
	public void get_PathSum(TreeNode root, int sum,List<List<Integer>> LofL, List<Integer> List) {
		
        if(root==null)
        	return;
        if(root.left==null&&root.right==null)
        	if(root.val==sum){
        		List.add(root.val);
        		LofL.add(new LinkedList<Integer>(List));
        		List.remove(List.size()-1);
        	}
        	else return;
        else if(root.left==null){
        	
        	List.add(root.val);
        	get_PathSum(root.right,sum-root.val,LofL,List);
        	List.remove(List.size()-1);
        }
        else if(root.right==null){
        	
        	List.add(root.val);
        	get_PathSum(root.left,sum-root.val,LofL,List);
        	List.remove(List.size()-1);
        }
        else{ 
        	List.add(root.val);
        	get_PathSum(root.left,sum-root.val,LofL,List);
        	get_PathSum(root.right,sum-root.val,LofL,List);
        	List.remove(List.size()-1);
        }
        
    }
}
