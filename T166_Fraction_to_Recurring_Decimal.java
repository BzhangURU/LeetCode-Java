public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorl=(long)numerator;
		long denominatorl=(long)denominator;
		long int_result=numeratorl/denominatorl;
		long remaining=numeratorl-denominatorl*int_result;
		
		long digit=1;
		long single_number;
		HashMap<Long,Long> map=new HashMap<Long,Long>();
		if(remaining==0){
			return Long.toString(int_result);
		}else{
			StringBuilder builder=new StringBuilder();
			boolean add_negative=false;
			if(int_result==0&&((numeratorl>0&&denominatorl<0)||(numeratorl<0&&denominatorl>0))){
				builder.append('-');
				add_negative=true;
			}
			
			if(remaining<0)
				remaining=-remaining;
			if(denominatorl<0)
				denominatorl=-denominatorl;
			String str_of_int=Long.toString(int_result);
			builder.append(str_of_int);
			builder.append('.');
			
			//just follow the division rule
			while(remaining!=0){
				remaining*=10;
				
				if(map.containsKey(remaining)){
					long getdigit=map.get(remaining);
					if(add_negative==true)
						getdigit++;
					builder.insert(str_of_int.length()+(int)getdigit,'(');
					builder.append(')');
					return builder.toString();
				}
				single_number=remaining/denominatorl;
				map.put(remaining, digit);
				remaining=remaining-denominatorl*single_number;
				builder.append((char)('0'+single_number));
				digit++;
			}
			return builder.toString();
		}
    }
}
