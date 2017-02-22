public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
	        ArrayList<Integer> list=new ArrayList<Integer>();
	        
	        HashMap<String,Integer> word_map=new HashMap<String,Integer>();
	        HashMap<String,Integer> word_try=new HashMap<String,Integer>();
	        
	        int l=words[0].length();
	        int n=words.length;
	        
	        for(int i=0;i<n;i++){
	        	if(!word_map.containsKey(words[i]))
	        		word_map.put(words[i], 1);
	        	else word_map.put(words[i], word_map.get(words[i])+1);
	        }
	        boolean new_start;//if it is not a new_start, take advantage of old
	        int count;
	        String substr;
	        for(int offset=0;offset<l;offset++){
	        	int start=0;
	        	new_start=true;
	        	int word_j=0;
	        	while(start+offset<=s.length()-l*n){
	        		if(new_start){
	        			new_start=false;
			        	word_try.clear();
			        	
			        	for(word_j=0;word_j<n;word_j++){
			        		String str=s.substring(start+offset+word_j*l, start+offset+(word_j+1)*l);
			        		if(!word_map.containsKey(str)){
			        			start=start+word_j*l;//skip, because it will never be possible
			        			new_start=true;
			        			break;
			        		}
			        		if(!word_try.containsKey(str))
			        			word_try.put(str, 1);
			            	else {
			            		count=word_try.get(str);
			            		if(count==word_map.get(str)){
			            			break;
			            		}else word_try.put(str, count+1);
			            	}
			        	}
			        	if(word_j==n){
			        		list.add(start+offset);
			        	}
			        	start+=l;
	        		}else{
	        			substr=s.substring(start-l+offset, start+offset);
	        			count=word_try.get(substr);
	        			if(count>1)
	        				word_try.put(substr, count-1);
	        			else word_try.remove(substr);
	        			word_j--;
	        			for(;word_j<n;word_j++){
			        		String str=s.substring(start+offset+word_j*l, start+offset+(word_j+1)*l);
			        		if(!word_map.containsKey(str)){
			        			start=start+word_j*l;//skip, because it will never be possible
			        			new_start=true;
			        			break;
			        		}
			        		if(!word_try.containsKey(str))
			        			word_try.put(str, 1);
			            	else {
			            		count=word_try.get(str);
			            		if(count==word_map.get(str)){
			            			break;
			            		}else
			            			word_try.put(str, count+1);
			            	}
			        	}
			        	if(word_j==n){
			        		list.add(start+offset);
			        	}
			        	start+=l;
	        			
	        		}
	        	}
	        	
	        }
	        return list;
	        
	        
	    }
}
