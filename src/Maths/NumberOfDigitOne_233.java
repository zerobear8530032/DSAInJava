//233. Number of Digit One
//Hard
//Topics
//Companies
//Hint
//Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
//
// 
//
//Example 1:
//
//Input: n = 13
//Output: 6
//Example 2:
//
//Input: n = 0
//Output: 0
// 
//
//Constraints:
//
//0 <= n <= 109


package Maths;

public class NumberOfDigitOne_233 {
	public static int countDigitOne(int n) {
	    int ans =0;
	    for(long i=1;i<=n;i++){
	        long x=i;
	        while(x!=0){
	            long r= x%10;
	            if(r==1){
	                ans++;
	            }
	            x=x/10;
	        }

	    }
	    return ans;
	    }
	
	public static int countOne(int s, int e) {
		int ans =0;
		for(int i =s;i<=e;i++) {
			long x=i;
	        while(x!=0){
	            long r= x%10;
	            if(r==1){
	                ans++;
	            }
	            x=x/10;
	        }
		}
		return ans;
	}

	public static void main(String[] args) {
		
		
		//Example 1:

		int n1 = 13;
		int output1=6;

		//Example 2:

		int n2 = 0;
		int output2=0;

		//Example 3:
		
		int n3 = 10000;
		int output3=46000;
		
		//Example 4:
		
		int n2 = 0;
		int output2=0;
		

		

	}

}
