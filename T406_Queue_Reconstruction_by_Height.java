public class Solution {
    public int[][] reconstructQueue(int[][] people) {
		if(people==null||people.length==0)
			return people;
        ArrayList<Integer> h=new ArrayList<Integer>();
        ArrayList<Integer> k=new ArrayList<Integer>();
        
        
        quicksort_reverse(people,0,people.length-1);
        for(int i=0;i<people.length;i++){
        	h.add(people[i][1],people[i][0]);
        	k.add(people[i][1],people[i][1]);
        }
        
        int[][] result=new int[people.length][2];
        for(int i=0;i<people.length;i++){
        	result[i][0]=h.get(i);
        	result[i][1]=k.get(i);
        }
        
        return result;
    }
	
	
	
	public void quicksort_reverse(int[][] people, int left, int right){
		int l=left;
		int r=right;
		int pivot_h=people[left+(right-left)/2][0];
		int pivot_k=people[left+(right-left)/2][1];
		
		while(l<=r){
			while(a_minus_b(people[l][0],people[l][1],pivot_h,pivot_k)>0)
				l++;
			while(a_minus_b(people[r][0],people[r][1],pivot_h,pivot_k)<0)
				r--;
			
			if(l<=r){
				int temp_h=people[l][0];
				int temp_k=people[l][1];
				
				people[l][0]=people[r][0];
				people[l][1]=people[r][1];
				
				people[r][0]=temp_h;
				people[r][1]=temp_k;
				l++;
				r--;//!!!!!!!
				
			}
			
		}
		
		if(left<r)
			quicksort_reverse(people,left,r);
		if(l<right)
			quicksort_reverse(people,l,right);
		
		
		
		
	}
	public int a_minus_b(int ah,int ak,int bh,int bk){
		if(ah!=bh)
			return ah-bh;
		else return bk-ak;
	}
}
