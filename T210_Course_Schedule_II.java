public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
		
		
		HashMap<Integer,HashSet<Integer>> begin2end=new HashMap<Integer,HashSet<Integer>>();
		HashMap<Integer,HashSet<Integer>> end2begin=new HashMap<Integer,HashSet<Integer>>();
		
		for(int i=0;i<prerequisites.length;i++){
			if(prerequisites[i][0]==prerequisites[i][1])
				return new int[0];
			
			if(begin2end.containsKey(prerequisites[i][1])){
				begin2end.get(prerequisites[i][1]).add(prerequisites[i][0]);
			}else{
				HashSet<Integer> set=new HashSet<Integer>();
				set.add(prerequisites[i][0]);
				begin2end.put(prerequisites[i][1], set);
			}
			
			if(end2begin.containsKey(prerequisites[i][0])){
				end2begin.get(prerequisites[i][0]).add(prerequisites[i][1]);
			}else{
				HashSet<Integer> set=new HashSet<Integer>();
				set.add(prerequisites[i][1]);
				end2begin.put(prerequisites[i][0], set);
			}
		}
		
		
		
		//nodes without incoming
		Queue<Integer> start_nodes=new LinkedList<Integer>();
		for(int i=0;i<numCourses;i++){
			if(!end2begin.containsKey(i))
				start_nodes.offer(i);
		}
		
		HashSet<Integer> already_finished_courses=new HashSet<Integer>();
		int result_index=0;
		int[] result=new int[numCourses];
		
		
		while(!start_nodes.isEmpty()){
			int node=start_nodes.poll();
			
			if(!already_finished_courses.contains(node)){
				already_finished_courses.add(node);
				result[result_index]=node;
				result_index++;
				
				
				if(begin2end.containsKey(node)){
					for(int endnode:begin2end.get(node)){
						end2begin.get(endnode).remove(node);
						if(end2begin.get(endnode).isEmpty()){
							end2begin.remove(endnode);
							start_nodes.offer(endnode);
						}
					}
					begin2end.remove(node);
				}
				
				
			}else{
				System.out.println("error1");
				return new int[0];
			}
			
			
		}
		
		
		//if graph is empty
		if(begin2end.isEmpty()){
			
			for(int i=0;i<numCourses;i++){
				if(!already_finished_courses.contains(i)){
					result[result_index]=i;
					result_index++;
				}
			}
			return result;
		}
		else return new int[0];
		
		
    }
}
