//Question link :https://www.geeksforgeeks.org/product-2-numbers-using-recursion/
//Product of 2 Numbers using Recursion
//Last Updated : 20 Feb, 2023
//Given two numbers x and y find the product using recursion.
//
//Examples : 
//
//Input : x = 5, y = 2
//Output : 10
//
//Input : x = 100, y = 5
//Output : 500
//Method 
//1) If x is less than y, swap the two variables value 
//2) Recursively find y times the sum of x 
//3) If any of them become zero, return 0 

package Recursion;

public class ProductOfTwoNumberUsingRecursion {
//	using iterative approch :
	public static int product_iterative(int x,int y) {
		int prod=0;
		for(int i =0;i<y;i++) {
			prod+=x;
		}
		return prod;
	}

	public static void main(String[] args) {
		int x1 = 5, y1 = 2;
		int output1=10;
		
		int x2 = 100, y2 = 5;
		int output2=500;		

		int ans1=product_iterative(x1,y1);
		int ans2=product_iterative(x2,y2);
		
		System.out.println("Iterative Approch :");
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		
		System.out.println("Recursion Approch :");
		
		ans1=product_iterative(x1,y1);
		ans2=product_iterative(x2,y2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}


	}

}
