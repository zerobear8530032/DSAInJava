//	Remove Duplicates in-place from Sorted Array
//	
//	
//	613
//	
//	23
//	Problem Statement: Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once. The relative order of the elements should be kept the same.
//	
//	If there are k elements after removing the duplicates, then the first k elements of the array should hold the final result. It does not matter what you leave beyond the first k elements.
//	
//	Note: Return k after placing the final result in the first k slots of the array.
//	
//	Examples
//	Example 1:
//	Input:
//	 arr[1,1,2,2,2,3,3]
//	
//	Output:
//	 arr[1,2,3,_,_,_,_]
//	
//	Explanation:
//	 Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3 after assigning [1,2,3] in the beginning of the array.
//	
//	Example 2:
//	Input:
//	 arr[1,1,1,2,2,3,3,3,3,4,4]
//	
//	Output:
//	 arr[1,2,3,4,_,_,_,_,_,_,_]
//	
//	Explanation:
//	 Total number of unique elements are 4, i.e[1,2,3,4] and Therefore return 4 after assigning [1,2,3,4] in the beginning of the array.



package NQT;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {
	
	public static int removeDuplicateFromSortedArray(int arr[]) {
		int s=0;
		int e=1;
		int n = arr.length;
		while(e<n) {
			if(arr[s]!=arr[e]) {
				s++;
				arr[s]=arr[e];
			}
			e++;
		}
		return s+1;
		
	}
	
	public static boolean check(int [] output,int l) {
		for(int i =0;i<l-1;i++) {
			if(output[i]==output[i+1]) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		//	Example 1:
		int [] arr1= {1,1,2,2,2,3,3};
		int output1= 3;
		
		//	Example 1:
		int [] arr2= {1,1,1,2,2,3,3,3,3,4,4};
		int output2= 4;
		
		int ans1 =removeDuplicateFromSortedArray(arr1);
		int ans2 =removeDuplicateFromSortedArray(arr2);
		
		if(check(arr1,ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println(Arrays.toString(arr1));
		
		}
		if(check(arr2,ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
	
		}
		
	}
	
	
	
	
}

