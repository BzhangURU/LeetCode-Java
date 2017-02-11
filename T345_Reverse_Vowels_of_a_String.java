public class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowel=new StringBuilder();
        StringBuilder str=new StringBuilder();
        
        
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||
        			s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U')
        		vowel.append(s.charAt(i));
        }
        vowel=vowel.reverse();
        int count=0;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||
        			s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U'){
        		str.append(vowel.charAt(count));
        		count++;
        	}else{
        		str.append(s.charAt(i));
        	}
        }
        return str.toString();
    }
}
