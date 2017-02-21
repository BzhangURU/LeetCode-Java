/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(new mycomparator());
        
        ListNode start=new ListNode(0);
        ListNode node=start;
        for(int i=0;i<lists.length;i++){
        	if(lists[i]!=null)
        		queue.offer(lists[i]);
        }
        
        while(!queue.isEmpty()){
        	ListNode node2=queue.poll();
        	if(node2.next!=null)
        		queue.offer(node2.next);
        	node.next=node2;
        	node=node2;
        }
        return start.next;
        
        
        
        
    }
	
	
	private class mycomparator implements Comparator<ListNode>{
		public int compare(ListNode a,ListNode b){
			return a.val-b.val;
		}
	}
}
