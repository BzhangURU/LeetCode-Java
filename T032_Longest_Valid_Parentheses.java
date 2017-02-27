public class Solution {
    public int longestValidParentheses(String s) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int max=0,height=0;
        map.put(0, 0);
       for(int i=1;i<=s.length();i++){
            
        	if(s.charAt(i-1)=='('){
        	    height++;
        		if(!map.containsKey(height)){
            		map.put(height, i);
            	}
        	}else{
        	    height--;
        		if(map.containsKey(height)){
        			if(i-map.get(height)>max)
        				max=i-map.get(height);
            		//map.put(height, i);
            		map.remove(height+1);
            	}else{
            		map.clear();//reach the bottom of wave, restart
            		map.put(height, i);
            	}
        	}
        	
        }
		
		return max;
    }
}
