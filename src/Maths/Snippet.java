//Armstrong Numbers
//	Difficulty: EasyAccuracy: 49.88%Submissions: 177K+Points: 2
//	You are given a 3-digit number n, Find whether it is an Armstrong number or not.
//	
//	An Armstrong number of three digits is a number such that the sum of the cubes of its digits is equal to the number itself. 371 is an Armstrong number since 33 + 73 + 13 = 371. 
//	
//	Examples:
//	
//	Input: n = 153
//	Output: true
//	Explanation: 153 is an Armstrong number since 13 + 53 + 33 = 153. 
//	Input: n = 372
//	Output: false
//	Explanation: 372 is not an Armstrong number since 33 + 73 + 23 = 378. 
//	Input: n = 100
//	Output: false
//	Explanation: 100 is not an Armstrong number since 13 + 03 + 03 = 1. 
//	Constraints:
//	100 ≤ n <1000 


package Maths;

public class Snippet {
//	assign x=n
//	take mod of x by 10 and take cube of x and sum it
//	then divide x by 10 until it reached 0 repeat this 
//	until x==0
//	check sum== n
//	time complexity :O(n)
//	space complexity :O(1)
	 public static boolean armstrongNumber(int n) {
	        // code here
	        int x=n;
	        int sum=0;
	        while(x>0){
	            int r = x%10;
	            sum+= (r*r*r);
	            x/=10;
	        }
	        return n==sum;
	    }
	public static void main(String[] args) {

//		Examples 1:

		int n1 = 153;
		boolean output1=true;

//		Examples 2:
		
		int n2 = 372;
		boolean output2=false;
		
//		Examples 3:
		
		int n3 = 100;
		boolean output3=false;

		
		boolean ans1=armstrongNumber(n1);
		boolean ans2=armstrongNumber(n2);
		boolean ans3=armstrongNumber(n3);
		
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

