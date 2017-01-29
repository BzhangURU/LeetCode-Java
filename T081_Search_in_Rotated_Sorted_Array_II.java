/*    Follow up for "Search in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.*/

public class Solution {
    public boolean search(int[] nums, int target) {
		if(nums.length==0)
			return false;
		
        //first get index of largest number
		//index must be between left and right(including left and right)
		int left=0;
		int right=nums.length-1;
		
		int middle;
		while(left+1<right){
			middle=(left+right)/2;
			if(nums[middle]>nums[0]){
				left=middle;
			}else if(nums[middle]<nums[0]){
				right=middle-1;
			}else break;
		}

		
		int index_last=left;
		
		for(int k=left;k<=right;k++){
			if(nums[k]>=nums[index_last])
				index_last=k;
			else break;
		}

		//find target in first and second part seperately
		int left1=0;
		int right1=index_last;
		
		if(nums[left1]==target)
			return true;
		if(nums[right1]==target)
			return true;
		
		if(nums[left1]<target&&target<nums[right1]){
			while(left1+1<right1){
				middle=(left1+right1)/2;
				if(nums[middle]>target){
					right1=middle;
				}else if(nums[middle]<target){
					left1=middle;
				}else return true;
				
				
				
			}
		}
		
		if(index_last>=nums.length-1)
			return false;
		
		
		int left2=index_last+1;
		int right2=nums.length-1;
		if(nums[left2]==target)
			return true;
		if(nums[right2]==target)
			return true;
		
		
		if(nums[left2]<target&&target<nums[right2]){
			while(left2+1<right2){
				middle=(left2+right2)/2;
				if(nums[middle]>target){
					right2=middle;
				}else if(nums[middle]<target){
					left2=middle;
				}else return true;
				
				
				
			}
		}
		return false;
}
}
