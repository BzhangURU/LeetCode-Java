/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator{
		Stack<TreeNode> stack;
		TreeNode node;
		public BSTIterator(TreeNode root) {
	        
			this.stack=new Stack<TreeNode>();
			this.node=root;
			
			TreeNode virtual=new TreeNode(0);
			
			if(node!=null){
				while(node.left!=null){
					stack.push(node);
					node=node.left;
				}
			}
			
			virtual.right=node;
			node=virtual;
	    }
	
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        if(node.right==null&&stack.isEmpty())
	        	return false;
	        else return true;
	    	
	    	
	    }
	
	    /** @return the next smallest number */
	    public int next() {
	        
	    	if(node.right!=null){
	    		node=node.right;
	    		while(node.left!=null){
	    			stack.push(node);
					node=node.left;
	    		}
	    		
	    		return node.val;
	    		
	    	}else{
	    		node=stack.pop();
	    		return node.val;
	    	}
	    	
	    }
		
	}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
