public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length<2)
        	return new int[2];
        int[] two=new int[2];
        int left=0;
        int right=numbers.length-1;
        while(numbers[left]+numbers[right]!=target){
        	
        	if(numbers[left]+numbers[right]<target){
        		left++;
        		if(left>=right){
        			return two;
        		}	
        	}else{
        		right--;
        		if(left>=right){
        			return two;
        		}
        	}
        }
        two[0]=left+1;
		two[1]=right+1;
        return two;
    }
}
