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
    public TreeNode sortedArrayToBST(int[] nums) {
        return build_BST(nums,0,nums.length-1);
    }
	
	public TreeNode build_BST(int[] nums,int left_index,int right_index){
		
		if(left_index>right_index)
			return null;
		else if(left_index==right_index)
			return new TreeNode(nums[left_index]);
		else{
			int middle=(left_index+right_index)/2;
			TreeNode root=new TreeNode(nums[middle]);
			root.left=build_BST(nums,left_index,middle-1);
			root.right=build_BST(nums,middle+1,right_index);
			return root;
		}
		
		
		
	}
}
