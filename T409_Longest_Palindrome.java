public class Solution {
    public int longestPalindrome(String s) {
        int[] count=new int[58];
        
        for(int i=0;i<s.length();i++){
        	count[s.charAt(i)-'A']++;
        }
        int sum=0;
        for(int i=0;i<26;i++){
        	sum+=((count[i]>>1)<<1);//get even number
        }
        for(int i=32;i<58;i++)
        	sum+=((count[i]>>1)<<1);//get even number
        if(sum<s.length())
        	sum++;
        return sum;
    }
}
