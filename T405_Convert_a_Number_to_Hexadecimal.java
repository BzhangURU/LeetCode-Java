public class Solution {
    public String toHex(int num) {
        String result="";
		char[] chars=new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		int num0_15;
        for(int part=7;part>=0;part--){
        	num0_15=((num&(15<<(part*4)))>>>(part*4));
        	result=result+chars[num0_15];
        }
        int start=7;
        for(int i=7;i>=0;i--){
        	if(result.charAt(i)!='0')
        		start=i;
        }
        return result.substring(start);
    }
}
