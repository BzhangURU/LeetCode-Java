/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /* Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3. */
 
 
 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
			return head;
        ListNode node1=head;
        ListNode node2=head;
        
        
        while(node2!=null){
        	if(node2.val==node1.val)
        		node2=node2.next;
        	else{
        		node1.next=node2;
        		node1=node2;
        	}
        }
        	
        node1.next=null;
        return head;
    }
}
