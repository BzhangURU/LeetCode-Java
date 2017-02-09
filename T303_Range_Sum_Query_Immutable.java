public class NumArray {
    int total;
	  int[] prefix;
	
	
    public NumArray(int[] nums) {
        prefix=new int[nums.length];
        if(nums.length>0){
	        prefix[0]=nums[0];
			    for(int i=1;i<nums.length;i++){
				    prefix[i]=nums[i]+prefix[i-1];
			    }
        }
    }
    
    public int sumRange(int i, int j) {
    	if(i==0)
    		return prefix[j];
    	else return prefix[j]-prefix[i-1];
    }
}
