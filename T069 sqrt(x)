public class Solution {
    public int mySqrt(int x) {
        if(x==0||x==1)
			return x;
		if(x>=2147395600)
			return 46340;
		int left=0;
		int right=Math.min(46340, x/2+1);
		
		
		while(true){
			int middle=left+(right-left)/2;
			
			int result=middle*middle;
			if(result<x){
				left=middle;
			}else if(result>x){
				right=middle;
			}else return middle;
			
			if(left+1==right)
				return left;
			
		}
    }
}
