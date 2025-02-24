// Question link:
//https://www.geeksforgeeks.org/recursive-programs-to-find-minimum-and-maximum-elements-of-array/
//Given an array of integers arr, the task is to find the minimum and maximum element of that array using recursion.
//
//Examples : 
//
//Input: arr = {1, 4, 3, -5, -4, 8, 6};
//Output: min = -5, max = 8
//
//Input: arr = {1, 4, 45, 6, 10, -8};
//Output: min = -8, max = 45

package Recursion;

import java.util.Arrays;

public class RecursiveProgramsToFindMinimumAndMaximumElementsOfarray_GFG{
//	use iterative approch :
	public static int getMin(int [] arr) {
		int res= Integer.MAX_VALUE;
		for(int i =0;i<arr.length;i++) {
			res=Math.min(res, arr[i]);
		}
		return res;
	}
	public static int getMax(int [] arr) {
		int res= Integer.MIN_VALUE;
		for(int i =0;i<arr.length;i++) {
			res=Math.max(res, arr[i]);
		}
		return res;
	}
	
//	use iterative approch : single function to evaluate both 
	public static int [] getMinMax(int [] arr) {
		int currmin =Integer.MAX_VALUE;
		int currmax =Integer.MIN_VALUE;
		
		for(int i =0;i<arr.length;i++) {
			currmin= Math.min(currmin, arr[i]);
			currmax= Math.max(currmax, arr[i]);
		}
		return new int [] {currmax,currmin};
	}
	
//	use Recursion approch :
	public static int getMinRec(int [] arr) {// recursion
		return getMin_Helper(arr, Integer.MAX_VALUE, arr.length-1);
	}
	
	public static int getMin_Helper(int [] arr, int currmin,int index) {	
		if(index==0) {
			return Math.min(currmin, arr[0]);	
		}
		currmin= Math.min(currmin, arr[index]);
		return getMin_Helper(arr,currmin,index-1);
	}
	
	public static int getMaxRec(int [] arr) {
		return getMax_Helper(arr, Integer.MIN_VALUE, arr.length-1);		
	}
	
	
	
	private static int getMax_Helper(int[] arr, int currmax, int index) {
		if(index==0) {
			return Math.max(currmax, arr[0]);	
		}
		currmax=Math.max(currmax,arr[index-1]);
		return getMax_Helper(arr, currmax, index-1);
	}
	

	
//	use Recursion approch combine min max  :
	public static int [] getMinMaxRec(int [] arr) {
		int[] ans= new int [2];
		return minmaxHelper(arr, ans, Integer.MAX_VALUE, Integer.MIN_VALUE, arr.length);
	}
	
	public static int [] minmaxHelper(int [] arr,int []ans , int currmin,int currmax,int index) {
		if(index==0) {
			currmin = Math.min(currmin, arr[0]);
			currmax = Math.max(currmax, arr[0]);
			ans[0]=currmax;
			ans[1]=currmin;
			return ans;
		}
		currmin = Math.min(currmin, arr[index-1]);
		currmax = Math.max(currmax, arr[index-1]);
		return minmaxHelper(arr, ans, currmin, currmax, index-1);
	}
	
	
	
	public static void main(String[] args) {
		int  []arr1 = {1, 4, 3, -5, -4, 8, 6};
		int min1= -5, max1 = 8;
		
		
		
		int[] arr2 = {1, 4, 45, 6, 10, -8};
		int min2 = -8, max2 = 45;
		
		int ansmin1 = getMin(arr1);
		int ansmax1 = getMax(arr1);
		
		int ansmin2 = getMin(arr2);
		int ansmax2 = getMax(arr2);
		
		System.out.println("Iterative Approch :");
		
		if(ansmin1==min1 && max1==ansmax1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output Max :"+max1+" Min :"+min1);
			System.out.println("Your Output Max :"+ansmax1+" Min :"+ansmin1);
		}
		if(ansmin2==min2 && max2==ansmax2) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output Max :"+max2+" Min :"+min2);
			System.out.println("Your Output Max :"+ansmax2+" Min :"+ansmin2);
		}
		
		
		
//		get answer 
		int [] output1 = getMinMax(arr1);
		int [] output2 = getMinMax(arr2);
//		ans 1
		ansmin1= output1[0];
		ansmin1= output1[1];
//		ans 2
		ansmin2= output2[0];
		ansmin2= output2[1];
	
		
		System.out.println("Iterative Single Function :");
		
		if(ansmin1==min1 && max1==ansmax1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output Max :"+max1+" Min :"+min1);
			System.out.println("Your Output Max :"+ansmax1+" Min :"+ansmin1);
		}
		if(ansmin2==min2 && max2==ansmax2) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output Max :"+max2+" Min :"+min2);
			System.out.println("Your Output Max :"+ansmax2+" Min :"+ansmin2);
		}
		
		System.out.println("Recursion Approch :");
		
		ansmin1 = getMinRec(arr1);
		ansmax1 = getMaxRec(arr1);
		ansmin2 = getMinRec(arr2);
		ansmax2 = getMaxRec(arr2);

		
		if(ansmin1==min1 && max1==ansmax1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output Max :"+max1+" Min :"+min1);
			System.out.println("Your Output Max :"+ansmax1+" Min :"+ansmin1);
		}
		if(ansmin2==min2 && max2==ansmax2) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output Max :"+max2+" Min :"+min2);
			System.out.println("Your Output Max :"+ansmax2+" Min :"+ansmin2);
		}
		
		System.out.println("Recursion Single Function :");
//		get answer 
		output1=getMinMax(arr1);		
		output2=getMinMax(arr2);
//		ans 1 
		ansmax1= output1[0];
		ansmin1= output1[1];
//		ans 2 
		ansmax2= output2[0];
		ansmin2= output2[1];
		
		if(ansmin1==min1 && max1==ansmax1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output Max :"+max1+" Min :"+min1);
			System.out.println("Your Output Max :"+ansmax1+" Min :"+ansmin1);
		}
		if(ansmin2==min2 && max2==ansmax2) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output Max :"+max2+" Min :"+min2);
			System.out.println("Your Output Max :"+ansmax2+" Min :"+ansmin2);
		}
		
	}
	
}