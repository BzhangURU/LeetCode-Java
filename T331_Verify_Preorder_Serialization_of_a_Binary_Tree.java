//my idea: 9,3,4,#,#,1,#,#,2,#,(6,#,#)
//my idea: 9,3,4,#,#,1,#,#,(2,#,#)
//my idea: 9,3,4,#,#,(1,#,#),#
//my idea: 9,3,(4,#,#),#,#
//my idea: 9,(3,#,#),#
//my idea: 9,#,#
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.length()==0)
			    return false;
        String[] strs=preorder.split(",");
        LinkedList<String> list=new LinkedList<String>();
        for(int i=0;i<strs.length;i++)
          list.add(strs[i]);
        while(list.size()>1){
          int num_pound=0;
          boolean find=false;
          for(int i=list.size()-1;i>=0;i--){
            if(list.get(i).equals("#")){
              num_pound++;
            }
            else{
              if(num_pound>=2){
                list.remove(i+2);
                list.remove(i);
                find=true;
                break;
              }
              num_pound=0;

            }
          }
          if(!find)
            return false;

        }
        if(list.get(0).equals("#"))
          return true;
        else return false;
        }
}
