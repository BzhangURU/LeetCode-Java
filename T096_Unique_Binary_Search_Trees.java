/*Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class Solution {
    public int numTrees(int n) {
        int[][] numTrees_between_i_j=new int[n][n];//include i j
        
        int j;
        for(int dif=0;dif<n;dif++){
        	for(int i=0;i<n-dif;i++){
        		
        		j=i+dif;
    			int sum=0;
    			for(int index=i;index<=j;index++){
    				int left=1;
        			int right=1;
    				if(index>i)
    					left=numTrees_between_i_j[i][index-1];
    				if(index<j)
    					right=numTrees_between_i_j[index+1][j];
    				sum+=left*right;
    			}
    			
    			numTrees_between_i_j[i][j]=sum;
        			
        			
        		
        		
        	}
        }
        
        return numTrees_between_i_j[0][n-1];
    }
}
