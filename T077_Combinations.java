/* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]*/
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
		
        List<List<Integer>> LofL=new LinkedList<List<Integer>>();
        if(n<1||n<k||k<=0)
        	return LofL;
        
        List<Integer> List=new LinkedList<Integer>();
        boolean available[]=new boolean[n];
        Arrays.fill(available, true);
        helper(LofL,List,available,k,0);
        return LofL;
        
    }
	
	public void helper(List<List<Integer>> LofL,List<Integer> List,boolean available[],int k,int start){
		if(k==0){
			List<Integer> List_copy=new LinkedList<Integer>();
			for(int i=0;i<List.size();i++)
				List_copy.add(List.get(i));
			LofL.add(List_copy);
		}
		else{
			
			for(int i=start;i<available.length;i++){
				if(available[i]==true){
					available[i]=false;
					List.add(i+1);
					helper(LofL,List,available,k-1,i+1);
					List.remove(List.size()-1);
					available[i]=true;
				}
			}
		}
		
	}
}
