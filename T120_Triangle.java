public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    //start from bottom line, dynamic programming
        int n=triangle.size();
		int[] path_sum=new int[n];
		for(int line=n-1;line>=0;line--){
			if(line==n-1){
				for(int i=0;i<=line;i++){
					path_sum[i]=triangle.get(line).get(i);
				}
			}else{
				int[] tmp=new int[n];
				for(int i=line;i>=0;i--){
					tmp[i]=triangle.get(line).get(i)+Math.min(path_sum[i], path_sum[i+1]);
				}
				path_sum=tmp;
			}
			
			
		}
		return path_sum[0];
    }
}
