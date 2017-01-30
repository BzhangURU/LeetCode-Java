/* Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> LofL=new LinkedList<List<Integer>>();
        int length=nums.length;
        if(length==0)
        	return LofL;
        List<Integer> List=new LinkedList<Integer>();
        
        Arrays.sort(nums);
        
        boolean used[]=new boolean[length];
        helper(LofL,List,0,length,used,nums);
        return LofL;
        
    }
	public void helper(List<List<Integer>> LofL,List<Integer> List, int index, int length,boolean[] used,int[] nums){
		if(index==length){
			List<Integer> List_add=new LinkedList<Integer>();
			for(int i=0;i<List.size();i++)
				List_add.add(List.get(i));
			LofL.add(List_add);
		}
		else{
			
			helper(LofL,List,index+1,length,used,nums);
			
			if(index==0||used[index-1]||(nums[index-1]!=nums[index])){
				used[index]=true;
				List.add(nums[index]);
				helper(LofL,List,index+1,length,used,nums);
				List.remove(List.size()-1);
				used[index]=false;
			}
		
		}
	}
}
