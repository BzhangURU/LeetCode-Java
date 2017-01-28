/* Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?*/
//one pass using constant space
public class Solution {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length<=1)
			return;
        int left=0;
        int right=nums.length-1;
        while(left<nums.length&&nums[left]==0)
        	left++;
        while(right>=0&&nums[right]==2)
        	right--;
        if(left>=right)
        	return;
        
        int point=left;
        int value;
        while(point<=right&&point<nums.length){
        	if(nums[point]==0){
        		nums[point]=nums[left];
        		nums[left]=0;
        		while(left<nums.length&&nums[left]==0)
                	left++;
        		while(right>=0&&nums[right]==2)
                	right--;
                	if(left>point)
        			point=left;
        	}else if(nums[point]==2){
        		nums[point]=nums[right];
        		nums[right]=2;
        		while(left<nums.length&&nums[left]==0)
                	left++;
        		while(right>=0&&nums[right]==2)
                	right--;
                	if(left>point)
        			point=left;
        	}else point++;
        	
        	if(left>right)
        		break;
        	
        	
        }
    }
}
