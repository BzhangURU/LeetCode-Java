/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
    	
        StringBuilder builder=new StringBuilder();
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		
    		root=queue.poll();
    		if(root!=null){
    			builder.append(Integer.toString(root.val)+" ");
    			queue.offer(root.left);
        		queue.offer(root.right);
    		}
    		else builder.append("null ");
    		
    	}
    	
    	return builder.toString();
    	
    	
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings=data.split(" ");
        if(strings[0].equals("null"))
        	return null;
        TreeNode root=new TreeNode(Integer.parseInt(strings[0]));
        TreeNode node=root;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(node);
        int i=1;
        while(i<strings.length){
        	node=queue.poll();
        	if(strings[i].equals("null")){
        		node.left=null;
        	}else{
        		TreeNode left=new TreeNode(Integer.parseInt(strings[i]));
        		queue.offer(left);
        		node.left=left;
        	}
        	i++;
        	if(strings[i].equals("null")){
        		node.right=null;
        	}else{
        		TreeNode right=new TreeNode(Integer.parseInt(strings[i]));
        		queue.offer(right);
        		node.right=right;
        	}
        	i++;
        }
        return root;
        
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
