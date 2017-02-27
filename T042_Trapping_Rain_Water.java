public class Solution {
    public int trap(int[] height) {
        if(height.length==0)
        	return 0;
		int max_height=0,max_index=0;
		for(int i=0;i<height.length;i++){
			if(height[i]>max_height){
				max_height=height[i];
				max_index=i;
			}
		}
		int h=height[0];
		int sum=0;
		for(int left=0;left<max_index;left++){
			if(height[left]<=h)
				sum+=h-height[left];
			else h=height[left];
		}
		h=height[height.length-1];
		for(int right=height.length-1;right>max_index;right--){
			if(height[right]<=h)
				sum+=h-height[right];
			else h=height[right];
		}
		return sum;
    }
}
