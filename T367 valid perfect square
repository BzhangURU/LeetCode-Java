public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==0||num==1)
			return true;
		if(num>2147395600)
			return false;
		if(num==2147395600)
			return true;//46340;
		int left=0;
		int right=Math.min(46340, num/2+1);
		
		
		while(true){
			int middle=left+(right-left)/2;
			
			int result=middle*middle;
			if(result<num){
				left=middle;
			}else if(result>num){
				right=middle;
			}else return true;
			
			if(left+1==right)
				return false;
			
		}
    }
}
