public class Solution {
    public List<String> removeInvalidParentheses(String s) {
		char[] str=s.toCharArray();
		List<String> list=new ArrayList<String>();
        List<Integer> right_places=new ArrayList<Integer>();//index of right bracket
        for(int i=0;i<s.length();i++)
        	if(s.charAt(i)==')')
        		right_places.add(i);
        process(list,str,0,right_places,0);
        List<String> result=new ArrayList<String>();
        List<Integer> left_places=new ArrayList<Integer>();//index of left bracket
        for(int i=s.length()-1;i>=0;i--)
        	if(s.charAt(i)=='(')
        		left_places.add(i);
        for(int i=0;i<list.size();i++){
        	char[] liststr=list.get(i).toCharArray();
        	process_reverse(result,liststr,liststr.length-1,left_places,0);
        }
        return result;
        
        
        
        
    }
	
	public void process(List<String> list, char[] str, int start,List<Integer> right_places,int available_delete_place_start){
		if(start>str.length-1){
			String s=new String(str);
			list.add(s);
		}else{
			
	        int left_right=0,i;//left-right
	        for(i=start;i<str.length;i++){
	        	if(str[i]=='(')
	        		left_right++;
	        	else if(str[i]==')'){
	        		left_right--;
	        	}
	        	if(left_right<0){
	        		for(int j=available_delete_place_start;j<right_places.size();j++){
	        			if(right_places.get(j)>i)
	        				break;
	        			if(right_places.get(j)==0||str[right_places.get(j)-1]!=')'){
	        				str[right_places.get(j)]='@';
	        				process(list,str,i+1,right_places,j+1);
	        				str[right_places.get(j)]=')';
	        			}
	        			
	        		}
	        		return;
	        		
	        	}else if(i==str.length-1){
	        		String s=new String(str);
	        		list.add(s);
	        	}
	        	
	        	
	        }
	        
		}
        
        
	}
	
	public void process_reverse(List<String> result, char[] str, int end, List<Integer> left_places,int available_delete_place_end){
		if(end<0){
			String s=new String(str).replace("@", "");//'@' means right bracket that is deleted
			result.add(s);
		}else{
	        int right_left=0,i;//left-right
	        
	        for(i=end;i>=0;i--){
	        	if(str[i]==')')
	        		right_left++;
	        	else if(str[i]=='('){
	        		right_left--;
	        	}
	        	if(right_left<0){
	        		for(int j=available_delete_place_end;j<left_places.size();j++){
	        			if(left_places.get(j)<i)//the place of deleted left bracket should on the right of i
	        				break;
	        			if(left_places.get(j)==str.length-1||str[left_places.get(j)+1]!='('){
	        				str[left_places.get(j)]='@';
	        				process_reverse(result,str,i-1,left_places,j+1);
	        				str[left_places.get(j)]='(';
	        			}
	        		}
	        		return;
	        		
	        	}else if(i==0){
	        		String s=new String(str).replace("@", "");//'@' means right bracket that is deleted
	    			result.add(s);
				}
	        	
	        	
	        }
		}
        
        
	}
}
