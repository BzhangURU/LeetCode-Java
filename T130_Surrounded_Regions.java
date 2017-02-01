public class Solution {
    public void solve(char[][] board) {
		if(board.length==0)
			return;
		Queue<Integer> queue_i=new LinkedList<Integer>();
		Queue<Integer> queue_j=new LinkedList<Integer>();
		
		
		for(int i=0;i<board.length;i++){
			if(board[i][0]=='O'){
				queue_i.add(i);
				queue_j.add(0);
				int x,y;
				while(!queue_i.isEmpty()){
					x=queue_i.poll();
					y=queue_j.poll();
					if(board[x][y]=='O'){
    					board[x][y]='N';//not captured
    					if(x>0&&board[x-1][y]=='O'){
    						queue_i.offer(x-1);
    						queue_j.offer(y);
    					}
    					if(x<board.length-1&&board[x+1][y]=='O'){
    						queue_i.offer(x+1);
    						queue_j.offer(y);
    					}
    					if(y>0&&board[x][y-1]=='O'){
    						queue_i.offer(x);
    						queue_j.offer(y-1);
    					}
    					if(y<board[0].length-1&&board[x][y+1]=='O'){
    						queue_i.offer(x);
    						queue_j.offer(y+1);
    					}
					}
				}
				
				
			}
			if(board[i][board[0].length-1]=='O'){
				queue_i.add(i);
				queue_j.add(board[0].length-1);
				int x,y;
				while(!queue_i.isEmpty()){
					x=queue_i.poll();
					y=queue_j.poll();
					if(board[x][y]=='O'){
    					board[x][y]='N';//not captured
    					if(x>0&&board[x-1][y]=='O'){
    						queue_i.offer(x-1);
    						queue_j.offer(y);
    					}
    					if(x<board.length-1&&board[x+1][y]=='O'){
    						queue_i.offer(x+1);
    						queue_j.offer(y);
    					}
    					if(y>0&&board[x][y-1]=='O'){
    						queue_i.offer(x);
    						queue_j.offer(y-1);
    					}
    					if(y<board[0].length-1&&board[x][y+1]=='O'){
    						queue_i.offer(x);
    						queue_j.offer(y+1);
    					}
					}
				}
				
				
			}
			
		}
		
		
		
		
		for(int j=1;j<board[0].length-1;j++){
			if(board[0][j]=='O'){
				queue_i.add(0);
				queue_j.add(j);
				int x,y;
				while(!queue_i.isEmpty()){
					x=queue_i.poll();
					y=queue_j.poll();
					if(board[x][y]=='O'){
    					board[x][y]='N';//not captured
    					if(x>0&&board[x-1][y]=='O'){
    						queue_i.offer(x-1);
    						queue_j.offer(y);
    					}
    					if(x<board.length-1&&board[x+1][y]=='O'){
    						queue_i.offer(x+1);
    						queue_j.offer(y);
    					}
    					if(y>0&&board[x][y-1]=='O'){
    						queue_i.offer(x);
    						queue_j.offer(y-1);
    					}
    					if(y<board[0].length-1&&board[x][y+1]=='O'){
    						queue_i.offer(x);
    						queue_j.offer(y+1);
    					}
					}
				}
				
				
			}
			if(board[board.length-1][j]=='O'){
				queue_i.add(board.length-1);
				queue_j.add(j);
				int x,y;
				while(!queue_i.isEmpty()){
					x=queue_i.poll();
					y=queue_j.poll();
					if(board[x][y]=='O'){
    					board[x][y]='N';//not captured
    					if(x>0&&board[x-1][y]=='O'){
    						queue_i.offer(x-1);
    						queue_j.offer(y);
    					}
    					if(x<board.length-1&&board[x+1][y]=='O'){
    						queue_i.offer(x+1);
    						queue_j.offer(y);
    					}
    					if(y>0&&board[x][y-1]=='O'){
    						queue_i.offer(x);
    						queue_j.offer(y-1);
    					}
    					if(y<board[0].length-1&&board[x][y+1]=='O'){
    						queue_i.offer(x);
    						queue_j.offer(y+1);
    					}
					}
				}
				
				
			}
			
		}
		
		
		for(int i=0;i<board.length;i++)
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]=='O')
					board[i][j]='X';
				else if(board[i][j]=='N')
					board[i][j]='O';
			}
    }
}
