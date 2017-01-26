import java.util.*;
public class T448_Find_All_Numbers_Disappeared_in_an_Array {
	//my solution
	public List<Integer> findDisappearedNumbers(int[] nums) {
		
		List<Integer> List=new LinkedList<Integer>();
		if(nums.length==0)
			return List;
        //int length=nums.length;
        
        for(int i=1;i<=nums.length;i++){
        	
        	if(nums[i-1]!=i){
        		
        		if(nums[i-1]==-1)
        			continue;
        		
        		int save=nums[i-1];
        		nums[i-1]=-1;
        		
        		int save_new;
        		/*while(true){
        			if(nums[save-1]!=save){
        				save_new=nums[save-1];
        				nums[save-1]=save;
        				save=save_new;
        			}else break;
        		}*/
        		while(nums[save-1]!=save){
    				save_new=nums[save-1];
    				nums[save-1]=save;
    				save=save_new;
    				if(save==-1)
    					break;
        			
        		}
        		
        	}
        	
        	
        }
        for(int i=1;i<=nums.length;i++){
        	if(nums[i-1]!=i){
        		List.add(i);
        	}
        }
        return List;
        
    }
	
	
	
	//other solution
public List<Integer> findDisappearedNumbers2(int[] nums) {
		
		List<Integer> List=new LinkedList<Integer>();
		for(int i=0;i<nums.length;i++){
			int idx = Math.abs(nums[i]-1);
			nums[idx] = -1*Math.abs(nums[idx]-1);
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]<0)
				List.add(nums[i]);
		}
        return List;
        
    }
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T448_Find_All_Numbers_Disappeared_in_an_Array ex=new T448_Find_All_Numbers_Disappeared_in_an_Array();
		System.out.println(ex.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
	}

}
