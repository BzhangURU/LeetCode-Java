/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack=new Stack<NestedInteger>();
        for(int i=nestedList.size()-1;i>=0;i--){
        	stack.push(nestedList.get(i));
        }
        if(!stack.isEmpty()){
        	//guarantee there stack is either empty or integer is on the top
	        while(!stack.isEmpty()&&!stack.peek().isInteger()){
	        	
	        	List<NestedInteger> list=stack.pop().getList();
	        	for(int i=list.size()-1;i>=0;i--){
	        		stack.push(list.get(i));
	        	}
	    	}
        }
        
        
    }

    @Override
    public Integer next() {
        int answer= stack.pop().getInteger();
    	while(!stack.isEmpty()&&!stack.peek().isInteger()){
        	
        	List<NestedInteger> list=stack.pop().getList();
        	for(int i=list.size()-1;i>=0;i--){
        		stack.push(list.get(i));
        	}
    	}
    	return answer;
        
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
