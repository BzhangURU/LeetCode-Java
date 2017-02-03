public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null||nums.length==1)
			return null;
        int[] multiply_from_end=new int[nums.length];
        
        multiply_from_end[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
        	multiply_from_end[i]=multiply_from_end[i+1]*nums[i];
        	
        }
		
		int multiply_from_begin=1;
		int[] results=new int[nums.length];
		
		for(int i=0;i<nums.length;i++){
			if(i==nums.length-1)
				results[i]=multiply_from_begin;
			else{
				results[i]=multiply_from_begin*multiply_from_end[i+1];
				
			}
			multiply_from_begin=multiply_from_begin*nums[i];
		}
		return results;
    }
}
