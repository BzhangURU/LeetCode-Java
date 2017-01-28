/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)
        	return false;
        if(matrix[0].length==0)
        	return false;
        int LINE=matrix.length;
        int COLUMN=matrix[0].length;
        int min=0;
        int max=LINE*COLUMN-1;
        
        if(target<matrix[0][0])
        	return false;
        else if(target==matrix[0][0])
        	return true;
        if(target>matrix[LINE-1][COLUMN-1])
        	return false;
        else if(target==matrix[LINE-1][COLUMN-1])
        	return true;
        
        int middle;
        
        while(true){
        	middle=(max+min)/2;
        	
        	if(matrix[middle/COLUMN][middle%COLUMN]<target)
        		min=middle;
        	else if(matrix[middle/COLUMN][middle%COLUMN]>target)
        		max=middle;
        	else{
        		return true;
        	}
        	if(min+1==max)
        		return false;
        }
    }
}
