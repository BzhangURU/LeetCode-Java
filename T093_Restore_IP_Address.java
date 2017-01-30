import java.util.LinkedList;
import java.util.List;

/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) */


public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> results=new LinkedList<String>();
        helper(results,"",s,0);
        return results;
    }
	
	public void helper(List<String> results,String str_used,String str_left, int num_dots_used){
		if(num_dots_used==3){
			if(str_left.length()==0||str_left.length()>3)
				return;
			int i=0;
			if(str_left.charAt(0)=='0'){
				if(str_left.length()>1)
					return;
				else{
					results.add(str_used+"0");
				}
			}else{
				int num=0;
				while(i<str_left.length()){
					num=num*10+(int)(str_left.charAt(i)-'0');
					i++;
				}
				if(num<256)
					results.add(str_used+str_left);
			}
		}else{
				if(str_left.length()>3*(4-num_dots_used)||str_left.length()<4-num_dots_used)
					return;
				
				if(str_left.charAt(0)=='0'){
					helper(results,str_used+str_left.charAt(0)+".",str_left.substring(1,str_left.length()),num_dots_used+1);
				}else{
				
					helper(results,str_used+str_left.charAt(0)+".",str_left.substring(1,str_left.length()),num_dots_used+1);
					
					if(str_left.length()>=2){
						helper(results,str_used+str_left.substring(0,2)+".",str_left.substring(2,str_left.length()),num_dots_used+1);
					}
						
					if(str_left.length()>=3){
						if(str_left.charAt(0)<'2'||(str_left.charAt(0)=='2'&&str_left.charAt(1)<'5')||(str_left.charAt(0)=='2'&&str_left.charAt(1)=='5'&&str_left.charAt(2)<'6'))
							helper(results,str_used+str_left.substring(0,3)+".",str_left.substring(3,str_left.length()),num_dots_used+1);
					}
				
				}
				
			}
			
		
		
		
		
	}
}
