public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)
			return 0;
		
		int[] LIS=new int[nums.length];
		for(int i=nums.length-1;i>=0;i--){
			
			LIS[i]=1;
			for(int j=nums.length-1;j>i;j--){
				if(nums[i]<nums[j])
					if(LIS[j]+1>LIS[i])
						LIS[i]=LIS[j]+1;
			}
			
		}
		int result=0;
		for(int i=0;i<nums.length;i++){
			if(result<LIS[i])
				result=LIS[i];
			if(result>nums.length-i+1)
				break;
		}
		
		return result;
    }
}
