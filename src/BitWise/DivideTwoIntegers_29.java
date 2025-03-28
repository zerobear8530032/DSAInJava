//29. Divide Two Integers
//Attempted
//Medium
//Topics
//Companies
//Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
//
//The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
//
//Return the quotient after dividing dividend by divisor.
//
//Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
//
// 
//
//Example 1:
//
//Input: dividend = 10, divisor = 3
//Output: 3
//Explanation: 10/3 = 3.33333.. which is truncated to 3.
//Example 2:
//
//Input: dividend = 7, divisor = -3
//Output: -2
//Explanation: 7/-3 = -2.33333.. which is truncated to -2.
// 
//
//Constraints:
//
//-231 <= dividend, divisor <= 231 - 1
//divisor != 0

package BitWise;

public class DivideTwoIntegers_29 {
//	this approch is invalid because its not allowed
//	brute force :
//	using simple division there is a catch the integer store only 32 bits 
//	so if we do -2147483648/-1 : 2147483648 which is not in range of the number
//	time complexity : O(1)
//	space complexity : O(1)
	public static  int divideBruteForce(int dividend, int divisor) {
		 long x=dividend;
	     long y=divisor;
	     long ans =  (long)dividend/(long)divisor;
	     if(ans==2147483648L) {
	    	 return (int)(ans-1);	    	 
	     }
	     return (int)ans;
    }
//	this is valid 
//	Better :
//	we can repeatedly substract the divisor from divident until divisor < divident 
//	and return count
//	edge case check signs of integers because it can mess up the code
//	time complexity : O(log n)
//	space complexity : O(1)
	public static  int divideBetter(int dividend, int divisor) {		
		        // Edge case: Handle overflow
		        if (dividend == Integer.MIN_VALUE && divisor == -1) {
		            return Integer.MAX_VALUE; // 2^31 - 1
		        }

		        // Determine the sign of the result
		        boolean negative = (dividend < 0) ^ (divisor < 0); // XOR to check if signs differ

		        // Convert to positive (use long to handle edge cases safely)
		        long dividendL = Math.abs((long) dividend);
		        long divisorL = Math.abs((long) divisor);

		        int quotient = 0;
		        while (dividendL >= divisorL) {
		            long temp = divisorL, multiple = 1;
		            while (dividendL >= (temp << 1)) { // Double divisor until it exceeds dividend
		                temp <<= 1;
		                multiple <<= 1;
		            }
		            dividendL -= temp;
		            quotient += multiple;
		        }

		        return negative ? -quotient : quotient;
		    }


	public static void main(String[] args) {
		//Example 1:

		int  dividend1 = 10, divisor1 = 3;
		int output1=3;

		//Example 2:

		int dividend2 = 7, divisor2 = -3;
		int output2=-2;
		
		//Example 3:
		
		int dividend3 = -2147483648, divisor3 = -1;
		int output3=2147483647;
		
		//Example 4:
		
		int dividend4 = -2147483648, divisor4 = 1;
		int output4=-2147483648;
		
		
		System.out.println("Brute Force Approch :");
    	
    	int ans1= divideBruteForce(dividend1,divisor1);
    	int ans2= divideBruteForce(dividend2,divisor2);
    	int ans3= divideBruteForce(dividend3,divisor3);
    	int ans4= divideBruteForce(dividend4,divisor4);
    	
    	if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		if(ans4==output4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Expected Ouput :"+ (output4));
			System.out.println("Your Answer :"+ (ans4));
		}
		
		
		System.out.println("Better Approch :");
		ans1= divideBetter(dividend1,divisor1);
    	ans2= divideBetter(dividend2,divisor2);
    	ans3= divideBetter(dividend3,divisor3);
    	ans4= divideBetter(dividend4,divisor4);
    	
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		if(ans4==output4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Expected Ouput :"+ (output4));
			System.out.println("Your Answer :"+ (ans4));
		}
		
		System.out.println("BestApproch :");
		ans1= divideBruteForce(dividend1,divisor1);
		ans2= divideBruteForce(dividend2,divisor2);
		ans3= divideBruteForce(dividend3,divisor3);
		ans4= divideBruteForce(dividend4,divisor4);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		if(ans4==output4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Expected Ouput :"+ (output4));
			System.out.println("Your Answer :"+ (ans4));
		}
		



	}

}
