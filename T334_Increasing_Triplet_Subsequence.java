public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int smallest=Integer.MAX_VALUE;
		int smallest_second=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]>smallest_second)
        		return true;
        	if(nums[i]>smallest&&nums[i]<smallest_second)
        		smallest_second=nums[i];
        	if(smallest>nums[i])
        		smallest=nums[i];
        }
        return false;
    }
}
