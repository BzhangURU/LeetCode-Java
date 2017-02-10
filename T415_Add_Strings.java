public class Solution {
    public String addStrings(String num1, String num2) {
        if(num1.length()>num2.length())
        	return add_Strings(num2,num1);
        else return add_Strings(num1,num2);
        
        
    }
	public String add_Strings(String str1,String str2){
		StringBuilder builder=new StringBuilder();
        int length1=str1.length();
        int length2=str2.length();
        int carry=0;
        int num;
        for(int index=0;index<length1;index++){
        	num=(int)(str1.charAt(length1-1-index)-'0')+(int)(str2.charAt(length2-1-index)-'0')+carry;
        	carry=num/10;
        	num=num%10;
        	builder.append((char)('0'+num));
        	
        }
        for(int index=length1;index<length2;index++){
        	num=(int)(str2.charAt(length2-1-index)-'0')+carry;
        	carry=num/10;
        	num=num%10;
        	builder.append((char)('0'+num));
        }
        if(carry!=0)
        	builder.append('1');
        return builder.reverse().toString();
        
	}
}
