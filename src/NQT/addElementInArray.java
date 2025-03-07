//Problem Statement: Given an array of N integers, write a program to add an array element at the beginning, end, and at a specific position.
//
//Example:
//Input: N = 5, array[] = {1,2,3,4,5}
//insertbeginning(6)
//insertending(7)
//insertatpos(8,4)
//Output: 6,1,2,8,3,4,5,7
//Explanation: 6 is added at the beginning and 7 is added at the end and 8 is added at position 4 


package NQT;

import java.util.Arrays;

public class addElementInArray {
	
	public static int [] addAtbeginning(int [] arr, int e) {
		int [] newarr = new int [arr.length+1];
		int index=1;
		for(int i =0;i<arr.length;i++) {
			newarr[index]=arr[i];
			index++;
		}
		newarr[0]=e;
			return newarr;
	}	
	public static int [] addAtEnd(int [] arr, int e) {
		int [] newarr = new int [arr.length+1];

		for(int i =0;i<arr.length;i++) {
			newarr[i]=arr[i];
		}
		newarr[arr.length]=e;
		return newarr;
	}	
	
	public static int [] addAtPos(int [] arr, int e,int index) {
		if (index<0 || index>arr.length+1) System.out.println("cannot insert at index ");
		else {		
		int [] newarr = new int [arr.length+1];
		int i=0;
		while(i<index) {
			newarr[i]=arr[i];
			i++;
		}
		
		newarr[i]=e;
		i++;
		while(i<newarr.length) {
			newarr[i]=arr[i-1];
			i++;
		}
		return newarr;
		}
		return arr;
		
	}	
	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5};
		
		System.out.println("Original Array  : "+Arrays.toString(arr));
		arr=addAtbeginning(arr, 324);
		arr=addAtbeginning(arr, 4);
		arr=addAtbeginning(arr, 1);
		System.out.println("After Adding Element  : "+Arrays.toString(arr));		
		arr=addAtEnd(arr, 324);
		arr=addAtEnd(arr, 4);
		arr=addAtEnd(arr, 1);
		System.out.println("After Adding Element  : "+Arrays.toString(arr));
		arr=addAtPos(arr, 0, arr.length);
		arr=addAtPos(arr, 0, 5);

		
		System.out.println("After Adding Element  : "+Arrays.toString(arr));
		
		
		
	}
}
