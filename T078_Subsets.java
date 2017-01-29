/* Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> LofL=new LinkedList<List<Integer>>();
		List<Integer> List=new LinkedList<Integer>();
		helper(LofL,List,nums,0);
		return LofL;
    }
	
	public void helper(List<List<Integer>> LofL, List<Integer> List,int[] nums,int start){
		if(start==nums.length){
			LofL.add(List);
		}
		else{
		
		
			List<Integer> List1=new LinkedList<Integer>();
			
			for(int i=0;i<List.size();i++)
				List1.add(List.get(i));
			helper(LofL,List1,nums,start+1);
			
			List<Integer> List2=new LinkedList<Integer>();
			for(int i=0;i<List.size();i++)
				List2.add(List.get(i));
			List2.add(nums[start]);
			helper(LofL,List2,nums,start+1);
		}
		
	}
}
