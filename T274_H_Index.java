public class Solution {
    public int hIndex(int[] citations) {
        int num=citations.length+1;
        int[] count=new int[num];
        
        
        for(int i=0;i<citations.length;i++){
        	if(citations[i]>=citations.length)
        		count[citations.length]++;
        	else count[citations[i]]++;
        
        }
        
        int h=0;
        int sum=0;
        for(int i=count.length-1;i>=0;i--){
        	sum+=count[i];
        	int min=Math.min(sum, i);
        	if(min>h)
        		h=min;
        	if(i<=min)
        		break;
        }
        
        return h;
    }
}
