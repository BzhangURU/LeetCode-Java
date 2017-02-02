/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        ListNode node=head;
        while(node!=null){
        	list.add(node.val);
        	node=node.next;
        }
        //list.sort;
        Collections.sort(list);
        node=head;
        int i=0;
        while(node!=null){
        	node.val=list.get(i);
        	node=node.next;
        	i++;
        }
        return head;
    }
}
