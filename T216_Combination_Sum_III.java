public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> LofL=new LinkedList<List<Integer>>();
		List<Integer> list=new LinkedList<Integer>();
		build_combination(LofL,list,k,n,1);
		return LofL;
    }
	
	public void build_combination(List<List<Integer>> LofL, List<Integer> list,int k,int n,int start_num){
		
		if(k==0&&n==0){
			LofL.add(new LinkedList<Integer>(list));
		}else if(k>0){
			for(int i=start_num;i<=9;i++){
				list.add(i);
				build_combination(LofL,list,k-1,n-i,i+1);
				list.remove(list.size()-1);
			}
		}
		
	}
}
