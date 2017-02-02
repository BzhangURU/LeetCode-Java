/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
			return;
		
		Stack<ListNode> stack=new Stack<ListNode>();
		ListNode node=head;
		while(node!=null){
			stack.push(node);
			node=node.next;
		}
		node=head;
		
		while(true){
			
			ListNode node_rear=stack.pop();
			
			if(node.next==node_rear||node==node_rear){
				node_rear.next=null;
				break;
			}
			
			node_rear.next=node.next;
			node.next=node_rear;
			
			node=node_rear.next;
			
		}
    }
}
