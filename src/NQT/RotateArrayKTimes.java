
//Rotate array by K elements : Block Swap Algorithm
//In this article we will learn a very popular algorithm for "Rotate array by K elements : Block Swap Algorithm".
//
//Problem Statement: Given an array of n size, rotate the array by k elements using the Block Swap Algorithm.
//
//Examples:
//
//Example 1:
//Input: N = 5, array[] = {1,2,3,4,5} K=2
//Output: {3,4,5,1,2}
//Explanation: Rotate the array to right by 2 elements.
//
//Example 2:
//Input: N = 7, array[] = {1,2,3,4,5,6,7} K=3
//Output: {4,5,6,7,1,2,3}
//Explanation: Rotate the array to right by 3 elements.


package NQT;

import java.util.Arrays;

public class RotateArrayKTimes {
	
//	brute force approch :
//	roate the array K times :
//	time coplexity:O(n*k)
//	space complexity :O(1)
	public static void rotateArrayBruteForce(int [] arr, int k) {
		for(int i =0;i<k;i++) {
			rotate(arr);
		}
	}
//	better force approch :
//	rotate only k%n times because once we rotate k time it comve back to original  :
//	time coplexity:O(n*k%n)
//	space complexity :O(1)
	public static void rotateArrayBetter(int [] arr, int k) {
		for(int i =0;i<k%arr.length;i++) {
			rotate(arr);
		}
	}
	
	
//	best approch :
//	rever entire array :
//	then reverse the part from start till k 
//	then reverse part from k+1 till end
//	time coplexity:O(n*k%n)
//	space complexity :O(1)
	public static void rotateArrayBest(int [] arr, int k) {
		int n = arr.length;
		reverse(arr, 0,n-1);		
		reverse(arr, 0,k);		
		reverse(arr, k+1,n-1);		
		
	}
	public static void reverse(int [] arr,int start, int end) {
		while(start<end) {			
			swap(arr, start, end);
			start++;
			end--;
		}
	}
	public static void swap(int [] arr, int idx1,int idx2) {
		int temp = arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=temp;
	}

	
	public static void rotate(int[] arr) {
		int fval=arr[0];
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			arr[i]=arr[i+1];
		}
		arr[n-1]=fval;	
	}
	
	
	
	public static void main(String[] args) {
		
		int [] arr1= {1,2,3,4,5};
		int [] output1= {3,4,5,1,2};
		int k1=2;
		
		
		int [] arr2= {1,2,3,4,5,6,7};
		int [] output2= {4,5,6,7,1,2,3};
		int k2=3;
		
		
		System.out.println("Brute Foce");
		rotateArrayBruteForce(arr1, k1);
		rotateArrayBruteForce(arr2, k2);
		
		
		if(Arrays.equals(arr1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(arr1));
	}
		if(Arrays.equals(arr2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(arr2));
		}
		
		
		System.out.println("Better Approch :");
		
		arr1= new int [] {1,2,3,4,5};
		arr2= new int [] {1,2,3,4,5,6,7};
		
		rotateArrayBetter(arr1,k1);
		rotateArrayBetter(arr2,k2);
		
		
		if(Arrays.equals(output1, arr1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(arr1));
		}
		if(Arrays.equals(output2, arr2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(arr2));
		}
		System.out.println("Best Approch :");
		
		arr1= new int [] {1,2,3,4,5};
		arr2= new int [] {1,2,3,4,5,6,7};
		
		rotateArrayBest(arr1,k1);
		rotateArrayBest(arr2,k2);
		
		
		if(Arrays.equals(output1, arr1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(arr1));
		}
		if(Arrays.equals(output2, arr2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(arr2));
		}
	
		
	}

}
