/* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3. */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
			return head;
		int number;
		//first have new head that should be returned
		while(head.next.val==head.val){
			number=head.val;
			
			while(head.val==number){
				head=head.next;
				if(head==null)
					return null;
			}
			
			if(head.next==null)
				return head;
		}
		
		
		
		ListNode node1=head;
        ListNode node2=head.next;
        
        
        while(node2!=null){
        	
        	while(node2.next!=null&&node2.next.val==node2.val){
    			number=node2.val;
    			
    			while(node2.val==number){
    				node2=node2.next;
    				if(node2==null){
    					node1.next=null;
    					return head;
    				}
    			}
    			
    		}
        	
        	node1.next=node2;
        	node1=node2;
        	node2=node2.next;
        	
        }
        	
        node1.next=null;
        return head;
    }
}
