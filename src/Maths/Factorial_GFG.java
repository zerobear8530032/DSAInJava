//Factorial
//Difficulty: BasicAccuracy: 40.58%Submissions: 157K+Points: 1
//Given a positive integer, n. Find the factorial of n.
//
//Examples :
//
//Input: n = 5
//Output: 120
//Explanation: 1 x 2 x 3 x 4 x 5 = 120
//Input: n = 4
//Output: 24
//Explanation: 1 x 2 x 3 x 4 = 24
//Constraints:
//0 <= n <= 12


package Maths;

public class Factorial_GFG {
	
	
//	recursion:
//	time complexity : O(n)
//	space complexity : O(n)
	 static int factorialRec(int n) {
	        if(n==0) return 1;
	        if(n<0) return -1;
	        return n*factorialRec(n-1);
	    }
	 
//	iterative:
//	time complexity : O(n)
//	space complexity : O(n)
	 static int factorial(int n) {
		 if(n<0) return -1;
		 int prod=1;
		 for(int i =2;i<=n;i++) {
			 prod*=i;
		 }
		 return prod;
	 }
	
	public static void main(String[] args) {
		
//		Example 1 :
		
		int n1=5;
		int output1=120;
		
//		Example 3 :

		int n2=4;
		int output2=24;
		
//		Example 3 :
		
		int n3=3;
		int output3=6;
		
		
		System.out.println("Recursion Approch :");
		
		int ans1=factorialRec(n1);
		int ans2=factorialRec(n2);
		int ans3=factorialRec(n3);
		
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
		
		System.out.println("Better Approch :");
		
		ans1=factorial(n1);
		ans2=factorial(n2);
		ans3=factorial(n3);
		
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
