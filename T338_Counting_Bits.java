public class Solution {
    public int[] countBits(int num) {
        int[] result=new int[num+1];
        result[0]=0;
        if(num==0)
        	return result;
        result[1]=1;
        if(num==1)
        	return result;
        
        int bound=2;
        
        while((bound<<1)<num+1){
        	for(int i=0;i<bound;i++){
        		result[i+bound]=1+result[i];
        	}
        	bound=bound<<1;
        }
        for(int i=0;i+bound<=num;i++){
        	result[i+bound]=1+result[i];
        }
        return result;
    }
}
