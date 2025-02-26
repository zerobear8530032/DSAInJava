//Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
//Example: 
//First Pass: 
//( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1. 
//( 1 5 4 2 8 ) –> ( 1 4 5 2 8 ), Swap since 5 > 4 
//( 1 4 5 2 8 ) –> ( 1 4 2 5 8 ), Swap since 5 > 2 
//( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
//Second Pass: 
//( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ) 
//( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2 
//( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) 
//( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) 
//Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.
//Third Pass: 
//( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) 
//( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) 
//( 1 2 4 5 8 ) –> ( 1 2 4 5 8 ) 
//( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )

package Recursion;

import java.util.Arrays;

public class RecursionBubbleSort_GFG {
	
//	iterative approch to implement bubble sort :
	
	public static void swap(int [] nums,int idx1,int idx2) {
		int temp = nums[idx1];
		nums[idx1]=nums[idx2];
		nums[idx2]=temp;
	}
	public static void bubblesort_iterative(int [] nums) {
		for(int i =0;i<nums.length-1;i++) {
			for(int j=1;j<nums.length-i;j++) {
				if(nums[j]<nums[j-1]) {
					swap(nums, j, j-1);
				}
			}
		}
	}
	
	public static void bubblesort_Recursion(int [] nums) {
		bubblesorthelper1(nums,0);
	}
	public static void bubblesorthelper1(int [] nums,int i) {
		if(i>=nums.length-1) {
			return;
		}
		bubblesorthelper2(1, i,nums);
		bubblesorthelper1(nums,i+1);
	}
	
	public static void bubblesorthelper2(int j,int i , int [] nums) {
		if(j>=nums.length-i) {
			return ;
		}
		if(nums[j]<nums[j-1]) {
			swap(nums, j, j-1);
		}
		bubblesorthelper2(j+1,i,nums);
		
	}
	
	
	public static boolean checksorted(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]) {
		
		int [] arr1 = {5,4,2,1,3};
		int [] arr2 = {5,4,1,1,3};
		int [] arr3 = {1};
		int [] arr4= {};
		
		System.out.println("Iterative Approch :");
		
		bubblesort_iterative(arr1);
		bubblesort_iterative(arr2);
		bubblesort_iterative(arr3);
		bubblesort_iterative(arr4);
		
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

		System.out.println("Recursion Approch :");
		
		arr1 = new int []  {5,4,2,1,3};
		arr2 =  new int [] {5,4,1,1,3};
		arr3 = new int [] {1};
		arr4= new int [] {};
		
		bubblesort_Recursion(arr1);
		bubblesort_Recursion(arr2);
		bubblesort_Recursion(arr3);
		bubblesort_Recursion(arr4);
		
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
