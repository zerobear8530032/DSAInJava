// question links :
//https://www.geeksforgeeks.org/recursive-program-prime-number/
//Given a number n, check whether it’s prime number or not using recursion.
//Examples: 
// 
//
//Input : n = 11
//Output : Yes
//
//Input : n = 15
//Output : No
package Recursion;

public class RecursiveProgramForPrimeNumber_GFG {
//	approch : checking every number from 0 till n-1 if any number divid the n its prime 
//	other wise its non prime
//	time complexity O(n)
//	space complexity O(1)
	public static boolean  checkPrimeBruteForce(int n){
		if(n<=1) {
			return false;
		}
		if(n==2){ return true;}
			for(int i =2;i<n;i++) {
				if(n%i==0) {
					return false;
				}
			}
			return true;
	}
//	approch : checking number squares of every number wheather it divides the number or not
//	because if it divides the number the root of that number is also divisible so we can just check wheather
//	its square can divide the number or not
//	time complexity O(root(n))
//	space complexity O(1)
	public static boolean  checkPrimeBetter(int n) {
		if(n<1) {
			return false;
		}

		if(n==2){ return true;}
		for(int i =2;i*i<=n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
//	recursion : checking number squares of every number wheather it divides the number or not
//	because if it divides the number the root of that number is also divisible so we can just check wheather
//	its square can divide the number or not
//	time complexity O(root(n))
//	space complexity O(n)
	public static boolean  checkPrimeRec(int n) {
		return checkprimehelper(n, 2);
	}
	public static boolean checkprimehelper(int n,int i) {
		if(n<=1) {
			return false;
		}

		if(n==2){ return true;}
		if(n<i*i) {
			return true;
		}
		if(n%i==0) {
			return false;
		}
		return checkprimehelper(n,i+1);
	}
	
	public static void main(String[] args) {
		
		int n1 = 11;
		boolean output1=true;
		
		int n2 = 15;
		boolean output2=false;

		int n3 = 2;
		boolean output3=true;
		
		boolean ans1=checkPrimeBruteForce(n1);
		boolean ans2=checkPrimeBruteForce(n2);
		boolean ans3=checkPrimeBruteForce(n3);
		
		System.out.println("Iterative Approch :");
		
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
		
		System.out.println("better Iterative Approch :");
		
		ans1=checkPrimeBetter(n1);
		ans2=checkPrimeBetter(n2);
		ans3=checkPrimeBetter(n3);
		
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
		
		
		System.out.println("Recursion Iterative Approch :");
		
		ans1=checkPrimeRec(n1);
		ans2=checkPrimeRec(n2);
		ans3=checkPrimeRec(n3);
		
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
