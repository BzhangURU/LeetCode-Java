public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String,List<String>> map=new HashMap<String,List<String>>();
        for(int i=0;i<tickets.length;i++){
        	if(map.containsKey(tickets[i][0])){
        		map.get(tickets[i][0]).add(tickets[i][1]);
        	}else{
        		List<String> list=new ArrayList<String>();
        		list.add(tickets[i][1]);
        		map.put(tickets[i][0],list);
        	}
        }
        for(int i=0;i<tickets.length;i++){
        	Collections.sort(map.get(tickets[i][0]),new mycomparator());
        }
        
        HashMap<String,boolean[]> map_visited=new HashMap<String,boolean[]>();
        for(String str:map.keySet()){
        	int size=map.get(str).size();
        	boolean[] visited=new boolean[size];
        	map_visited.put(str, visited);
        }
        int length=tickets.length+1;
        List<String> list=new LinkedList<String>();
        list.add("JFK");
        List<List<String>> result=new LinkedList<List<String>>();
        process(list,"JFK",length,map,map_visited,result);
        if(result.size()>=1)
        	return result.get(0);
        else return list;
    }
	
	
	public void process(List<String> list,String current,int length,HashMap<String,List<String>> map,HashMap<String,boolean[]> map_visited,List<List<String>> result){
		if(list.size()==length){
			result.add(new LinkedList<String>(list));
			return;
		}
		
		int current_length=map.containsKey(current)?map.get(current).size():0;
		
		for(int i=0;i<current_length;i++){
			if(result.size()>0)
				break;
			if(!map_visited.get(current)[i]){
				
				list.add(map.get(current).get(i));
				map_visited.get(current)[i]=true;
				process(list,map.get(current).get(i),length,map,map_visited,result);
				list.remove(list.size()-1);
				map_visited.get(current)[i]=false;
				
			}
		}
	}
	
	private class mycomparator implements Comparator<String>{
		public int compare(String a,String b){
			if(a.charAt(0)!=b.charAt(0))
				return (int)a.charAt(0)-(int)b.charAt(0);
			else {
				if(a.charAt(1)!=b.charAt(1))
					return (int)a.charAt(1)-(int)b.charAt(1);
				else return (int)a.charAt(2)-(int)b.charAt(2);
			}
			
			
		}
	}
}
