//1922. Count Good Numbers
//Medium
//Topics
//Companies
//Hint
//A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
//
//For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
//Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
//
//A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
//
// 
//
//Example 1:
//
//Input: n = 1
//Output: 5
//Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
//Example 2:
//
//Input: n = 4
//Output: 400
//Example 3:
//
//Input: n = 50
//Output: 564908303
// 
//
//Constraints:
//
//1 <= n <= 1015

package Recursion;

public class CountGoodNumbers_1922 {
//	brute force maths approch:
//	 we can find answer by the formula
//	where we know we can put even elements at event places
//	and prime elements at prime places 
//	now we can find  how many even places are there and odd places are there 
//	if n  is even then odd , even are n/2
//	if n is odd then odd = n/2+1 , even = n/2;
//	now we can find how many combination of prime numbers = 2,3,5,7 can be place at odd places 
//	by 4^odd index count
//	similarly even place element can be : 0,2,4,6,8
//	count = 5^even index count
//	now  just multiply both  
//	we get our answer but we need to mod is by 10^9+7
//	this is our answer but this will take a lot of time in this contrain
//	time complexity : O(n)
	
	 public static int countGoodNumbers(long n) {
		 long evenCount =0;
		 long oddCount=0;
		 long MOD= 1000000007L;
		 if(n%2==0) {
			 evenCount= n/2L;
			 oddCount= n/2L;
		 }else {
			 evenCount = n/2L;
			 oddCount= (n/2L)+1;
		 }
		 long evenplaces= expo(4,evenCount);
		 long oddplaces= expo(5,oddCount);
		 long res= (evenplaces*oddplaces)%MOD;
		 return (int)res;
	    }
	 
	 public static long expo(long base, long power) {
		 long res=1;		 
		 long MOD= 1000000007L;
		 for(long i=0;i<power;i++) {
			 res= (res*base)%MOD;
		 }
		 return res;
	 }

	public static void main(String[] args) {
		
		
		//Example 1:

		long  n1 = 1;
		int output1=5;
		

		//Example 2:

		long  n2 = 4;
		int output2=400;

		//Example 3:

		long  n3 = 50;
		int output3=564908303;
		
		
		
		

	}

}
