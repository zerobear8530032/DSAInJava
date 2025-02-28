//Objective
//Today, we are learning about an algorithmic concept called recursion. Check out the Tutorial tab for learning materials and an instructional video.
//
//Recursive Method for Calculating Factorial
//
//Function Description
//Complete the factorial function in the editor below. Be sure to use recursion.
//
//factorial has the following paramter:
//
//int n: an integer
//Returns
//
//int: the factorial of 
//Note: If you fail to use recursion or fail to name your recursive function factorial or Factorial, you will get a score of .
//
//Input Format
//
//A single integer,  (the argument to pass to factorial).
//
//Constraints
//
//Your submission must contain a recursive function named factorial.
//Sample Input
//
//3
//Sample Output
//
//6
//Explanation
//
//Consider the following steps. After the recursive calls from step 1 to 3, results are accumulated from step 3 to 1.
//



package Recursion;

public class CalculateFactorial {
	
//	iterative approch :
	public static int factorial(int n) {
		if(n<0) {
			return -1;
		}
		if(n==0) {
			return 1;
		}
		int fact=1;
		for(int i=1;i<=n;i++) {
			fact=fact*i;		
		}
		return fact;
	}
	
//	Recursion approch :
	public static int factorialRec(int n) {
		if(n<0) {
			return -1;
		}
		
		if(n<=1) {
			return 1;
		}
		
		
		return n*factorialRec(n-1);
		
	}
	

	public static void main(String[] args) {
		
		int n1=3, output1=6;
		int n2=5 , output2=120;
		
		System.out.println("Iterative Approch :");
		
		
		int ans1=factorial(n1);    	
		int ans2=factorial(n2);    	
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Your Output :"+ans1);
    		System.out.println("Actual Output :"+output1);
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Your Output :"+ans2);
    		System.out.println("Actual Output :"+output2);
    	}System.out.println("Recursion Approch :");
    	
    	ans1=factorialRec(n1);    	
    	ans2=factorialRec(n2);    	
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Your Output :"+ans1);
    		System.out.println("Actual Output :"+output1);
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Your Output :"+ans2);
    		System.out.println("Actual Output :"+output2);
    	}
    	
		

	}

}
