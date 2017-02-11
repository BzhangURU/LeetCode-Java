public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length())
        	return false;
		int[] ransom_letter_num=new int[26];
        Arrays.fill(ransom_letter_num,0);
        int[] magazine_letter_num=new int[26];
        Arrays.fill(magazine_letter_num,0);
        
        for(int i=0;i<ransomNote.length();i++)
        	ransom_letter_num[ransomNote.charAt(i)-'a']++;
        for(int i=0;i<magazine.length();i++)
        	magazine_letter_num[magazine.charAt(i)-'a']++;
        for(int i=0;i<26;i++)
        	if(magazine_letter_num[i]<ransom_letter_num[i])
        		return false;
        return true;
    }
}
