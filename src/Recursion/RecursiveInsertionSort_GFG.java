//Recursive Insertion Sort
//Last Updated : 13 Sep, 2023
//Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.

package Recursion;

import java.util.Arrays;

public class RecursiveInsertionSort_GFG {
	
//	iterative approch : 
//	time complexity :O(n*n)
//	space complexity :O(1)
	public static void InsertionSort_Iterative(int [] arr) {
		for(int i =0;i<arr.length-1;i++) {
			for(int j=i+1;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					swap(arr,j,j-1);
				}
			}
		}
		
	}
	public static void swap(int [] arr,int idx1,int idx2) {
		int temp= arr[idx1];
		arr[idx1]=arr[idx2];
		arr[idx2]=temp;
	}
	
	public static boolean checksorted(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1]) {
				return false;
			}
		}
		return true;
	}
//	Recursion approch : 
//	time complexity :O(n*n)
//	space complexity :O(n)
	public static void InsertionSort_Rec(int [] arr) {
		if(arr.length<=1) {
			return ;
		}
		insertionIterationHelper(arr, 0);
	}
	public static void insertionPassHelper(int [] arr, int j) {
		if(j==0) {
			return ;
		}
		if(arr[j]<arr[j-1]) {
			swap(arr, j, j-1);
		}else {
			return ;
		}
		insertionPassHelper(arr, j-1);
	}
	public static void insertionIterationHelper(int [] arr, int i) {
		if(i>=arr.length-1) {
			return;
		}
		insertionPassHelper(arr, i+1);
		insertionIterationHelper(arr, i+1);
	}
	

	public static void main(String[] args) {
		
		
		int [] arr1 = {5,4,2,1,3};
		int [] arr2 = {5,4,1,1,3};
		int [] arr3 = {1};
		int [] arr4= {};
		
		System.out.println("Iterative Approch :");
		
		InsertionSort_Iterative(arr1);
		InsertionSort_Iterative(arr2);
		InsertionSort_Iterative(arr3);
		InsertionSort_Iterative(arr4);
		
		if(checksorted(arr1)) {
			System.out.println("Array is sorted :"+ Arrays.toString(arr1));
		}else {
			System.out.println("Array is Not Sorted :"+ Arrays.toString(arr1));
		}
		if(checksorted(arr2)) {
			System.out.println("Array is sorted :"+ Arrays.toString(arr2));
		}else {
			System.out.println("Array is Not Sorted :"+ Arrays.toString(arr2));
		}
		if(checksorted(arr3)) {
			System.out.println("Array is sorted :"+ Arrays.toString(arr3));
		}else {
			System.out.println("Array is Not Sorted :"+ Arrays.toString(arr3));
		}
		if(checksorted(arr4)) {
			System.out.println("Array is sorted :"+ Arrays.toString(arr4));
		}else {
			System.out.println("Array is Not Sorted :"+ Arrays.toString(arr4));
		}
		arr1 = new int [] {5,4,2,1,3};
		arr2 = new int [] {5,4,1,1,3};
		arr3 = new int [] {1};
		arr4= new int [] {};
		
		System.out.println("Recursion Approch :");
		
		InsertionSort_Rec(arr1);
		InsertionSort_Rec(arr2);
		InsertionSort_Rec(arr3);
		InsertionSort_Rec(arr4);
		
		if(checksorted(arr1)) {
			System.out.println("Array is sorted :"+ Arrays.toString(arr1));
		}else {
			System.out.println("Array is Not Sorted :"+ Arrays.toString(arr1));
		}
		if(checksorted(arr2)) {
			System.out.println("Array is sorted :"+ Arrays.toString(arr2));
		}else {
			System.out.println("Array is Not Sorted :"+ Arrays.toString(arr2));
		}
		if(checksorted(arr3)) {
			System.out.println("Array is sorted :"+ Arrays.toString(arr3));
		}else {
			System.out.println("Array is Not Sorted :"+ Arrays.toString(arr3));
		}
		if(checksorted(arr4)) {
			System.out.println("Array is sorted :"+ Arrays.toString(arr4));
		}else {
			System.out.println("Array is Not Sorted :"+ Arrays.toString(arr4));
		}

	}

}
