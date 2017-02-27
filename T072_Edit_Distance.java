public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0)
			return word2.length();
		if(word2.length()==0)
			return word1.length();
        int[][] dis=new int[word1.length()+1][word2.length()+1];
        dis[0][0]=0;
        int index_2,min;
        for(int sum=1;sum<=word1.length()+word2.length();sum++){
        	for(int index_1=Math.max(0, sum-word2.length());index_1<=sum&&index_1<=word1.length();index_1++){	
        		index_2=sum-index_1;
        		if(index_1==0)
        			dis[0][index_2]=index_2;
        		else if(index_2==0)
        			dis[index_1][0]=index_1;
        		else if(word1.charAt(index_1-1)==word2.charAt(index_2-1))
        			dis[index_1][index_2]=dis[index_1-1][index_2-1];
        		else{
        			min=Integer.MAX_VALUE;
        			if(min>dis[index_1-1][index_2-1]+1)
        				min=dis[index_1-1][index_2-1]+1;
        			if(min>dis[index_1-1][index_2]+1)
        				min=dis[index_1-1][index_2]+1;
        			if(min>dis[index_1][index_2-1]+1)
        				min=dis[index_1][index_2-1]+1;
        			dis[index_1][index_2]=min;
        		}
        		
        		
        	}
        }
        
        return dis[word1.length()][word2.length()];
        
        
    }
}
