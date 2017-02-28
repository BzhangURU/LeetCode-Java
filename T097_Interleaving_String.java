public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        if(s3.length()!=len1+len2)
        	return false;
        int l2;//number of letter used in s2
        boolean[][] isvalid=new boolean[len1+1][len2+1];
        isvalid[0][0]=true;//0 letter in s1 and 0 letter in s2
        boolean check;
        for(int length=1;length<=len1+len2;length++){
        	check=false;
        	for(int l1=Math.max(0, length-len2);l1<=length&&l1<=len1;l1++){
        		l2=length-l1;
        		if(l1>0&&isvalid[l1-1][l2]&&s1.charAt(l1-1)==s3.charAt(l1+l2-1)){
        			isvalid[l1][l2]=true;
        			check=true;
        		}
        		if(l2>0&&isvalid[l1][l2-1]&&s2.charAt(l2-1)==s3.charAt(l1+l2-1)){
        			isvalid[l1][l2]=true;
        			check=true;
        		}
        		
        	}
        	if(!check)
        		return false;
        }
        return isvalid[len1][len2];
    }
}
