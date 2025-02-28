//231. Power of Two
//Solved
//Easy
//Topics
//Companies
//Given an integer n, return true if it is a power of two. Otherwise, return false.
//
//An integer n is a power of two, if there exists an integer x such that n == 2x.
//
// 
//
//Example 1:
//
//Input: n = 1
//Output: true
//Explanation: 20 = 1
//Example 2:
//
//Input: n = 16
//Output: true
//Explanation: 24 = 16
//Example 3:
//
//Input: n = 3
//Output: false
// 
//
//Constraints:
//
//-231 <= n <= 231 - 1
// 
//
//Follow up: Could you solve it without loops/recursion?

package Recursion;


public class PowerOfTwo_231 {
//	Iterative approch :
//	divide the number by 2 till it return 1 if it return 1 return true if its not divisible return false;
//	 Time Complexity:O(n)
//	 Space Complexity:O(1)
	
	 public static boolean isPowerOfTwoIterative(int n) {
		 if(n==0){return false;}
		 while(n!=1) {
			if(n%2!=0) {
				return false;
			}
			n=n/2;
		 }
	      return true;
	    }
	 
//	Recursion approch :
//	divide the number by 2 till it return 1 if it return 1 return true if its not divisible return false;
//	 Time Complexity:O(n)
//	 Space Complexity:O(n)
	 public static boolean isPowerOfTwoRecursion(int n) {
		 if(n==0){return false;}
		 if(n==1) {return true;}
		 if(n%2!=0) {return false;}
		 return isPowerOfTwoRecursion(n/2);		 
	 }
	 
//	follow up approch :
//	 approch uses bit manipulations 
//	  each square of of 2 contain a single bit of 1:
//	 2  00010
//	 4  00100
//	 8  01000
//	 16 10000
//	 if we substract them by 1 :
//	 1  00001
//	 3  00011
//	 7  00111
//	 15 01111	 
//	 if we take & of n & n-1 we will get 0 if the number is a multiple of 2
//	 2& 1=0
//	 4& 3=0
//	 8& 7=0
//	 16& 15=0
	 
//	 Time Complexity:O(1)
//	 Space Complexity:O(1)
	 public static boolean isPowerOfTwoBetterOptimize(int n) {
		 return n>0 && (n & (n-1))==0;
	 }
	 
	 
//	follow up approch :
//	 we can use log of a number base 2 if its a float number return false
//	 Time Complexity:O(1)
//	 Space Complexity:O(1)
	 public static boolean isPowerOfTwoOptimize(int n) {
		 
		 if(n<=0) return false;
		 double logn =Math.log10(n);
		 double log2 =Math.log10(2);
		 double floor=Math.floor(logn/log2);
		 double ceil =Math.ceil(logn/log2);
		 return floor==ceil;
	 }
	 

	public static void main(String[] args) {
		//Example 1:
		
		int n1 = 1;
		boolean output1=true;
		
		//Example 2:
		
		int n2= 16;
		boolean output2=true;
		
		//Example 3:
		
		int n3 = 3;
		boolean output3=false;
		
		boolean ans1=isPowerOfTwoIterative(n1);
		boolean ans2=isPowerOfTwoIterative(n2);
		boolean ans3=isPowerOfTwoIterative(n3);
		
		System.out.println("Iterative Approch :");
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
		
		System.out.println("Recursion Approch :");
		
		ans1=isPowerOfTwoRecursion(n1);
		ans2=isPowerOfTwoRecursion(n2);
		ans3=isPowerOfTwoRecursion(n3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
		System.out.println("Optimize Approch :");
		
		ans1=isPowerOfTwoOptimize(n1);
		ans2=isPowerOfTwoOptimize(n2);
		ans3=isPowerOfTwoOptimize(n3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
		System.out.println("Better Optimize Approch :");
		
		ans1=isPowerOfTwoBetterOptimize(n1);
		ans2=isPowerOfTwoBetterOptimize(n2);
		ans3=isPowerOfTwoBetterOptimize(n3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}

	}

}
