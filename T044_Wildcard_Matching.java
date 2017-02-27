public class Solution {
    public boolean isMatch(String s, String p) {
        if(s.length()==0&&p.length()==0)
			return true;
		//initialize with false
        boolean[][] match=new boolean[p.length()+1][s.length()+1];//!!!!!!!!!!!!!!!
        //match[i][j] means whether p[0,...,i-1] and s[0,...,j-1] match
        Arrays.fill(match[0], false);
        match[0][0]=true;//nothing = nothing
        for(int i=1;i<=p.length();i++){
        	if(p.charAt(i-1)=='*'){
        		int j;
        		for(j=0;j<=s.length();j++)
        			if(!match[i-1][j])
        				match[i][j]=false;
        			else break;
        		//if there is true, all the rest is true
        		for(;j<=s.length();j++)
        			match[i][j]=true;
        		
        		
        	}else if(p.charAt(i-1)=='?'){
        		match[i][0]=false;
        		for(int j=1;j<=s.length();j++)
        			match[i][j]=(match[i-1][j-1]?true:false);
        	}else{
        		match[i][0]=false;
        		for(int j=1;j<=s.length();j++)
        			match[i][j]=(match[i-1][j-1]&&(p.charAt(i-1)==s.charAt(j-1))?true:false);
        	}
        }
        return match[p.length()][s.length()];
    }
}
