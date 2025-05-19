//N Digit numbers with digits in increasing order
//Difficulty: MediumAccuracy: 49.66%Submissions: 14K+Points: 4
//Given an integer n, print all the n digit numbers in increasing order, such that their digits are in strictly increasing order(from left to right).
//
//Example 1:
//
//Input:
//n = 1
//Output:
//0 1 2 3 4 5 6 7 8 9
//Explanation:
//Single digit numbers are considered to be 
//strictly increasing order.
//Example 2:
//
//Input:
//n = 2
//Output:
//12 13 14 15 16 17 18 19 23....79 89
//Explanation:
//For n = 2, the correct sequence is
//12 13 14 15 16 17 18 19 23 and so on 
//up to 89.
//Your Task:  
//You don't need to read input or print anything. Your task is to complete the function increasingNumbers() which takes an integer n as an input parameter and returns the list of numbers such that their digits are in strictly increasing order.
//
//Expected Time Complexity: O(9n)
//Expected Auxiliary Space: O(n)
//
//Constraints:
//1 <= n <= 9


package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NDigitNumbersWithDigitsInIncreasingOrder_GFG {
	
	public static List<Integer> increasinNumber(int n) {
		if(n==1) {
		List<Integer> res= new ArrayList();
		for(int i=0;i<=9;i++) {
			res.add(i);
			
		}
		return res;
		}
		List<Integer> res= increasingNumberHelper(n , 0);
		return res;
	}
	
	
	
	public static List<Integer> increasingNumberHelper(int n , int num) {
		int x= (int)Math.log10(num)+1;
		if(x==n) {
			List<Integer> res= new ArrayList();
			res.add(num);
			return res;
		}
		List<Integer> res= new ArrayList();
		for(int i =(num%10)+1;i<=9;i++) {
			res.addAll( increasingNumberHelper(n, num*10+i));
		}
		return res;
		
	}



	public static void main(String[] args) {
		//Example 1:

		int n1=1;
		List<Integer> output1= new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

		//Example 2:
		
		int n2=2;
		List<Integer> output2= new ArrayList(Arrays.asList(12, 13, 14, 15, 16, 17, 18, 19, 23, 24, 25, 26, 27, 28, 29, 34, 35, 36, 37, 38, 39, 45, 46, 47, 48, 49, 56, 57, 58, 59, 67, 68, 69, 78, 79, 89));
		
		
		System.out.println("Brute Force Approch :");
		
		List<Integer> ans1= increasinNumber(n1);
		List<Integer> ans2= increasinNumber(n2);
		
		if(ans1.equals(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(ans2.equals(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}


		
		


	}

}
