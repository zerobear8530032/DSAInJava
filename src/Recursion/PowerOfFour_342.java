//326. Power of Three
//Solved
//Easy
//Topics
//Companies
//Given an integer n, return true if it is a power of three. Otherwise, return false.
//
//An integer n is a power of three, if there exists an integer x such that n == 3x.
//
// 
//
//Example 1:
//
//Input: n = 27
//Output: true
//Explanation: 27 = 33
//Example 2:
//
//Input: n = 0
//Output: false
//Explanation: There is no x where 3x = 0.
//Example 3:
//
//Input: n = -1
//Output: false
//Explanation: There is no x where 3x = (-1).
// 
//
//Constraints:
//
//-231 <= n <= 231 - 1
// 
//
//Follow up: Could you solve it without loops/recursion?


package Recursion;


public class PowerOfFour_342{
//	Iterative approch :
//	divide the number by 3till  it return 1 if it return 1 return true if its not divisible return false;
//	 Time Complexity:O(n)
//	 Space Complexity:O(1)
	
	 public static boolean isPowerOfFourIterative(int n) {
		 if(n==0){return false;}
		 while(n!=1) {
			if(n%3!=0) {
				return false;
			}
			n=n/3;
		 }
	      return true;
	    }
	 
//	Recursion approch :
//	divide the number by 3 till it return 1 if it return 1 return true if its not divisible return false;
//	 Time Complexity:O(n)
//	 Space Complexity:O(n)
	 public static boolean isPowerOfFourRecursion(int n) {
		 if(n==0){return false;}
		 if(n==1) {return true;}
		 if(n%3!=0) {return false;}
		 return isPowerOfFourRecursion(n/3);		 
	 }
	 
//	follow up approch :
//	 here we take log of base of 3 and check its a whole number or not it yes return true else false
//	 to calculate log of 3 base we use log10(n)/log10(3)
//	 Time Complexity:O(1)
//	 Space Complexity:O(1)

	 public static boolean isPowerOfFourOptimize(int n) {
		 if(n<=0) return false;
		 double logn =Math.log10(n);
		 double log4 =Math.log10(4);
		 double floor=Math.floor(logn/log4);
		 double ceil =Math.ceil(logn/log4);
		 return floor==ceil;
	 }
	  

	public static void main(String[] args) {
		//Example 1:
		
		int n1 = 27;
		boolean output1=true;
		
		//Example 2:
		
		int n2= 0;
		boolean output2=false;
		
		//Example 3:
		
		int n3 = -1;
		boolean output3=false;
		
		boolean ans1=isPowerOfFourIterative(n1);
		boolean ans2=isPowerOfFourIterative(n2);
		boolean ans3=isPowerOfFourIterative(n3);
		
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
		
		ans1=isPowerOfFourRecursion(n1);
		ans2=isPowerOfFourRecursion(n2);
		ans3=isPowerOfFourRecursion(n3);
		
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
		
		ans1=isPowerOfFourOptimize(n1);
		ans2=isPowerOfFourOptimize(n2);
		ans3=isPowerOfFourOptimize(n3);
		
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
