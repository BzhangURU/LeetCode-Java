public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> List=new LinkedList<Integer>();
		int circle=0;
		
		while(circle<=matrix.length-1-circle&&circle<=matrix[0].length-1-circle){
			
			//System.out.println("circle="+circle);
			
			//if only one line is left
			if(circle==matrix.length-1-circle){
				//System.out.println("left to right    last step");
				for(int col=circle;col<matrix[0].length-circle;col++){
					List.add(matrix[circle][col]);
					//System.out.println(matrix[circle][col]);
				}
				break;
			}
			
			//if only one column is left
			if(circle==matrix[0].length-1-circle){
				//System.out.println("top to bottom    last step");
				for(int line=circle;line<matrix.length-circle;line++){
					List.add(matrix[line][matrix[0].length-1-circle]);
					//System.out.println(matrix[line][matrix[0].length-1-circle]);
				}
				break;
			}
			
			//left to right
			//System.out.println("left to right");
			for(int col=circle;col<matrix[0].length-circle;col++){
				List.add(matrix[circle][col]);
				//System.out.println(matrix[circle][col]);
			}
			//top to bottom
			//System.out.println("top to bottom");
			for(int line=circle+1;line<matrix.length-circle;line++){
				List.add(matrix[line][matrix[0].length-1-circle]);
				//System.out.println(matrix[line][matrix[0].length-1-circle]);
			}
			
			//right to left
			//System.out.println("right to left");
			for(int col=matrix[0].length-2-circle;col>=circle;col--){
				List.add(matrix[matrix.length-1-circle][col]);
				//System.out.println(matrix[matrix.length-1-circle][col]);
			}
			
			//bottom to top
			//System.out.println("bottom to top");
			for(int line=matrix.length-2-circle;line>circle;line--){
				List.add(matrix[line][circle]);
				//System.out.println(matrix[line][circle]);
			}
			circle++;
			
		}
		
		return List;
    }
}
