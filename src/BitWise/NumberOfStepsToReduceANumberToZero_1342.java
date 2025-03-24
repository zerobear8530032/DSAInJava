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

package BitWise;

public class NumberOfStepsToReduceANumberToZero_1342 {	
	
//	brute force approch :
//	we can just iterate over num !=0]
//	if its even we n/2 other wise n-1
//	repeat while counting  operations
//	last return it
//	time complexity :O( log n)
//	space complexity : O(1)
	
	 public static int numberOfStepsBruteForce(int num) {
		 int ans =0;
		 while(num!=0) {
			 if(num%2==0) {
				 num/=2;
			 }else {
				 num-=1;
			 }
			 ans++;
		 }
		 return ans;
	    }

//	Better force approch :
//	we can just iterate over num !=0]
//	if its even we n>>1 other wise n-1
//	repeat while counting  operations
//	last return it
//	time complexity :O( log n)
//	space complexity : O(1)
	 public static int numberOfStepsBetter(int num) {
		 int ans =0;
		 while(num!=0) {
			 if(num%2==0) {
				 num=num>>1;
			 }else {
				 num-=1;
			 }
			 ans++;
		 }
		 return ans;
	 }
//	Best force approch :
//	we can just iterate over num !=0]
//	if its even we n>>1 other wise n-1
//	repeat while counting  operations
//	last return it
//	time complexity :O( 1)
//	space complexity : O(1)
	 public static int numberOfStepsBest(int num) {
		 if (num == 0) return 0; // Edge case
		 return Integer.toBinaryString(num).length() - 1 + Integer.bitCount(num);
	 }
	
public static void main(String[] args) {

	//Example 1:

	int  num1 = 14;
	int output1=6;
	

	//Example 2:
	
	int  num2 = 8;
	int output2=4;


	//Example 3:

	int  num3 = 123;
	int output3=12;
	
	System.out.println("Brute Force Approch ");
	
	int ans1= numberOfStepsBetter(num1);	
	int ans2= numberOfStepsBetter(num2);	
	int ans3= numberOfStepsBetter(num3);	
	
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
	
	
	System.out.println("Better Approch ");
	
	
	ans1= numberOfStepsBetter(num1);	
	ans2= numberOfStepsBetter(num2);	
	ans3= numberOfStepsBetter(num3);	
	
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
	ans1= numberOfStepsBest(num1);	
	ans2= numberOfStepsBest(num2);	
	ans3= numberOfStepsBest(num3);	
	
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

}
}


