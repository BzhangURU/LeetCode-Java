public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new LinkedList<String>();
		if(nums==null||nums.length==0)
			return list;
		if(nums.length==1){
			list.add(Integer.toString(nums[0]));
			return list;
		}
		
		int start=nums[0];
		int previous=nums[0];
		
		
		for(int i=1;i<nums.length;i++){
			
			if(i==nums.length-1){
				if(previous+1==nums[i]){
						list.add(String.valueOf(start)+"->"+String.valueOf(nums[i]));
					}else{
						if(start<previous)
							list.add(String.valueOf(start)+"->"+String.valueOf(previous));
						else list.add(String.valueOf(start));
						list.add(String.valueOf(nums[i]));
				}
				
			}else{
				if(nums[i]==previous+1){
					previous+=1;
				}else{
					if(start<previous)
						list.add(String.valueOf(start)+"->"+String.valueOf(previous));
					else list.add(String.valueOf(start));
					start=nums[i];
					previous=nums[i];
					
				}
				
			}
			
		}
		
		
		return list;
    }
}
