//60. Permutation Sequence
//Hard
//Topics
//Companies
//The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
//
//By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
//
// 
//
//Example 1:
//
//Input: n = 3, k = 3
//Output: "213"
//Example 2:
//
//Input: n = 4, k = 9
//Output: "2314"
//Example 3:
//
//Input: n = 3, k = 1
//Output: "123"
// 
//
//Constraints:
//
//1 <= n <= 9
//1 <= k <= n!


package Maths;

public class PermutationSequence_60 {
//approch :
//	geenrate the number as a array
//	now find next pemutation of number k times
//	time complexity : O(n*k)
//	space complexity : O(n*k)
	public static String getPermutation(int n, int k) {
		   char [] num= new char[n];
		   for(int i =1;i<=n;i++) {
			   num[i-1]=(char) ('0'+i);
		   }
		   for(int i=1;i<k;i++) {
			   nextPermutation(num);
		   }
		   return new String(num);
	    }
	   public static void nextPermutation(char[] num) {
		   int index= num.length-2;
		   while(index>=0) {
			   int x1=num[index]-'0';
			   int x2=num[index+1]-'0';
			   if(x1<x2) {
				   break;
			   }
			   index--;
		   }
		   int n =num.length;
		   int swapidx= binarySearch(num, index+1,n-1 ,num[index]-'0' );
		   swap(num, swapidx, index);
		   reverse(num, index+1,n-1 );
	   }
	   
	   public static int binarySearch(char [] num,int s ,int e, int target) {
		   while(s<=e) {
			   int m = s+(e-s)/2;
			   int midint= num[m]-'0';
			   if(midint<target) {
				   e=m-1;
			   }else {
				   s=m+1;
			   }			   
		   }
		   return e;
	   }
	   
	   
	   public static void reverse(char [] num, int s, int e) {
		   while(s<e) {
			   swap(num,s,e);
			   s++;
			   e--;
		   }
	   }
	   
	public static void swap(char[] num, int s, int e) {
		char t = num[s];
		num[s]=num[e];
		num[e]=t;
	}
	public static void main(String[] args) {
		//Example 1:

		int n1 = 3, k1 = 3;
		int output1=213;
		
		//Example 2:

		int n2 = 4, k2 = 9;
		int output2=2314;

		//Example 3:

		int n3 = 3, k3 = 1;
		int output3=123;
		
		System.out.println("Brute Force Approch :");
		System.out.println(getPermutation(n1, k1));
		System.out.println(getPermutation(n2, k2));
		System.out.println(getPermutation(n3, k3));

	}

}
