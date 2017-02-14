public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=new HashSet<Integer>();
        //HashSet<Integer> set2=new HashSet<Integer>();
        HashSet<Integer> set_result=new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
        	if(!set1.contains(nums1[i]))
        		set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
        	if(set1.contains(nums2[i])&&!set_result.contains(nums2[i]))
        		set_result.add(nums2[i]);
        }
        int length=set_result.size();
        int[] results=new int[length];
        int count=0;
        for(int element:set_result){
        	results[count]=element;
        	count++;
        }
        return results;
    }
}
