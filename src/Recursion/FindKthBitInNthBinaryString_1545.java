//1545. Find Kth Bit in Nth Binary String
//Solved
//Medium
//Topics
//Companies
//Hint
//Given two positive integers n and k, the binary string Sn is formed as follows:
//
//S1 = "0"
//Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
//Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).
//
//For example, the first four strings in the above sequence are:
//
//S1 = "0"
//S2 = "011"
//S3 = "0111001"
//S4 = "011100110110001"
//Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
//
// 
//
//Example 1:
//
//Input: n = 3, k = 1
//Output: "0"
//Explanation: S3 is "0111001".
//The 1st bit is "0".
//Example 2:
//
//Input: n = 4, k = 11
//Output: "1"
//Explanation: S4 is "011100110110001".
//The 11th bit is "1".
// 
//
//Constraints:
//
//1 <= n <= 20
//1 <= k <= 2n - 1



package Recursion;

public class FindKthBitInNthBinaryString_1545 {
	
//	use recusion to make the string what asked 
//	time complexity : O(2^n)
//	space complexity : O(2^n)
	 public static char findKthBitRec(int n, int k) {
		 String str= operation(n, "0");
		 return str.charAt(k-1);
	 }
	 
	 public static String operation(int n, String prev) {
		 if(n==0) {
			 return prev;
		 }		 
		 String reverseInverted= reverseInvert(prev);
		 String next = prev+"1"+reverseInverted;
		 return operation(n-1,next);
	 }
	 public static String reverseInvert(String str) {
		 char []chararr= str.toCharArray();
		 int s=0;
		 int e = chararr.length-1;
		 while(s<e) {
//			 invert:
			 if(chararr[s]=='0') {
				 chararr[s]='1';
			 }else {
				 chararr[s]='0';
			 }
			 if(chararr[e]=='0') {
				 chararr[e]='1';
			 }else {
				 chararr[e]='0';
			 }
//			 reverse
			 swap(chararr,s,e);
			 s++;
			 e--;
		 }
		 if(chararr[e]=='0') {
			 chararr[e]='1';
		 }else {
			 chararr[e]='0';
		 }
		 return new String(chararr);
	 }
	 public static void swap(char [] arr,int s, int e) {
		 char t = arr[s];
		 arr[s]=arr[e];
		 arr[e]=t;
	 }
	 
	 
	 

//		use iterative to make the string what asked 
//		time complexity : O(2^n)
//		space complexity : O(2^n)
		 public static char findKthBitIterative(int n, int k) {
			 String initial ="0";
			 for(int i =0;i<n;i++) {
				 String reverseInvert= reverseInvert(initial);
				 String next= initial + 1+ reverseInvert;
				 initial = next;
			 }
			 return initial.charAt(k-1);
		 }	
	 

	public static void main(String[] args) {
		
		//Example 1:

		int n1 = 3, k1 = 1;
		char output1='0';


		//Example 2:

		int n2 = 3, k2 = 11;
		char output2='1';
		
		
		System.out.println("Recursion Approch :");
		
		char ans1=findKthBitRec(n1,k1);
		char ans2=findKthBitRec(n2,k2);
		
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

		
		System.out.println("Iterative Approch :");
		
		ans1=findKthBitIterative(n1,k1);
		ans2=findKthBitIterative(n2,k2);
		
		
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



		

	}

}
