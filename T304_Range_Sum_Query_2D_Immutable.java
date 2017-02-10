public class NumMatrix {
    int[][] prefix_sum;
    public NumMatrix(int[][] matrix) {
    	if(matrix!=null&&matrix.length>0){
	    	
	    	prefix_sum=new int[matrix.length][matrix[0].length];
	    	prefix_sum[0][0]=matrix[0][0];
	    	for(int col=1;col<matrix[0].length;col++)
	    		prefix_sum[0][col]=prefix_sum[0][col-1]+matrix[0][col];
	    		
	    	for(int row=1;row<matrix.length;row++)
	    		prefix_sum[row][0]=prefix_sum[row-1][0]+matrix[row][0];
	    	
	    	for(int col=1;col<matrix[0].length;col++)
	    		for(int row=1;row<matrix.length;row++)
	    			prefix_sum[row][col]=prefix_sum[row-1][col]+prefix_sum[row][col-1]-prefix_sum[row-1][col-1]+matrix[row][col];
	    		
	    	
	    	
    	}
    	
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1==0&&col1==0){
    		return prefix_sum[row2][col2];
    	}else if(row1==0){
    		return prefix_sum[row2][col2]-prefix_sum[row2][col1-1];
    	}else if(col1==0){
    		return prefix_sum[row2][col2]-prefix_sum[row1-1][col2];
    	}else return prefix_sum[row2][col2]-prefix_sum[row1-1][col2]-prefix_sum[row2][col1-1]+prefix_sum[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
