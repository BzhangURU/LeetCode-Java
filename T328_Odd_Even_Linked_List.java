/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)
        	return head;
        ListNode even_head=head.next;
        
        ListNode odd=head;
        ListNode even=head.next;
        
        
        while(odd.next.next!=null&&even.next.next!=null){
        	odd.next=odd.next.next;
        	odd=odd.next;
        	even.next=even.next.next;
        	even=even.next;
        }
        if(odd.next.next==null){
        	odd.next=even_head;
        	return head;
        }else{
            odd.next=odd.next.next;
        	odd=odd.next;
        	even.next=null;
        	odd.next=even_head;
        	return head;
        }
    }
}
