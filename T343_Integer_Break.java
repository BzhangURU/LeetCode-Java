public class Solution {
    public int integerBreak(int n) {
        if(n<4){
			if(n==2)
				return 1;
			else return 2;
		}
        int num_3=n/3;
        int remain=n%3;
        int result=1;
        if(remain==2||remain==0){
        	
        	for(int i=0;i<num_3;i++)
        		result*=3;
        	result*=(remain==2)?2:1;
        }else{
        	for(int i=0;i<num_3-1;i++)
        		result*=3;
        	result*=4;
        }
        return result;
    }
}
