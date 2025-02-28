//Question link :https://www.geeksforgeeks.org/sum-of-natural-numbers-using-recursion/
//Sum of natural numbers using recursion
//Last Updated : 17 Feb, 2023
//
//
//Given a number n, find sum of first n natural numbers. To calculate the sum, we will use a recursive function recur_sum().
//Examples : 
// 
//
//Input : 3
//Output : 6
//Explanation : 1 + 2 + 3 = 6
//
//Input : 5
//Output : 15
//Explanation : 1 + 2 + 3 + 4 + 5 = 15

package Recursion;


public class SumOfNaturalNumbersUsingRecursion_GFG {
//	Recursion approch :
//	time complexity :O(n)
//	space complexity :O(n)
	public static int sumOfDigitsRecursion(int n) {
		if(n==0) {
			return 0;
		}
		return n+sumOfDigitsRecursion(n-1);
	}
//	iterative approch :
//	time complexity :O(n)
//	space complexity :O(1)
	public static int sumOfDigitsIterative(int n) {
		int sum=0;
		for(int i =1;i<=n;i++) {
			sum+=i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		
		//Examples : 

		int num1= 3;
		int output1=6;

		int num2= 5;
		int output2=15;
		
		
		int ans1=sumOfDigitsIterative(num1);
		int ans2=sumOfDigitsIterative(num2);
		
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
		
		
		System.out.println("Recursion Approch :");
		
		ans1=sumOfDigitsRecursion(num1);
		ans2=sumOfDigitsRecursion(num2);
		
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

		
		
		
	}

}
