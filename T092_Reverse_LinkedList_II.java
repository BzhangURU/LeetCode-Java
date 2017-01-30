/* Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m==n)
			return head;
		
        int count=1;
        int num_m=0;
        ListNode point_fake=new ListNode(0);
        point_fake.next=head;
        ListNode point_left=point_fake;
        ListNode point_right=head;
        ListNode point_before_m=point_fake;
        ListNode point_m=point_fake;
        
        ListNode point_next=point_fake;
        boolean between_mn=false;
        
        while(point_right!=null){
        	
        	if(between_mn){
        		if(count!=n){
	        		point_next=point_right.next;
	        		point_right.next=point_left;
	        		point_left=point_right;
	        		point_right=point_next;
	        		count++;
        		}else{
        			point_m.next=point_right.next;
        			point_right.next=point_left;
        			point_before_m.next=point_right;
        			return point_fake.next;
        		}
        	}else{
        		
        		if(count==m){
            		between_mn=true;
            		point_before_m=point_left;
            		point_m=point_right;
            		
            	}
        		point_left=point_right;
        		point_right=point_right.next;
        		count++;
        	}
        	
        }
        return point_fake.next;
    }
}
