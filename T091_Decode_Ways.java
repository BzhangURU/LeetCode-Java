/* A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2. */

public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0)
        	return 0;
        else{
        	int[] nums=new int[s.length()];
        	int index=s.length()-1;
        	while(index>=0){
        		if(index==s.length()-1){
        			if(s.charAt(index)!='0')
        				nums[index]=1;
        			else nums[index]=0;
        		}else if(index==s.length()-2){
        			if(s.charAt(index)>'2')
        				if(s.charAt(index+1)!='0')
        					nums[index]=1;
        				else nums[index]=0;
        			else if(s.charAt(index)=='1')
        				if(s.charAt(index+1)>'0')
        					nums[index]=2;
        				else nums[index]=1;
        			else if(s.charAt(index)=='2')
        				if(s.charAt(index+1)>'0'&&s.charAt(index+1)<'7')
        					nums[index]=2;
        				else nums[index]=1;
        			else nums[index]=0;/*if(s.charAt(index)=='0')
        				*/
        		}else{
        			if(s.charAt(index)=='0')
        				nums[index]=0;
        			else if(s.charAt(index)<'3'&&(s.charAt(index)<'2'||s.charAt(index+1)<'7'))
        				nums[index]=nums[index+2]+nums[index+1];
        			else nums[index]=nums[index+1];
        		}
        		
        		index--;
        	}
        	
        	return nums[0];
        	
        }
    }
	
}
