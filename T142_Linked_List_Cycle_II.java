
//my solution
	//assume the distance from head to the node begin cycle is a,
	//the perimeter of cycle is c
	//x is the traveling distance of slow pointer
	//2x=a+(m+d)c     0<=d<1    m,n is integer
	//x=a+(n+d)c       x=(m-n)c is multiple of c, so   x=(dc+a)%c=0, so one point start from the collision point   
	//another point start from head, then the next collision point would be where the cycle begins


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)
			return null;
		ListNode point_slow=head;
		ListNode point_fast=head;
		
		if(point_slow.next!=null)
			point_slow=point_slow.next;
		else return null;
		if(point_fast.next!=null&&point_fast.next.next!=null)
			point_fast=point_fast.next.next;
		else return null;
		
		while(point_slow!=point_fast){
			if(point_slow.next!=null)
				point_slow=point_slow.next;
			else return null;
			if(point_fast.next!=null&&point_fast.next.next!=null)
				point_fast=point_fast.next.next;
			else return null;
		}
		
		
		ListNode point_restart=head;
		while(point_restart!=point_slow){
			point_restart=point_restart.next;
			point_slow=point_slow.next;
		}
		return point_restart;
    }
}
