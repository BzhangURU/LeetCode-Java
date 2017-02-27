public class Solution {
    public boolean isNumber(String s) {
        
		String str=s.trim();
		if(str.length()==0)
			return false;
		boolean dot_used=false;
		int i=0;
		if(str.charAt(0)=='-'||str.charAt(0)=='+'){
			i++;
		}
		
		
		for(;i<str.length();i++){
			if(str.charAt(i)=='e'){
				if(i==0||(str.charAt(i-1)!='.'&&(str.charAt(i-1)>'9'||str.charAt(i-1)<'0')))
					return false;
				return isNumber_without_e_dot(str,i+1);
			}else if(str.charAt(i)=='.'){
			    if(i==0||(str.charAt(i-1)>'9'||str.charAt(i-1)<'0'))
					if(i==str.length()-1||(str.charAt(i+1)>'9'||str.charAt(i+1)<'0'))
						return false;
				if(dot_used)
					return false;
				else{
					dot_used=true;
				}
			}else if(str.charAt(i)>'9'||str.charAt(i)<'0')
				return false;
		}
		return true;
		
    }
	
	//check whether it is an integer after e
	public boolean isNumber_without_e_dot(String str, int index){
		if(str.length()-1<index)
			return false;
		if(str.charAt(index)=='-'||str.charAt(index)=='+')
			index++;
		if(str.length()-1-index<0)
			return false;
		
		
		for(;index<str.length();index++){
			if(str.charAt(index)>'9'||str.charAt(index)<'0')
				return false;
		}
		return true;
		
	}
}
