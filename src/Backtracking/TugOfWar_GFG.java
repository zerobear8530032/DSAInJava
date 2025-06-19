//Tug of War
//Last Updated : 20 May, 2025
//Given an array arr[] of size n, the task is to divide it into two subsets such that the absolute difference between the sum of elements in the two subsets.
//
//If n is even, both subsets must have exactly n/2 elements.
//If n is odd, one subset must have (n−1)/2 elements and the other must have (n+1)/2 elements.
//Examples:
//
//Input: arr[] = [3, 4, 5, -3, 100, 1, 89, 54, 23, 20]
//Output: 
//3 5 -3 89 54 
//4 100 1 23 20 
//Explanation: The absolute difference between the two subsets is 0.
//
//Input: arr[] = [23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4]
//Output: 
//23 0 -99 4 189 4 
//45 -34 12 98 -1 
//Explanation: The absolute difference between the two subsets is 1, which is minimum.


package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TugOfWar_GFG {

	public static String divideArray(int []arr){
		List<Integer> set1= new ArrayList<Integer>();
		List<Integer> set2= new ArrayList<Integer>();
		mindiff= Integer.MAX_VALUE;
		res="";
		helper(arr,0,set1,set2,0,0); 
		return res;
	}
	static String res;
	static int mindiff;

	public static void helper(int[] arr, int idx, List<Integer> set1, List<Integer> set2, int sum1, int sum2) {
		if(idx==arr.length) {
			int sumdiff= Math.abs(sum1-sum2);
			if(sumdiff<mindiff) {
				mindiff=sumdiff;
				res=set1+" "+set2;
			}
			return ;
		}


		if(set1.size()<(arr.length+1)/2) {			
		set1.add(arr[idx]);
		helper(arr,idx+1,set1,set2,sum1+arr[idx],sum2);
		set1.remove(set1.size()-1);
		}
		if(set2.size()<(arr.length+1)/2) {			
		set2.add(arr[idx]);
		helper(arr,idx+1,set1,set2,sum1,sum2+arr[idx]);
		set2.remove(set2.size()-1);
		}
	}



	public static void main(String[] args) {		
		int arr1[] = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
		String output1= "[3, 5, -3, 89, 54] [4, 100, 1, 23, 20]";
		
		int arr2[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		String output2= "[23, 0, -99, 4, 189, 4] [45, -34, 12, 98, -1]";
		
		String ans1 = divideArray(arr1);
		String ans2 = divideArray(arr2);
		
		
		if(output1.equals(ans1)) {
	  		System.out.println("Case 1 Passed");
	  	}else {
	  		System.out.println("Case 1 Failed");
	  		System.out.println("Expected Ouput :"+ output1);
	  		System.out.println("Your Answer :"+ ans1);  		
	  	}
	  	
	  	if(output2.equals(ans2)) {
	  		System.out.println("Case 2 Passed");
	  	}else {
	  		System.out.println("Case 2 Failed");
	  		System.out.println("Expected Ouput :"+ output2);
	  		System.out.println("Your Answer :"+ ans2);  		
	  	}
		}
		
	}
	
	

