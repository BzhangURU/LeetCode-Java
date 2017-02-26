public class Solution {
    public String removeDuplicateLetters(String s) {
		if(s.length()==0)
			return s;
        boolean isused[]=new boolean[26];
        Arrays.fill(isused, true);
        
        int last_position[]=new int[26];
        Arrays.fill(last_position, s.length());
        int count_last=0;
        for(int i=s.length()-1;i>=0;i--){
        	if(last_position[s.charAt(i)-'a']==s.length()){
        		last_position[s.charAt(i)-'a']=i;
        		isused[s.charAt(i)-'a']=false;
        		count_last++;
        	}
        	if(count_last==26)
        		break;
        }
        return remove_dup(s,"",0,isused,count_last,last_position);
        
        
    }
	
	public String remove_dup(String s, String current, int start,boolean isused[],int count_letter,int last_position[]){
		if(start>=s.length()||count_letter==0)
			return current;
		
		char lowest_possible='z'+1;
		int first_position=-10;
		int search_end=s.length()-1;//search from start to search_end
		for(int i=0;i<26;i++)
			if(!isused[i]&&last_position[i]<search_end)
				search_end=last_position[i];
				
			
		
		for(int i=start;i<=search_end;i++){
			if(!isused[s.charAt(i)-'a']&&s.charAt(i)<lowest_possible){
				lowest_possible=s.charAt(i);
				first_position=i;
			}
		}
		
		isused[lowest_possible-'a']=true;
		return remove_dup(s,current+lowest_possible,first_position+1,isused,count_letter-1,last_position);
		
	}
}
