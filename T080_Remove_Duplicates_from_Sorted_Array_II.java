/* Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with 
the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length. */

public class Solution {
    public int removeDuplicates(int[] nums) {
        int point_duplicate=2;
		while(point_duplicate<nums.length){
			if(nums[point_duplicate]==nums[point_duplicate-2])
				break;
			else point_duplicate++;
		}
		if(point_duplicate>=nums.length)
			return nums.length;
		if(point_duplicate==nums.length-1)
			return nums.length-1;
		
		int number=nums[point_duplicate];
		int frequency=3;
		
		
		int point_search=point_duplicate+1;
		while(point_search<nums.length){
			if(nums[point_search]!=number){
				number=nums[point_search];
				frequency=1;
				nums[point_duplicate]=nums[point_search];
				point_duplicate++;
				
			}else{
				frequency++;
				if(frequency<=2){
					nums[point_duplicate]=nums[point_search];
					point_duplicate++;
				}
			}
			
			
			point_search++;
		}
		return point_duplicate;
    }
}
