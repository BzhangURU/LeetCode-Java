public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> list=new LinkedList<String>();
        if(num<0)
        	return list;
        boolean[] use=new boolean[10];
        process(num,0,use,list);
        return list;
    }
	public void process(int num,int start_index,boolean[] use,List<String> list){
		if(num==0){
			int hour=0;
			if(use[0]==true)
				hour+=8;
			if(use[1]==true)
				hour+=4;
			if(use[2]==true)
				hour+=2;
			if(use[3]==true)
				hour+=1;
			int minute=0;
			if(use[4]==true)
				minute+=32;
			if(use[5]==true)
				minute+=16;
			if(use[6]==true)
				minute+=8;
			if(use[7]==true)
				minute+=4;
			if(use[8]==true)
				minute+=2;
			if(use[9]==true)
				minute+=1;
			if(hour<12&&minute<60){
				if(minute<10)
					list.add(Integer.toString(hour)+":0"+Integer.toString(minute));
				else list.add(Integer.toString(hour)+":"+Integer.toString(minute));
				
			}
		}else{
			if(10-start_index>=num){
				process(num,start_index+1,use,list);
				
				use[start_index]=true;
				process(num-1,start_index+1,use,list);
				use[start_index]=false;
			}
			
			
		}
	}
}
