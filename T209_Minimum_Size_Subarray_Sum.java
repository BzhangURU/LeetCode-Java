public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)
			return 0;
        int left=0,right=0;
        int sum=nums[0];
        int minimal_length=Integer.MAX_VALUE;
        
        while(right<nums.length){
        	while(sum<s){
        		right++;
        		if(right>=nums.length)
            		break;
        		sum+=nums[right];
        	}
        	if(right>=nums.length)
        		break;
        	if(right-left+1<minimal_length)
        		minimal_length=right-left+1;
        		
        	while(sum>=s){
        		sum-=nums[left];
        		left++;
        		
        		
        		if(right-left+1<minimal_length&&sum>=s)
        			minimal_length=right-left+1;
        		if(left>right)
        			break;
        	}
        	
        }
        
        return minimal_length==Integer.MAX_VALUE?0:minimal_length;
    }
}
