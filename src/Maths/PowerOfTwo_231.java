//231. Power of Two
//Solved
//Easy
//Topics
//Companies
//Given an integer n, return true if it is a power of two. Otherwise, return false.
//
//An integer n is a power of two, if there exists an integer x such that n == 2x.
//
// 
//
//Example 1:
//
//Input: n = 1
//Output: true
//Explanation: 20 = 1
//Example 2:
//
//Input: n = 16
//Output: true
//Explanation: 24 = 16
//Example 3:
//
//Input: n = 3
//Output: false
// 
//
//Constraints:
//
//-231 <= n <= 231 - 1
// 
//
//Follow up: Could you solve it without loops/recursion?

package Maths;

public class PowerOfTwo_231 {
	
//	brute force approch :
//	repeated division :
//	we first handle edge case where input if in negative return faslse;
//	other wise we will create a while loop untill n!=1 :
//	inside while loop we check n%4==0 if its is
//	we will divide n by 4 other wise we return faalse

//	time complexity:O(n);
//	space complexity:O(1);
	public static boolean isPowerOfTwoBruteForce(int n) {
	      if(n<=0)return false;
	        while(n!=1){
	            if(n%2==0){
	                n=n/2;
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
//	check if n %2 !=0 return false;
//	recusion call (n/2)
//	time complexity:O(n);
//	space complexity:O(n);
	public static boolean isPowerOfTwoRecursion(int n) {
	    if(n==1) return true;
	    if(n<=0) return false;
	    if(n%2!=0) return false;
	    return isPowerOfTwoRecursion(n/2);
	}
	
	
	
//	better approch :
//	we can use log of the number to find also log 4 
//	if its a integer its true other wise false;
//	time complexity:O(1);
//	space complexity:O(1);
	public static boolean isPowerOfTwoBetter(int n) {
		double log2 = Math.log(n)/Math.log(2);
		return (log2%1.0)==0;
	}
	    

	
	    
		public static void main(String[] args) {
			
			
			//Example 1:

			int n1 = 1;
			boolean output1=true;			

			//Example 2:

			int n2 = 16;
			boolean output2=true;

			//Example 3:

			int n3 = 3;
			boolean output3=false;

			
			System.out.println("Brute Force Approch :");
			
			boolean ans1=isPowerOfTwoBruteForce(n1);
			boolean ans2=isPowerOfTwoBruteForce(n2);
			boolean ans3=isPowerOfTwoBruteForce(n3);
			
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
			
			ans1=isPowerOfTwoRecursion(n1);
			ans2=isPowerOfTwoRecursion(n2);
			ans3=isPowerOfTwoRecursion(n3);
			
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
			
			ans1=isPowerOfTwoBetter(n1);
			ans2=isPowerOfTwoBetter(n2);
			ans3=isPowerOfTwoBetter(n3);
			
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

