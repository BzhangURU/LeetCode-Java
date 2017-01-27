public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<=1)
			return true;
        int farest=0;
        int current;
        for(int i=0;i<nums.length;i++){
        	current=i+nums[i];
        	if(current>farest)
        		farest=current;
        	if(farest==i){
        		if(farest!=nums.length-1)
        			return false;
        		else return true;
        	}
        	
        }
        return true;
    }
}
