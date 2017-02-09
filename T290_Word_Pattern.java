public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> p2str=new HashMap<Character,String>();
        String[] strings=str.split(" ");
        if(pattern.length()!=strings.length)
        	return false;
        for(int i=0;i<pattern.length();i++){
        	if(p2str.containsKey(pattern.charAt(i))){
        		if(!strings[i].equals(p2str.get(pattern.charAt(i))))
        			return false;
        	}else{
        		if(p2str.containsValue(strings[i]))
        			return false;
        		else
        		p2str.put(pattern.charAt(i),strings[i]);
        	}
        	
        }
        return true;
    }
}
