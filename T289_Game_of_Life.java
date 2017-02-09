public class Solution {
    public void gameOfLife(int[][] board) {
        int[] vectori=new int[]{-1,0,1,  -1,1,  -1,0,1,};
		int[] vectorj=new int[]{-1,-1,-1,0,0,1,1,1};
		int count;
		
		
		for(int i=0;i<board.length;i++)
			for(int j=0;j<board[0].length;j++){
				
				count=0;
				for(int index=0;index<8;index++){
					if(i+vectori[index]>=0&&i+vectori[index]<board.length&&
							j+vectorj[index]>=0&&j+vectorj[index]<board[0].length)
						if(board[i+vectori[index]][j+vectorj[index]]%2==1)
							count++;
				}
				if(board[i][j]==1){
					if(count<2)
						board[i][j]=3;
					else if(count>3)
						board[i][j]=3;
				}else{
					if(count==3)
						board[i][j]=4;
				}
				
			}
		
		for(int i=0;i<board.length;i++)
			for(int j=0;j<board[0].length;j++){
				
				if(board[i][j]==3)
					board[i][j]=0;
				else if(board[i][j]==4)
					board[i][j]=1;
				
			}
    }
}
