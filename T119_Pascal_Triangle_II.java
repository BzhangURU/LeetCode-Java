public class Solution {
    public List<Integer> getRow(int rowIndex) {
		List<Integer> list_odd=new LinkedList<Integer>();
        /*if(rowIndex<0)
        	return list_odd;*/
        list_odd.add(1);
        if(rowIndex<=0)
        	return list_odd;
        List<Integer> list_even=new LinkedList<Integer>();
        boolean even=false;
        for(int i=1;i<=rowIndex;i++){
        	even=(even==true?false:true);
        	if(even){
        		int num=0;
        		int num_index;
        		for(int index=0;index<list_odd.size();index++){
        			num_index=list_odd.get(index);
        			list_even.add(num+num_index);
        			num=num_index;
        		}
        		list_even.add(1);
        		list_odd.clear();
        	}else{
        		int num=0;
        		int num_index;
        		for(int index=0;index<list_even.size();index++){
        			num_index=list_even.get(index);
        			list_odd.add(num+num_index);
        			num=num_index;
        		}
        		list_odd.add(1);
        		list_even.clear();
        	}
        	
        }
        return even==true?list_even:list_odd;
        
        
        
    }
}
