public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)
			return 0;
        int[] left_max=new int[prices.length];
        int[] right_max=new int[prices.length];
        
        
        
        int lowest_price=prices[0];
        int profit_left=0;
        for(int i=0;i<prices.length;i++){
        	
        	if(prices[i]<lowest_price)
        		lowest_price=prices[i];
        	
        	if(profit_left<prices[i]-lowest_price)
        		profit_left=prices[i]-lowest_price;
        	left_max[i]=profit_left;
        	
        	
        }
        int highest_price=prices[prices.length-1];
        int profit_right=0;
        for(int i=prices.length-1;i>=0;i--){
        	
        	if(prices[i]>highest_price)
        		highest_price=prices[i];
        	
        	if(profit_right<highest_price-prices[i])
        		profit_right=highest_price-prices[i];
        	right_max[i]=profit_right;
        	
        	
        }
        
        int result=0;
        for(int i=0;i<prices.length;i++){
        	if(result<left_max[i]+right_max[i])
        		result=left_max[i]+right_max[i];
        }
        
        return result;
    }
}
