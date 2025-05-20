//50. Pow(x, n)
//Solved
//Medium
//Topics
//Companies
//Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
//
// 
//
//Example 1:
//
//Input: x = 2.00000, n = 10
//Output: 1024.00000
//Example 2:
//
//Input: x = 2.10000, n = 3
//Output: 9.26100
//Example 3:
//
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
// 
//
//Constraints:
//
//-100.0 < x < 100.0
//-231 <= n <= 231-1
//n is an integer.
//Either x is not zero or n > 0.
//-104 <= xn <= 104


package Recursion;

public class PowXN_50 {
	
	
//	Iterative  Approch brute force :
//	just get exponential of x to power of n if n  was negative return 1/ exp of x
//	other wise return exponent x
//	time complexity :O(n)
//	space complexity :O(1)
	
	public static double myPowIterativeBruteForce(double x, int n) {
		double res=1;
		for(int i =0;i<Math.abs(n);i++) {
			res=res*x; 
		}
		if(n<0) {
			return 1.0/res;
		}else {
			return res;			
		}
    }
//	Iterative  Approch better :
//	just get exponential of x to power of n if n  was negative return 1/ exp of x
//	other wise return exponent x
//	time complexity :O(log n)
//	space complexity :O(1)
	
	public static double myPowIterativeBetter(double x, int n) {
		double res=1;
		int num=Math.abs(n);
		while(num>0) {
			if(num%2==1) {
				res= res*x;
			}
			x=x*x;
			num= num/2;
		}		
		if(n<0) {
			return 1.0/res;
		}else {
			return res;			
		}
	}
	
	
//	Recusion Approch Better:
//	just get exponential of x to power of n if n  was negative return 1/ exp of x
//	other wise return exponent x
//	time complexity :O(log n)
//	space complexity :O(n)
	
	public static double myPowRecBruteForce(double x, int n) {
		double exp= exponentBruteForce(x,Math.abs(n),1.0);
		if(n>0) {
			return exp;
		}else {
			return 1.0/exp;
		}
	}
	public static double exponentBruteForce(double x, int n, double res) {
		if(n==0) {
			return res;
		}
		res= res*x;
		return exponentBruteForce(x,n-1,res);
	}

	
//	Recusion Approch Better:
//	just get exponential of x to power of n if n  was negative return 1/ exp of x
//	other wise return exponent x
//	time complexity :O(log n)
//	space complexity :O(n)
	
	public static double myPowRecBetter(double x, int n) {
		double exp= exponentBetter(x,Math.abs(n));
		if(n>0) {
			return exp;
		}else {
			return 1.0/exp;
		}
	}
	
	
// this algorithm is called fast  binary exponent 
//	where we use a formula if x^n  where n = event we can say 
//	x^n=(x^(n/2))^2
//	so we what if the n is odd we can say
//	x^n=x*(x^(n/2))^2
//	that what we did in this algorithm
	public static double exponentBetter(double x, int n) {
		if(n==0) {// if n ==0 its 1
			return 1;
		}
		
		double half= exponentBetter(x,n/2);// recusive call to n/2 will result as x^(n/2)
		double res= half*half;// we take square of x^(n/2)
		if(n%2!=0) {// if the  n is odd we multiply the extra x to res
			res= res*x;
		}
		return res;// last result

	}

	public static void main(String[] args) {
		//Example 1:

		double x1 = 2.00000;
		int n1 = 10;
		double output1=1024.0000;

		//Example 2:

		double x2 = 2.10000;
		int n2 = 3;
		double output2=9.261000000000001;
		
		//Example 3:

		double x3 = 2.00000;
		int n3 = -2;
		double output3=0.25000;
		
		System.out.println("Iterative Brute Force Approch :");

		double ans1=myPowIterativeBruteForce(x1, n1);
		double ans2=myPowIterativeBruteForce(x2, n2);
		double ans3=myPowIterativeBruteForce(x3, n3);
		
		
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
		
		
		
		System.out.println("Iterative Better Approch :");
		
		ans1=myPowIterativeBetter(x1, n1);
		ans2=myPowIterativeBetter(x2, n2);
		ans3=myPowIterativeBetter(x3, n3);
		
		
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
		
		System.out.println("Recursive Brute Force Approch :");
		
		ans1=myPowRecBruteForce(x1, n1);
		ans2=myPowRecBruteForce(x2, n2);
		ans3=myPowRecBruteForce(x3, n3);
		
		
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
		
		
		
		System.out.println("Recursive Better Approch :");
		
		ans1=myPowRecBetter(x1, n1);
		ans2=myPowRecBetter(x2, n2);
		ans3=myPowRecBetter(x3, n3);
		
		
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
