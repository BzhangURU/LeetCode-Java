public class Solution {
    public String largestNumber(int[] nums) {
        
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<nums.length;i++){
			list.add(Integer.toString(nums[i]));
		}
		
		Collections.sort(list,new mycomparator());
		StringBuilder builder=new StringBuilder();
		for(int i=list.size()-1;i>=0;i--)
			builder.append(list.get(i));
		String result=builder.toString();
		int index=0;
		for(int i=0;i<result.length();i++){
			if(i<result.length()-1&&result.charAt(i)=='0')
				index=i+1;
			else break;
		}
		return result.substring(index, result.length());
		
		
    }
	
	private class mycomparator implements Comparator<String>{
		public int compare(String a, String b){
			
			if(a.length()==b.length()){
				for(int i=0;i<a.length();i++){
					if(a.charAt(i)!=b.charAt(i))
						return (int)(a.charAt(i)-b.charAt(i));
					
				}
				return 0;
			}else{
				String a_new=a+b;
				String b_new=b+a;
				
				for(int i=0;i<a_new.length();i++){
					if(a_new.charAt(i)!=b_new.charAt(i))
						return (int)(a_new.charAt(i)-b_new.charAt(i));
					
				}
				return 0;
				
				
				
				
			}
			
		}
	}
}
