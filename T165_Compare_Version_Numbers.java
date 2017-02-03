public class Solution {
    public int compareVersion(String version1, String version2) {
        int dot_index1=version1.indexOf('.');
        int dot_index2=version2.indexOf('.');
        if(dot_index1==-1&&dot_index2==-1){
        	version1=str_trim_zero(version1);
        	version2=str_trim_zero(version2);
        	if(version1.length()<version2.length())
        		return -1;
        	else if(version1.length()>version2.length())
        		return 1;
        	else{
        		for(int i=0;i<version1.length();i++){
        			if(version1.charAt(i)<version2.charAt(i))
        				return -1;
        			else if(version1.charAt(i)>version2.charAt(i))
        				return 1;
        		}
        		return 0;
        			
        	}
        }else if(dot_index1>=0&&dot_index2==-1){
        	String str1=version1.substring(0,dot_index1);
        	str1=str_trim_zero(str1);
        	version2=str_trim_zero(version2);
        	
        	
        	
        	if(str1.length()<version2.length())
        		return -1;
        	else if(str1.length()>version2.length())
        		return 1;
        	else{
        		for(int i=0;i<str1.length();i++){
        			if(str1.charAt(i)<version2.charAt(i))
        				return -1;
        			else if(str1.charAt(i)>version2.charAt(i))
        				return 1;
        		}
        		
        		for(int index=dot_index1;index<version1.length();index++){
        			if(version1.charAt(index)!='.'&&version1.charAt(index)!='0')
        				return 1;
        		}
        		
        		return 0;	
        	}
        }else if(dot_index1==-1&&dot_index2>=0){
        	String str2=version2.substring(0,dot_index2);
        	str2=str_trim_zero(str2);
        	version1=str_trim_zero(version1);
        	if(version1.length()<str2.length())
        		return -1;
        	else if(version1.length()>str2.length())
        		return 1;
        	else{
        		for(int i=0;i<version1.length();i++){
        			if(version1.charAt(i)<str2.charAt(i))
        				return -1;
        			else if(version1.charAt(i)>str2.charAt(i))
        				return 1;
        		}
        		
        		for(int index=dot_index2;index<version2.length();index++){
        			if(version2.charAt(index)!='.'&&version2.charAt(index)!='0')
        				return -1;
        		}
        		
        		return 0;	
        		
        	}
        }else{
        	
        	
        	String str1=version1.substring(0,dot_index1);
        	String str2=version2.substring(0,dot_index2);
        	
        	str1=str_trim_zero(str1);
        	str2=str_trim_zero(str2);
        	
        	if(str1.length()<str2.length())
        		return -1;
        	else if(str1.length()>str2.length())
        		return 1;
        	else{
        		for(int i=0;i<str1.length();i++){
        			if(str1.charAt(i)<str2.charAt(i))
        				return -1;
        			else if(str1.charAt(i)>str2.charAt(i))
        				return 1;
        		}
        	}
        	
        	String decimal1=version1.substring(dot_index1+1,version1.length());
        	String decimal2=version2.substring(dot_index2+1,version2.length());
        	return compareVersion(decimal1, decimal2);
        	
        }
        
        
        
    }
	
	public String str_trim_zero(String str){
		for(int i=0;i<str.length();i++){
			if(i==str.length()-1)
				return str.substring(i,str.length());
			else{
				if(str.charAt(i)!='0')
					return str.substring(i,str.length());
			}
		}
		
		return str;
		
	}
}
