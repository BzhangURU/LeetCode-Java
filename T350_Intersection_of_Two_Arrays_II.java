public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1=new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> map2=new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> map_result=new HashMap<Integer,Integer>();
        for(int i=0;i<nums1.length;i++){
        	if(!map1.containsKey(nums1[i]))
        		map1.put(nums1[i],1);
        	else map1.put(nums1[i], 1+map1.get(nums1[i]));
        }
        for(int i=0;i<nums2.length;i++){
        	if(!map2.containsKey(nums2[i]))
        		map2.put(nums2[i],1);
        	else map2.put(nums2[i], 1+map2.get(nums2[i]));
        }
        int count=0;
        for(int element:map2.keySet()){
        	if(map1.containsKey(element)){
        		int min=Math.min(map1.get(element), map2.get(element));
        		map_result.put(element, min);
        		count+=min;
        	}
        }
        
        int count_result=0;
        int[] results=new int[count];
        for(int element:map_result.keySet()){
        	for(int i=0;i<map_result.get(element);i++){
        		results[count_result]=element;
        		count_result++;
        	}
        }
        return results;
    }
}
