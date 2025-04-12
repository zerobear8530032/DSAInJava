//3272. Find the Count of Good Integers
//Hard
//Topics
//Companies
//Hint
//You are given two positive integers n and k.
//
//An integer x is called k-palindromic if:
//
//x is a palindrome.
//x is divisible by k.
//An integer is called good if its digits can be rearranged to form a k-palindromic integer. For example, for k = 2, 2020 can be rearranged to form the k-palindromic integer 2002, whereas 1010 cannot be rearranged to form a k-palindromic integer.
//
//Return the count of good integers containing n digits.
//
//Note that any integer must not have leading zeros, neither before nor after rearrangement. For example, 1010 cannot be rearranged to form 101.
//
// 
//
//Example 1:
//
//Input: n = 3, k = 5
//
//Output: 27
//
//Explanation:
//
//Some of the good integers are:
//
//551 because it can be rearranged to form 515.
//525 because it is already k-palindromic.
//Example 2:
//
//Input: n = 1, k = 4
//
//Output: 2
//
//Explanation:
//
//The two good integers are 4 and 8.
//
//Example 3:
//
//Input: n = 5, k = 6
//
//Output: 2468
//
// 
//
//Constraints:
//
//1 <= n <= 10
//1 <= k <= 9


package Maths;

public class FindTheCountOfGoodIntegers_3272 {
	
	
	 public static long countGoodIntegers(int n, int k) {
		 int start=(int)Math.pow(10, n-1);
		 int end = (int)Math.pow(10, n)-1;
		 int ans=0;
		 for(int i =start;i<=end;i++) {
			 String str= Integer.toString(i);
			 if(palindrome(str)) {
				 if(i%k==0) {
					 ans++;
				 }
			 }
		 }
		 return ans;
	}
	public static boolean palindrome(String str) {
		int s=0;
		int e=str.length()-1;
		while(s<e) {
			if(str.charAt(s)!=str.charAt(e)) return false;
			s++;
			e--;
		}
		return true;
	}

	public static void main(String[] args) {
		
		//Example 1:

		int n1 = 3, k1 = 5;
		int output1=27;

		//Example 2:

		int  n2= 1, k2 = 4;
		int output2=2;

		//Example 3:

		int n3=5,k3=6;
		int output3= 2468;
		
		System.out.println(countGoodIntegers(n1, k1));
	}

}
