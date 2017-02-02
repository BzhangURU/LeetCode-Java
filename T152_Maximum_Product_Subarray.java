public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)
        	return Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        int last0Index_plus1=0;
        
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==0){
        		max=Math.max(max, maxProduct_without0(nums,last0Index_plus1,i));
        		last0Index_plus1=i+1;
        		if(max<0)
        			max=0;
        	}
        	
        }
        max=Math.max(max, maxProduct_without0(nums,last0Index_plus1,nums.length));
        return max;
		
    }
	
	//include left, exclude right
	public int maxProduct_without0(int[] nums,int left,int right) {
		//if total product from left to right is positive, then it is
		//else      P1 P2 N1 P3....  P4 N2 P5 P6 P7, use N1(negative 1) or N2 to divide them
		//compare P1 P2 N1 P3....  P4, P3....  P4 N2 P5 P6 P7
		
		if(left>=right)
			return Integer.MIN_VALUE;
		if(left+1==right)
			return nums[left];
		int first_negative_index=-1;
		int last_negative_index=-1;
		boolean find_first=false;
		int product=1;
		
		for(int i=left;i<right;i++){
			if(nums[i]<0){
				if(!find_first){
					first_negative_index=i;
					find_first=true;
				}
				last_negative_index=i;
			}
		}
		if(first_negative_index==-1){
			for(int i=left;i<right;i++)
				product*=nums[i];
			return product;
		}else{
			
			int compare1=1;
			int compare2=1;
			
			for(int i=left;i<right;i++){
				product*=nums[i];
				if(i<last_negative_index)
					compare1*=nums[i];
				if(i>first_negative_index)
					compare2*=nums[i];
				
			}
			
			
			if(product>0)
				return product;
			else return Math.max(compare1, compare2);
			
			
		}
		
	}
}
