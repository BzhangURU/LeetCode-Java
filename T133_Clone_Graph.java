/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
        	return null;
        //nodes that were visited
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        return clone(node,map);
        
        
    }
	
	public UndirectedGraphNode clone(UndirectedGraphNode node,HashMap<UndirectedGraphNode,UndirectedGraphNode> map){
		if(node==null)
        	return null;
		
		if(map.containsKey(node))
			return map.get(node);
		
		UndirectedGraphNode clone=new UndirectedGraphNode(node.label);
		map.put(node, clone);
		for(UndirectedGraphNode neighbor: node.neighbors){
			clone.neighbors.add(clone(neighbor,map));
		}
		
		return clone;
		
	}
}
