public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
		List<String> result=new LinkedList<String>();
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		for(int i=0;i<s.length()-9;i++){
			String str=s.substring(i,i+10);
			if(map.containsKey(str)){
				int num=map.get(str);
				if(num==1)
					result.add(str);
				map.replace(str, num+1);
				
			}
			else map.put(str,1);
			
		}
		return result;
    }
}
