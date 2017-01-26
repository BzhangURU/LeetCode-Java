public class T041_First_Missing_Positive {
	public int firstMissingPositive(int[] nums) {
		
		if(nums.length==0)
			return 1;
        for(int i=1;i<=nums.length;i++){
        	
        	if(nums[i-1]!=i){
        		
        		if(nums[i-1]<=0||nums[i-1]>nums.length)
        			continue;
        		int save=nums[i-1];
        		nums[i-1]=-1;
        		
        		int save_new;
        		
        		while(nums[save-1]!=save){
    				save_new=nums[save-1];
    				nums[save-1]=save;
    				save=save_new;
    				if(save<=0||save>nums.length)
    					break;
        		}
        		
        	}
        	
        	
        }
        for(int i=1;i<=nums.length;i++){
        	if(nums[i-1]!=i){
        		return i;
        	}
        }
        return nums.length+1;
    }
	public static void main(String[] args) {
		T041_First_Missing_Positive ex=new T041_First_Missing_Positive();
		System.out.println(ex.firstMissingPositive(new int[]{3,4,-1,1}));
	}

}
