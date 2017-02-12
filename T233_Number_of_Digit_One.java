public class Solution {
    public int countDigitOne(int n) {
		if(n<=0)
			return 0;
		//f(9999)=f(999)*10+1000
		long[] i_9s=new long[11];
		i_9s[0]=0;
		i_9s[1]=1;
		
		//get 10^i  given i
		long[] ten_pow_i=new long[11];
		ten_pow_i[0]=1;
		ten_pow_i[1]=10;
		for(int i=2;i<=10;i++){
			i_9s[i]=i_9s[i-1]*10+ten_pow_i[i-1];
			ten_pow_i[i]=ten_pow_i[i-1]*10;
		}
		
		long N=(long)n;
		
		long count=0;
		long digit;
		long remaining;
		for(int bit=9;bit>=0;bit--){
			digit=N/ten_pow_i[bit];
			remaining=N-digit*ten_pow_i[bit];
			N=remaining;
			if(digit!=0){
				if(digit!=1)
					count+=count_digit_follow_i0s(digit,bit,i_9s,ten_pow_i);
				else count+=count_digit_follow_i0s(digit,bit,i_9s,ten_pow_i)+remaining;
			}
		}
		
		return (int)count;
		
		
    }
	
	//count 5000->(5,3)    700000->(7,5)  1<=digit<=9     0<=num_zeros<=9
	public long count_digit_follow_i0s(long digit,int num_zeros,long[] i_9s,long[] ten_pow_i){
		if(digit==1){
			return i_9s[num_zeros]+1;
		}else{
			//for example 5000
			//0   0-999
			//1   0-999
			//...
			//4   0-999
			//totally 5 * 0-999 and   1 *1000
			return digit*i_9s[num_zeros]+ten_pow_i[num_zeros];
		}
	}
}
