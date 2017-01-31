/*Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<Integer> List=new LinkedList<Integer>();
        TreeNode node=root;
        while(!stack.isEmpty()||node!=null){
        	if(node!=null){
        		stack.push(node);
        		node=node.left;
        	}else{
        		node=stack.pop();
        		List.add(node.val);
        		node=node.right;
        	}
        }
        return List;
    }
}
