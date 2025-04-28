//343. Integer Break
//Medium
//Topics
//Companies
//Hint
//Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
//
//Return the maximum product you can get.
//
// 
//
//Example 1:
//
//Input: n = 2
//Output: 1
//Explanation: 2 = 1 + 1, 1 × 1 = 1.
//Example 2:
//
//Input: n = 10
//Output: 36
//Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
// 
//
//Constraints:
//
//2 <= n <= 58
package Arrays;

public class IntegerBreak_343 {
//	brute force :
//	check every single sequence of integer
	public static int integerBreak(int n) {
		
		return integerBreakHelper(n , 1);
    }
	

	public static int integerBreakHelper(int n, int maxProd) {
		if(n==1) {
			return 1;
		}
		if(n<=0) {
			return 0;
		}
		
		for(int i =1;i<n;i++) {
			maxProd=maxProd*i;
			int res= integerBreakHelper(n-i, maxProd);
			maxProd=Math.max(maxProd,res);
		}
		return maxProd;
	}


	public static void main(String[] args) {
		

//		Example 1:

		int n1 = 2;
		int output1=1;

//		Example 2:

		int n2 = 10;
		int output2=36;
		
		
		System.out.println(integerBreak(n1));
		System.out.println(integerBreak(n2));

	}

}
