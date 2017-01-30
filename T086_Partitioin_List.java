/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)
        	return head;
        //use queue to save values that is larger than or equals to x
		Queue<Integer> myqueue=new LinkedList<Integer>();
		//point_search points at the ListNode that is currently searched
		ListNode point_search=head;
		//point_put points at the ListNode that is the first one whose val >=x,the number that
		//is less than x should be put here
		ListNode point_put=head;
		while(point_put!=null&&point_put.val<x)
			point_put=point_put.next;
		if(point_put==null||point_put.next==null)
			return head;
		myqueue.offer(point_put.val);
		point_search=point_put.next;
		
		
		while(point_search!=null){
			if(point_search.val<x){
				point_put.val=point_search.val;
				point_put=point_put.next;
				point_search=point_search.next;
				
			}else{
				myqueue.offer(point_search.val);
				point_search=point_search.next;
			}
	
			
		}
		
		while(!myqueue.isEmpty()){
			point_put.val=myqueue.poll();
			point_put=point_put.next;
		}
		
		
		return head;
    }
}
