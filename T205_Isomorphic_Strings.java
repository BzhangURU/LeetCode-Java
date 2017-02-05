public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map_s_to_t=new int[256];
		int[] map_t_to_s=new int[256];
		for(int i=0;i<s.length();i++){
			if(map_s_to_t[(int)s.charAt(i)]==0){
				if(map_t_to_s[(int)t.charAt(i)]==0){
					map_s_to_t[s.charAt(i)]=(int)t.charAt(i)+1;
					map_t_to_s[t.charAt(i)]=(int)s.charAt(i)+1;
				}else return false;
			}else{
				if(map_s_to_t[s.charAt(i)]!=(int)t.charAt(i)+1)
					return false;
			}
		}
		return true;
    }
}
