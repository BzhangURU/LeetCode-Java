/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
        	return null;
		HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
        
		
		//RandomListNode head_copy=new RandomListNode(head.label);
		RandomListNode original_node=head;
		while(original_node!=null){
			RandomListNode copy_node=new RandomListNode(original_node.label);
			map.put(original_node, copy_node);
			original_node=original_node.next;
		}
		original_node=head;
		while(original_node!=null){
			map.get(original_node).next=map.get(original_node.next);
			map.get(original_node).random=map.get(original_node.random);
			original_node=original_node.next;
		}
		return map.get(head);
    }
}
