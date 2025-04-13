//342. Power of Four
//Solved
//Easy
//Topics
//Companies
//Given an integer n, return true if it is a power of four. Otherwise, return false.
//
//An integer n is a power of four, if there exists an integer x such that n == 4x.
//
// 
//
//Example 1:
//
//Input: n = 16
//Output: true
//Example 2:
//
//Input: n = 5
//Output: false
//Example 3:
//
//Input: n = 1
//Output: true
// 
//
//Constraints:
//
//-231 <= n <= 231 - 1
// 
//
//Follow up: Could you solve it without loops/recursion?



package Maths;

public class PowerOfFour_342 {
//	brute force approch :
//	repeated division :
//	we first handle edge case where input if in negative return faslse;
//	other wise we will create a while loop untill n!=1 :
//	inside while loop we check n%4==0 if its is
//	we will divide n by 4 other wise we return faalse

//	time complexity:O(n);
//	space complexity:O(1);
	public static boolean isPowerOfFourBruteForce(int n) {
	      if(n<=0)return false;
	        while(n!=1){
	            if(n%4==0){
	                n=n/4;
	            }else{
	                return false;
	            }
	        }
	        return true;
	    }
	
	
//	Recursion approch :
//	Follow UP REcursion:
//	we will check if input is 1 return true;
//	check if input is <=0 return false;
//	check if n %4 !=0 return false;
//	recusion call (n/4)
//	time complexity:O(n);
//	space complexity:O(n);
	public static boolean isPowerOfFourRecursion(int n) {
	    if(n==1) return true;
	    if(n<=0) return false;
	    if(n%4!=0) return false;
	    return isPowerOfFourRecursion(n/4);
	}
	
	
	
//	better approch :
//	we can use log of the number to find also log 4 
//	if its a integer its true other wise false;
//	time complexity:O(1);
//	space complexity:O(1);
	public static boolean isPowerOfFourBetter(int n) {
		double log4 = Math.log(n)/Math.log(4);
		return (log4%1.0)==0;
	}
	    

	
	    
	    
	public static void main(String[] args) {
		
		//Example 1:

		int n1 = 16;
		boolean output1=true;
		
		//Example 2:
		
		int n2=5;
		boolean output2=false;

		//Example 3:
		
		int n3=1;
		boolean output3=true;
		
		
		System.out.println("Brute Force Approch :");
		
		boolean ans1=isPowerOfFourBruteForce(n1);
		boolean ans2=isPowerOfFourBruteForce(n2);
		boolean ans3=isPowerOfFourBruteForce(n3);
		
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
		
		ans1=isPowerOfFourBruteForce(n1);
		ans2=isPowerOfFourBruteForce(n2);
		ans3=isPowerOfFourBruteForce(n3);
		
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
		
		ans1=isPowerOfFourBetter(n1);
		ans2=isPowerOfFourBetter(n2);
		ans3=isPowerOfFourBetter(n3);
		
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
