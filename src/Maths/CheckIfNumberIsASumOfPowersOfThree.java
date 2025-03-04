//1780. Check if Number is a Sum of Powers of Three
//Medium
//Topics
//Companies
//Hint
//Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
//
//An integer y is a power of three if there exists an integer x such that y == 3x.
//
// 
//5
//Example 1:
//
//Input: n = 12
//Output: true
//Explanation: 12 = 31 + 32
//Example 2:
//
//Input: n = 91
//Output: true
//Explanation: 91 = 30 + 32 + 34
//Example 3:
//
//Input: n = 21
//Output: false
// 
//
//Constraints:
//
//1 <= n <= 107

package Maths;

public class CheckIfNumberIsASumOfPowersOfThree {	
	
//	approch :
//	powers of 3 form 1  till 10^7
//	3 ^ 0 1.0
//	3 ^ 1 3.0
//	3 ^ 2 9.0
//	3 ^ 3 27.0
//	3 ^ 4 81.0
//	3 ^ 5 243.0
//	3 ^ 6 729.0
//	3 ^ 7 2187.0
//	3 ^ 8 6561.0
//	3 ^ 9 19683.0
//	3 ^ 10 59049.0
//	3 ^ 11 177147.0
//	3 ^ 12 531441.0
//	3 ^ 13 1594323.0
//	3 ^ 14 4782969.0
//	3 ^ 15 1.4348907E7
//	according tp constrain the n<= 10^7 
//	so the highest number which we can achieve in 3^x = 1.4348907E7
//	means we does not exceed with this number 
//	now the problem is we need tp check wheater a number can be present in sum of power of 3 
//	we can do it by calculating the power of 3 ^ 15 and check if we substract it with original number 
//	willl  it become zero if yes then return true other 
//	wise substract the current 3^x from n and decrease the power 
//	and check again do it till power reaches 0 and it substrac
//	Time complexity : O(n) or O(1)
//	Space complexity : O(1)
	 public static boolean checkPowersOfThree(int n) {
		 int x=3;
		 for(int i =15;i>=0;i--) {
			 int pow= (int)Math.pow(x,i);
			 int sub =n-pow;
			 if(sub>=0) {
				 n=n-pow;
			 }
		 }
		 return n==0;
		 
	    }
	 
	 
	 
	public static void main(String[] args) {
		//Example 1:
		
		int n1 = 12;
		boolean output1=true;
		
		//Example 2:
		
		int n2 = 91;
		boolean output2=true;
		
		//Example 3:
		
		int n3 = 21;
		boolean output3=false;
		
		System.out.println("best  Approch ");
    	boolean  ans1 = checkPowersOfThree(n1);
    	boolean ans2 = checkPowersOfThree(n2);
    	boolean ans3 = checkPowersOfThree(n3);
    	if(output1== ans1) {
    		System.out.println("Case 1 Passed ");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Output : "+output1);
    		System.out.println("Your Output : "+ans1);
    	}
    	if(output2== ans2) {
    		System.out.println("Case 2 Passed ");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Output : "+output2);
    		System.out.println("Your Output : "+ans2);
    	}
    	if(output3== ans3) {
    		System.out.println("Case 3 Passed ");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Output : "+output3);
    		System.out.println("Your Output : "+ans3);
    	}
	}
}
