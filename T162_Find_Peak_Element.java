public class Solution {
    public int findPeakElement(int[] nums) {
        return findPeak_in_range(nums,0,nums.length-1);
    }
	
	public int findPeak_in_range(int[] nums,int left,int right) {
        if(left<0||right>=nums.length||left>right)
        	return -1;
        if(left+3>=right){
        	int index=left;
        	int value=nums[left];
        	for(int i=left+1;i<=right;i++)
        		if(nums[i]>value){
        			index=i;
        			value=nums[i];
        		}
        	
        	return index;
        }
        int middle=left+(right-left)/2;
        
        if(nums[middle]>nums[middle+1])
        	return findPeak_in_range(nums,left,middle);
        else return findPeak_in_range(nums,middle+1,right);
        
        
        
    }
}
