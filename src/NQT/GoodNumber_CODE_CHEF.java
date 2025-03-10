//https://www.codechef.com/practice/course/tcs-nqt-questions/TCSNQTC/problems/TCSNQTCP05
//Good Number
//You are given a number 
//N
//N, and your task is to determine whether it is a "Good Number" or not. A Good Number is defined as a number that is divisible by the sum of its own digits. If the number is divisible by the sum of its digits, it is classified as Good, otherwise, it is classified as Bad.
//
//Input Format
//The first line of input will contain a single integer 
//T
//T, denoting the number of test cases.
//Each test case contains a single integer 
//N
//N, the number you need to check.
//Output Format
//For each test case, print "Good Number" if the number is a Good, otherwise print "Bad Number".
//
//Constraints
//1≤T≤100
//1≤T≤100
//1≤N≤106
//1≤N≤106
// 
//Sample 1:
//Input
//Output
//3
//18
//19
//21
//Good Number
//Bad Number
//Good Number
//Explanation:
//Test Case 1: For the first test case, the sum of digits of 18 is 1+8=9. Since 18÷9=2, 18 is a Good Number.
//Test Case 2: For the second test case, the sum of digits of 19 is 1+9=10. Since 19÷10 is not an integer, 19 is a Bad Number.
//Test Case 3: For the third test case, the sum of digits of 21 is 2+1=3. Since 21÷3=7, 21 is a Good Number.
package NQT;
import java.util.Scanner;
public class GoodNumber_CODE_CHEF {
	    
	    public static boolean isGoodNumber(int x){
	        int n= x;
	        int sum =0;
	        while(n!=0){
	            int rem = n%10;
	            sum+=rem;
	            n=n/10;
	        }
	        return x%sum==0;
	    }
	    
	    public static void main(String[] args) {
	      int x1=18;
	      boolean output1=true;
	      int x2=19;
	      boolean output2=false;
	      int x3=21;
	      boolean output3=true;
	      
	      boolean ans1=isGoodNumber(x1);
		  boolean ans2=isGoodNumber(x2);
		  boolean ans3=isGoodNumber(x3);
			
			System.out.println("Brute Force Approch :");
			
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
				System.out.println("Actual Output :"+output3);
				System.out.println("Your Output :"+ans3);
			}
			
	      
	      
	    	}
	

}
