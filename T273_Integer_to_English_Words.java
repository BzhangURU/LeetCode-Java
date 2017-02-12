public class Solution {
    public String numberToWords(int num) {
        String[] num2str=new String[20];
        num2str[0]="Zero";
        num2str[1]="One";
        num2str[2]="Two";
        num2str[3]="Three";
        num2str[4]="Four";
        num2str[5]="Five";
        num2str[6]="Six";
        num2str[7]="Seven";
        num2str[8]="Eight";
        num2str[9]="Nine";
        num2str[10]="Ten";
        num2str[11]="Eleven";
        num2str[12]="Twelve";
        num2str[13]="Thirteen";
        num2str[14]="Fourteen";
        num2str[15]="Fifteen";
        num2str[16]="Sixteen";
        num2str[17]="Seventeen";
        num2str[18]="Eighteen";
        num2str[19]="Nineteen";
        
        String[] ten2str=new String[10];
        ten2str[0]="Zero";
        ten2str[1]="Ten";
        ten2str[2]="Twenty";
        ten2str[3]="Thirty";
        ten2str[4]="Forty";
        ten2str[5]="Fifty";
        ten2str[6]="Sixty";
        ten2str[7]="Seventy";
        ten2str[8]="Eighty";
        ten2str[9]="Ninety";
        
        if(num==0)
        	return "Zero";
        else{
        	StringBuilder builder=new StringBuilder();
	        if(num>=1000000000){
	        	builder.append(number_less1000(num/1000000000,num2str,ten2str)+"Billion ");
	        	num-=(num/1000000000)*1000000000;
	        }
	        if(num>=1000000){
	        	builder.append(number_less1000(num/1000000,num2str,ten2str)+"Million ");
	        	num-=(num/1000000)*1000000;
	        }
	        if(num>=1000){
	        	builder.append(number_less1000(num/1000,num2str,ten2str)+"Thousand ");
	        	num-=(num/1000)*1000;
	        }
	        if(num>0){
	        	builder.append(number_less1000(num,num2str,ten2str));
	        }
	        builder.deleteCharAt(builder.length()-1);
	        return builder.toString();
        }
    }
	public String number_less1000(int num,String[] num2str,String[] ten2str) {
        StringBuilder builder=new StringBuilder();
		if(num>=100){
			int digit=num/100;
			builder.append(num2str[digit]);
			builder.append(" Hundred ");
			num-=(num/100)*100;
		}
		if(num>=1&&num<20){
			builder.append(num2str[num]+" ");
		}else if(num>=20){
			int ten=num/10;
			builder.append(ten2str[ten]+" ");
			if(num>(num/10)*10)
				builder.append(num2str[num-(num/10)*10]+" ");
		}
		return builder.toString();
		
		
    }
}
