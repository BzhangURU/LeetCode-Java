public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result=new LinkedList<Integer>();
		if(n<0)
			return result;
		int bound=1<<n;
		for(int i=0;i<bound;i++){
			result.add(i^(i>>1));
		}
		return result;
    }
	

}
