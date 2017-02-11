public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] result=new String[nums.length];
		if(nums.length==0)
			return result;
		HashMap<Integer,Integer> num2index=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			num2index.put(nums[i], i);
		}
		Arrays.sort(nums);
		if(nums.length>=1)
			result[num2index.get(nums[nums.length-1])]="Gold Medal";
		if(nums.length>=2)
			result[num2index.get(nums[nums.length-2])]="Silver Medal";
		if(nums.length>=3)
			result[num2index.get(nums[nums.length-3])]="Bronze Medal";
		for(int i=nums.length-4;i>=0;i--){
			result[num2index.get(nums[i])]=Integer.toString(nums.length-i);
		}
		return result;
    }
}
