/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        //convert List to array
		if(head==null)
			return null;
		
		int length=0;
		ListNode node=head;
		while(node!=null){
			node=node.next;
			length++;
		}
		node=head;
		int[] nums=new int[length];
		for(int i=0;i<length;i++){
			nums[i]=node.val;
			node=node.next;
		}
		
		return build_BST(nums,0,length-1);
		
		
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
