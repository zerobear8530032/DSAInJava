//Check if an Array is Sorted
//Last Updated : 15 Nov, 2024
//Given an array of size n, the task is to check if it is sorted in ascending order or not. Equal values are allowed in an array and two consecutive equal values are considered sorted.
//
//Examples: 
//
//Input: arr[] = [20, 21, 45, 89, 89, 90]
//Output: Yes
//
//Input: arr[] = [20, 20, 45, 89, 89, 90]
//Output: Yes
//
//Input: arr[] = [20, 20, 78, 98, 99, 97]
//Output: No


package Recursion;

import java.util.Arrays;

public class CheckIfAnArrayIsSorted_GFG {
//	iterative
//	time complexity : O(n)
//	Space complexity : O(1)
	
	public static boolean checkSorted(int [] arr) {
		for(int i =0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1]) {
				return false;
			}
		}
		return true;
	}
//	recursion :
//	time complexity : O(n)
//	Space complexity : O(n)
	public static boolean checkSortedRec(int [] arr) {
			return checksorthelper(arr,arr.length-1);
	}
	

	
	private static boolean checksorthelper(int[] arr, int i) {
		if(i==0) {
			return true;
		}
		if(arr[i]<arr[i-1]) {
			return false;
		}
		return checksorthelper(arr,i-1);
		
	}
	public static void main(String[] args) {
		//Examples: 
		//
		int  arr1[] = {20, 21, 45, 89, 89, 90};
		boolean output1=true;
		//
		int  arr2[] = {20, 20, 45, 89, 89, 90};
		boolean output2=true;
		//
		int  arr3[] = {20, 20, 78, 98, 99, 97};
		boolean output3=false;
		
		System.out.println("Iterative Approch :");
		
		boolean ans1=checkSorted(arr1);
		boolean ans2=checkSorted(arr2);
		boolean ans3=checkSorted(arr3);
		
		if(ans1==output1) {
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
		System.out.println("Recursion Approch :");
		
		ans1=checkSortedRec(arr1);
		ans2=checkSortedRec(arr2);
		ans3=checkSortedRec(arr3);
		
		if(ans1==output1) {
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
