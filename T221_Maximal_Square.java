public class Solution {
    public int maximalSquare(char[][] matrix) {
        int side_length=0;
        
		for(int i=0;i<matrix.length;i++)
			for(int j=0;j<matrix[0].length;j++){
				int current_length=0;
				if(matrix[i][j]=='1'){
					current_length=1;
					boolean stop=false;
					while(true){
						
						if(i+current_length<matrix.length&&j+current_length<matrix[0].length){
							for(int line=i;line<=i+current_length;line++){
								if(matrix[line][j+current_length]!='1'){
									stop=true;
									break;
								}
							}
							if(stop)
								break;
							for(int col=j;col<j+current_length;col++){
								if(matrix[i+current_length][col]!='1'){
									stop=true;
									break;
								}
							}
							if(stop)
								break;
							
							current_length++;
						}else break;
						
						
					}
					
					if(current_length>side_length){
						//System.out.println("i="+i+" j="+j+" length="+current_length);
						side_length=current_length;
					}
					
				}
				
			}
		return side_length*side_length;
    }
}
