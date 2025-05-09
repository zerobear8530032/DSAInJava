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
		
		System.out.println("Brute Force  Approch : ");
		
		int ans1=countDigitOne(n1);
		int ans2=countDigitOne(n2);
		int ans3=countDigitOne(n3);
		
		if(output1== ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2 ==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		

		

	}

}
