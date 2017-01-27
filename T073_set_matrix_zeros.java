public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean first_line_zero=false;
        boolean first_col_zero=false;
        
        for(int col=0;col<matrix[0].length;col++)
        	if(matrix[0][col]==0){
        		first_line_zero=true;
        		break;
        	}
        for(int line=0;line<matrix.length;line++)
        	if(matrix[line][0]==0){
        		first_col_zero=true;
        		break;
        	}
        for(int i=1;i<matrix.length;i++)
        	for(int j=1;j<matrix[0].length;j++){
        		if(matrix[i][j]==0){
        			matrix[i][0]=0;
        			matrix[0][j]=0;
        		}
        	}
        
        for(int col=1;col<matrix[0].length;col++)
        	if(matrix[0][col]==0){
        		for(int i=1;i<matrix.length;i++)
        			matrix[i][col]=0;
        	}
        for(int line=1;line<matrix.length;line++)
        	if(matrix[line][0]==0){
        		for(int j=1;j<matrix[0].length;j++)
        			matrix[line][j]=0;
        	}
        
        if(first_line_zero==true){
        	for(int col=0;col<matrix[0].length;col++)
            	matrix[0][col]=0;
        }
        if(first_col_zero==true){
        	for(int line=0;line<matrix.length;line++)
            	matrix[line][0]=0;
        }
    }
}
