public class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
        	return 0;
        int num=0;
        
        
        for(int i=0;i<grid.length;i++)
        	for(int j=0;j<grid[0].length;j++)
        		num=set_islands(grid,i,j,num);
        return num;
    }
	
	public int set_islands(char[][] grid,int x,int y,int num){
		if(grid[x][y]!='1')
			return num;
		Stack<Integer> stack_x=new Stack<Integer>();
		Stack<Integer> stack_y=new Stack<Integer>();
		stack_x.push(x);
		stack_y.push(y);
		
		int new_x;
		int new_y;
		while(!stack_x.isEmpty()){
			new_x=stack_x.pop();
			new_y=stack_y.pop();
			grid[new_x][new_y]='2';
			if(new_x>0&&grid[new_x-1][new_y]=='1'){
				stack_x.push(new_x-1);
				stack_y.push(new_y);
			}
			if(new_x<grid.length-1&&grid[new_x+1][new_y]=='1'){
				stack_x.push(new_x+1);
				stack_y.push(new_y);
			}
			if(new_y>0&&grid[new_x][new_y-1]=='1'){
				stack_x.push(new_x);
				stack_y.push(new_y-1);
			}
			if(new_y<grid[0].length-1&&grid[new_x][new_y+1]=='1'){
				stack_x.push(new_x);
				stack_y.push(new_y+1);
			}
		}
		
		return num+1;
		
		
	}
}
