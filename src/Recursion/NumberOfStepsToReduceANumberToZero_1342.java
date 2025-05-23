//1342. Number of Steps to Reduce a Number to Zero
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an integer num, return the number of steps to reduce it to zero.
//
//In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
//
// 
//
//Example 1:
//
//Input: num = 14
//Output: 6
//Explanation: 
//Step 1) 14 is even; divide by 2 and obtain 7. 
//Step 2) 7 is odd; subtract 1 and obtain 6.
//Step 3) 6 is even; divide by 2 and obtain 3. 
//Step 4) 3 is odd; subtract 1 and obtain 2. 
//Step 5) 2 is even; divide by 2 and obtain 1. 
//Step 6) 1 is odd; subtract 1 and obtain 0.
//Example 2:
//
//Input: num = 8
//Output: 4
//Explanation: 
//Step 1) 8 is even; divide by 2 and obtain 4. 
//Step 2) 4 is even; divide by 2 and obtain 2. 
//Step 3) 2 is even; divide by 2 and obtain 1. 
//Step 4) 1 is odd; subtract 1 and obtain 0.
//Example 3:
//
//Input: num = 123
//Output: 12
// 
//
//Constraints:
//
//0 <= num <= 106
package Recursion;

public class NumberOfStepsToReduceANumberToZero_1342 {

//	iterative Approch :
//	time complexity :O(n)
//	Space complexity :O(1)
	public static int numberOfStepsIterative(int num) {
		int counter=0;
		while(num!=0) {
			if(num%2==0) {
				num/=2;
			}else {
				num--;
			}
			counter++;
		}
		return counter;
		
	}
	
//	Recursion :
//	time complexity :O(n)
//	Space complexity :O(n)
	public static int numberOfStepsRec(int num) {
		if(num==0) {
			return 0;
		}
		if(num%2==0) {
			return 1+numberOfStepsRec(num/2);
		}else {
			return 1+numberOfStepsRec(num-1);			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		//Example 1:

		int num1 = 14, output1=6;
		
		//Example 2:

		int num2 = 8, output2=4;
		
		//Example 3:
		
		int num3 = 123, output3=12;
		
		System.out.println("Iterative Approch :");
		
		int ans1=numberOfStepsIterative(num1);
		int ans2=numberOfStepsIterative(num2);
		int ans3=numberOfStepsIterative(num3);
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ ans3);
			System.out.println("Actual Output :"+ output3);			
		}
		
		System.out.println("Recursion Approch :");
		
		ans1=numberOfStepsRec(num1);
		ans2=numberOfStepsRec(num2);
		ans3=numberOfStepsRec(num3);
		
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
		if(output3==ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ ans3);
			System.out.println("Actual Output :"+ output3);			
		}
		
		
		
	}

}
