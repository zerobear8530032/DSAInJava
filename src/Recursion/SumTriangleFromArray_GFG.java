//question link 
//https://www.geeksforgeeks.org/sum-triangle-from-array/
//Sum triangle from array
//	Last Updated : 16 Nov, 2022
//	Given an array of integers, print a sum triangle from it such that the first level has all array elements. From then, at each level number of elements is one less than the previous level and elements at the level is be the Sum of consecutive two elements in the previous level. 
//	Example :
//	 
//	
//	Input : A = {1, 2, 3, 4, 5}
//	Output : [48]
//	         [20, 28] 
//	         [8, 12, 16] 
//	         [3, 5, 7, 9] 
//	         [1, 2, 3, 4, 5] 
//	
//	Explanation :
//	Here,   [48]
//	        [20, 28] -->(20 + 28 = 48)
//	        [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
//	        [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
//	        [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)
package Recursion;

import java.util.Arrays;

public class SumTriangleFromArray_GFG {
//	approch : create a new array each time using prefix sum arr of n-1 length and add it to the output array 
	
	public static void SumtriangleFromArray_Iterative_Approch (int [] arr) {
		int [][] output= new int [arr.length][];
		for(int i =arr.length-1;i>=0;i--) {
			output[i]= arr;
			arr=prefixsum(arr);
		}
		printMatrix(output);
	}
	public static int[] prefixsum(int arr[]) {// creating a prefix sum array 
		int [] prefixarr= new int [arr.length-1];
		for(int i =0;i<arr.length-1;i++) {
			prefixarr[i]= arr[i]+arr[i+1];
		}
		return prefixarr;
	}
	
	public static void printMatrix(int [][] arr) {
		for(int i =0;i<arr.length;i++) {
				System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	
	
//	recursion method :
	
	public static void SumtriangleFromArray_Recusion_Approch (int [] arr) {
		if(arr.length==0) {
			return ;
		}
		int temp [] = new int [arr.length-1];
		for(int i = 0;i<temp.length;i++) {
			temp[i]= arr[i]+arr[i+1];
		}
		SumtriangleFromArray_Recusion_Approch(temp);// switch this with down print statement it will reverse the triangle
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	
	public static void main(String[] args) {
		int [] arr1	= {1, 2, 3, 4, 5};
		
		System.out.println("Using Iterative Method:");
		SumtriangleFromArray_Iterative_Approch(arr1);
		System.out.println("Using Recursion Method:");
		SumtriangleFromArray_Recusion_Approch(arr1);
	}
	
}

