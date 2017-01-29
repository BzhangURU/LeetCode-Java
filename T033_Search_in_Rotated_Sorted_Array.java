/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.*/

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)
			return -1;
		
        //first get index of largest number
		//index must between left and right(including left and right)
		int left=0;
		int right=nums.length-1;
		
		int middle;
		while(left+1<right){
			middle=(left+right)/2;
			if(nums[middle]>nums[0]){
				left=middle;
			}else if(nums[middle]<nums[0]){
				right=middle-1;
			}
			
		}
		int index_last=left;
		if(nums[right]>=nums[left])
			index_last=right;
		
		
		//find target in first and second part seperately
		int left1=0;
		int right1=index_last;
		
		if(nums[left1]==target)
			return left1;
		if(nums[right1]==target)
			return right1;
		
		if(nums[left1]<target&&target<nums[right1]){
			while(left1+1<right1){
				middle=(left1+right1)/2;
				if(nums[middle]>target){
					right1=middle;
				}else if(nums[middle]<target){
					left1=middle;
				}else return middle;
				
				
				
			}
		}
		
		if(index_last>=nums.length-1)
			return -1;
		
		
		int left2=index_last+1;
		int right2=nums.length-1;
		if(nums[left2]==target)
			return left2;
		if(nums[right2]==target)
			return right2;
		
		
		if(nums[left2]<target&&target<nums[right2]){
			while(left2+1<right2){
				middle=(left2+right2)/2;
				if(nums[middle]>target){
					right2=middle;
				}else if(nums[middle]<target){
					left2=middle;
				}else return middle;
				
				
				
			}
		}
		return -1;
    }
}
