//Questions link ://https://www.geeksforgeeks.org/sum-digit-number-using-recursion/
//Given a number, we need to find sum of its digits using recursion.
//Examples: 
// 
//
//Input : 12345
//Output : 15
//
//Input : 45632
//Output :20
//          
//
// 
//
//
//The step-by-step process for a better understanding of how the algorithm works. 
//Let the number be 12345. 
//Step 1-> 12345 % 10 which is equal-too 5 + ( send 12345/10 to next step ) 
//Step 2-> 1234 % 10 which is equal-too 4 + ( send 1234/10 to next step ) 
//Step 3-> 123 % 10 which is equal-too 3 + ( send 123/10 to next step ) 
//Step 4-> 12 % 10 which is equal-too 2 + ( send 12/10 to next step ) 
//Step 5-> 1 % 10 which is equal-too 1 + ( send 1/10 to next step ) 
//Step 6-> 0 algorithm stops 

package Recursion;

public class SumOfDigitOfANumberUsingRecursion_GFG {
//	iterative approch :
//	time complexity :O(n):
//	space complexity :O(1):
	
	public static int sumOfDigits(int x) {
		int sum =0;
		while(x!=0) {
			int rem = x%10;
			sum+=rem;
			x/=10;
		}
		return sum;
	}
	
	
//	Recursion approch :
//	time complexity :O(n):
//	space complexity :O(1):
	public static int sumOfDigitsRec(int x) {
		return sumOfDigitsHelper(x,0);
	}
	
	
	
	private static int sumOfDigitsHelper(int x, int currsum) {
		if(x==0) {
			return currsum;
		}
		currsum+= x%10;
		return sumOfDigitsHelper(x/10, currsum);
	}


	public static void main(String[] args) {
		
		
		int n1=12345;
		int output1=15;
		
		int n2= 45632;
		int output2=20;
		
		int ans1=sumOfDigits(n1);
		int ans2=sumOfDigits(n2);
		
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
		
		System.out.println("Recursion Approch ");
		
		ans1=sumOfDigitsRec(n1);
		ans2=sumOfDigitsRec(n2);
		
		
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
