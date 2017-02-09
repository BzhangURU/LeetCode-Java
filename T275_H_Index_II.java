public class Solution {
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0)
			return 0;
        int left=0,right=citations.length-1;
        int middle=0;
        int h=0;
        while(left+1<right){
        	middle=(left+right)/2;
        	if(citations[middle]>=citations.length-middle){
        		right=middle;
        	}else{
        		left=middle+1;
        	}
        	
        }
        int min=Math.min(citations.length-left, citations[left]);
        if(min>h)
        	h=min;
        min=Math.min(citations.length-right, citations[right]);
        if(min>h)
        	h=min;
        return h;
    }
}
