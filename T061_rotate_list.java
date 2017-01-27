/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
        	return head;
        
        
        
		ListNode point_end=head;
		int length=0;
		while(point_end!=null){
			point_end=point_end.next;
			length++;
		}
		
		k=k%length;
		
		point_end=head;
		for(int i=0;i<k;i++)
			point_end=point_end.next;
		ListNode point_break=head;
		while(point_end.next!=null){
			point_end=point_end.next;
			point_break=point_break.next;
		}
		
		point_end.next=head;
		ListNode point_return=point_break.next;
		point_break.next=null;
		return point_return;
    }
}
