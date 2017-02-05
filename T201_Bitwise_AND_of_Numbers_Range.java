public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(n-m<4){
          int num=m;
              for(int i=m+1;i<=n&&i>=0;i++){
                num=num&i;
              }
              return num;
        }else{
          int bit=0;
          int dif=n-m;
          for(int i=0;i<31;i++){
            if((dif&1)==1)
              bit=i;
            dif=dif>>1;
          }

          int interval=(1<<(bit));
          int result=m&rangeBitwiseAnd(m+interval,n);
          result=result>>bit;
          result=result<<bit;
          return result;
        }
        
    }
}
