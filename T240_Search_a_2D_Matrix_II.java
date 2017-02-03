public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
        	return false;
        return search_part_of_Matrix(matrix,target,0,matrix.length-1,0,matrix[0].length-1);
        
    }
	
	public boolean search_part_of_Matrix(int[][] matrix, int target,int top,int down,int left,int right){
        
        if(left>right||top>down||left<0||right>=matrix[0].length||top<0||down>=matrix.length)
        	return false;
        if(left+2>=right&&top+2>=down){
        	for(int i=top;i<=down;i++){
        		for(int j=left;j<=right;j++)
        			if(matrix[i][j]==target)
        				return true;
        	}
        	return false;
        }
        
        int line=down-(down-top)/3;
        int col=right-(right-left)/3;
        
        
        if(matrix[line][col]==target)
        	return true;
        else if(matrix[line][col]>target){
        	return search_part_of_Matrix(matrix,target,top,line,left,col)||
        			search_part_of_Matrix(matrix,target,line+1,down,left,col-1)||
        			search_part_of_Matrix(matrix,target,top,line-1,col+1,right);
        }else {
        	return search_part_of_Matrix(matrix,target,line,down,col,right)||
        			search_part_of_Matrix(matrix,target,line+1,down,left,col-1)||
        			search_part_of_Matrix(matrix,target,top,line-1,col+1,right);
        }
        
    }
}
