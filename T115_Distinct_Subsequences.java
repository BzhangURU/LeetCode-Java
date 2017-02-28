public class Solution {
    public int numDistinct(String s, String t) {
        if(s.length()<t.length())
        	return 0;
		int[][] num=new int[t.length()+1][s.length()+1];
		for(int i=0;i<=s.length();i++)
			num[0][i]=1;
		boolean check=false;
		for(int t_num=1;t_num<=t.length();t_num++){
			//s_num==t_num
			check=false;
			if(t.charAt(t_num-1)==s.charAt(t_num-1)){
				num[t_num][t_num]=num[t_num-1][t_num-1];
				if(num[t_num][t_num]>0)
					check=true;
			}
			else num[t_num][t_num]=0;
			
			
			
			//s_num>t_num
			for(int s_num=t_num+1;s_num<=s.length();s_num++){
				if(t.charAt(t_num-1)==s.charAt(s_num-1))
					num[t_num][s_num]=num[t_num-1][s_num-1]+num[t_num][s_num-1];
				else num[t_num][s_num]=num[t_num][s_num-1];
				if(num[t_num][s_num]>0)
					check=true;
			}
			if(!check)
				return 0;
			
		}
		return num[t.length()][s.length()];
    }
}
