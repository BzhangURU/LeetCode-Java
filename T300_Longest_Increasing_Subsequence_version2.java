public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)
			return 0;
		int[] B=new int[nums.length];
		B[0]=nums[nums.length-1];
		int B_length_available=1;
		int left,right;
		
		for(int i=nums.length-1;i>=0;i--){
			if(nums[i]>=B[0]){
				B[0]=nums[i];
			}
			else{
				left=0;
				right=B_length_available-1;
				int middle;
				//find largest index, such that B[index]>nums[i]
				while(left!=right){
					middle=(left+right+1)/2;
					if(B[middle]>nums[i])
						left=middle;
					else right=middle-1;
				}
				if(B_length_available<left+2){
					B_length_available=left+2;
					B[left+1]=nums[i];
				}else{
					if(nums[i]>B[left+1])
						B[left+1]=nums[i];
				}
				
			}
			
		}
		return B_length_available;
    }
}
