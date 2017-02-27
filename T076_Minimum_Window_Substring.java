public class Solution {
    public String minWindow(String s, String t) {
        String result=new String();
		if(t.length()==0)
			return result;
		int contain[]=new int[256];
		List<Integer> l_pos=new ArrayList<Integer>();//positions of containing letters
		int l_pos_ind=0;
		int frequency[]=new int[256];
		int count_type=0;
		for(int i=0;i<t.length();i++){
			
			contain[(int)t.charAt(i)]++;
			count_type++;
			
		}
		
		if(t.length()==1){
			if(s.indexOf(t.charAt(0))>=0)
				return result+t.charAt(0);
			else return result;
		}
		
		
		
		int temp_start=0;
		
		int min_length=Integer.MAX_VALUE;
		for(int i=0;i<s.length();i++){
			if(contain[(int)s.charAt(i)]>0){
				temp_start=i;
				break;
			}
		}
		int min_start=temp_start;
		for(int i=temp_start;i<s.length();i++){
			if(contain[(int)s.charAt(i)]>0){
				l_pos.add(i);
				
				if(frequency[(int)s.charAt(i)]<contain[(int)s.charAt(i)])
					count_type--;
				frequency[(int)s.charAt(i)]++;
				
			}
			
			//have found all the letters
			if(count_type==0){
				
				
				// in case of aaa, shrink to a
				while(true){
					
					if(frequency[(int)s.charAt(l_pos.get(l_pos_ind))]<=contain[(int)s.charAt(l_pos.get(l_pos_ind))]){
						min_start=l_pos.get(l_pos_ind);
						break;
					}
					else {
						frequency[(int)s.charAt(l_pos.get(l_pos_ind))]--;
						l_pos_ind++;
					}
					
				}
				
				if(i+1-min_start<min_length){
					min_length=i+1-min_start;
					result=s.substring(min_start, i+1);
				}
				frequency[(int)s.charAt(l_pos.get(l_pos_ind))]--;
				count_type=1;
				l_pos_ind++;
				
				
				// in case of aaa, shrink to a if(t is abc, just one a)
				while(true){
					
					if(frequency[(int)s.charAt(l_pos.get(l_pos_ind))]<=contain[(int)s.charAt(l_pos.get(l_pos_ind))]){
						min_start=l_pos.get(l_pos_ind);
						break;
					}
					else {
						frequency[(int)s.charAt(l_pos.get(l_pos_ind))]--;
						l_pos_ind++;
					}
					
				}
				
				
				
				
				
			}
		}
		return result;
    }
}
