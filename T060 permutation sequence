public class Solution {
    public String getPermutation(int n, int k) {
        k=k-1;
        int[] permutation=new int[n+1];
        permutation[0]=1;
        for(int i=1;i<=n;i++){
        	permutation[i]=permutation[i-1]*i;
        }
        
        if(k>=permutation[n]||k<0)
        	return "error";
        
        StringBuilder builder=new StringBuilder();
        boolean available[]=new boolean[n];
        Arrays.fill(available,true);
        
        int current_k=0;
        
		for(int index=0;index<n;index++){
			
			//there are (n-index) available numbers
			int choose=(k-current_k)/permutation[n-1-index];
			
			int count=0;
			for(int i=0;i<n;i++){
				if(available[i]==true){
					if(count==choose){
						available[i]=false;
						builder.append(Integer.toString(i+1));
						break;
					}else count++;
				}
			}
			current_k+=permutation[n-1-index]*choose;
			
		}
		
		return builder.toString();
    }
}
