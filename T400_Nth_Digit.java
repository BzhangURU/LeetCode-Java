public class Solution {
    public int findNthDigit(int n) {
        long n_long=(long)n;
		long num=1;
        long count=0;
        while(count+num*9*(long)Math.pow(10, num-1)<n_long){
        	count+=num*9*(long)Math.pow(10, num-1);
        	num++;
        }
        long number=(long)Math.pow(10, num-1)+(n_long-1-count)/num;
        long bit=(n-1-count)%num;
        return (int)((number%(long)Math.pow(10, num-bit))/(long)Math.pow(10, num-1-bit));
    }
}
