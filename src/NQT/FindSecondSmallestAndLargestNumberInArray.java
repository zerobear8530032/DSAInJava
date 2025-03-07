//Find Second Smallest and Second Largest Element in an array
//
//
//716
//
//16
//Problem Statement: Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.
//
//Examples
//Example 1:
//Input:
// [1,2,4,7,7,5]
//Output:
// Second Smallest : 2
//	Second Largest : 5
//Explanation:
// The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and second smallest is 2
//
//Example 2:
//Input:
// [1]
//Output:
// Second Smallest : -1
//	Second Largest : -1
//Explanation:
// Since there is only one element in the array, it is the largest and smallest element present in the array. There is no second largest or second smallest element present.

package NQT;

import java.util.Arrays;

public class FindSecondSmallestAndLargestNumberInArray {

	public static int [] getSecondSmallestLargestBruteForce(int [] arr) {
		if(arr.length<=1) return new int[] {-1,-1};
		Arrays.sort(arr);
		int secondsmallest=-1;
		for(int i =0;i<arr.length;i++) {
			if(arr[0]<arr[i]) {
				secondsmallest=arr[i];
				break;
			}
		}
		int secondlargest = 0;
		for(int i =arr.length-1;i>=0;i--) {
			if(arr[arr.length-1]>arr[i]) {
				secondlargest=arr[i];
				break;
			}
		}
		
		return new int [] {secondlargest,secondsmallest };
	}
	public static boolean check(int ans [],int output[]) {
		if(ans.length!=output.length) return false;
		for(int i=0;i<ans.length;i++) {
			if (ans[i]!= output[i]) return false;
		}
		return true;
	}
	
	public static int[] getSecondSmallestLargestBetter(int[] arr) {
		if (arr.length<=1) return new int[] {-1,-1};
		
		int secondMax= Integer.MIN_VALUE;
		int Max= Integer.MIN_VALUE;
		int secondMin= Integer.MAX_VALUE;
		int Min= Integer.MAX_VALUE;
		
		for(int i =0;i<arr.length;i++) {
			Max=Math.max(Max, arr[i]);
			Min=Math.min(Min, arr[i]);
		}
		for(int i =0;i<arr.length;i++) {
			if(Max!=arr[i]) {
				secondMax=Math.max(secondMax, arr[i]);
			}
			if(Min!=arr[i]) {
				secondMin=Math.min(secondMin, arr[i]);				
			}
		}
		
		return new int []{secondMax,secondMin};
		
	}
	public static int[] getSecondSmallestLargestBest(int[] arr) {
		if (arr.length<=1) return new int[] {-1,-1};
		
		int secondMax= Integer.MIN_VALUE;
		int max= Integer.MIN_VALUE;
		int secondMin= Integer.MAX_VALUE;
		int min= Integer.MAX_VALUE;
		
		for(int i =0;i<arr.length;i++) {
			if(arr[i]<min) {
				secondMin=min;
				min=arr[i];
			}else if(arr[i]< secondMin  && arr[i]!=min) {
				secondMin=arr[i];
			}
			
			if(arr[i]>max) {
				secondMax=max;
				max=arr[i];
			}else if(arr[i]> secondMax && arr[i]!=max) {
				secondMax=arr[i];
			}
			
		}
		
		
		return new int []{secondMax,secondMin};
		
	}

	
	public static void main(String[] args) {
		//Example 1:
		int [] arr1= {1,2,4,7,7,5};
		int [] output1= {5,2};
		
		
		//Example 2:	
		int [] arr2= {1};
		int [] output2= {-1,-1};
		
		int []ans1=getSecondSmallestLargestBruteForce(arr1);
		int []ans2=getSecondSmallestLargestBruteForce(arr2);
		
		if(check(output1,ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(ans1));
		}
		if(check(output2,ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(ans2));
		}
		System.out.println("Better Approch :");
		
		
		//Example 1:
		arr1= new int [] {1,2,4,7,7,5};
		//Example 2:	
		arr2= new int [] {1};
		
		 ans1 = getSecondSmallestLargestBetter(arr1);
		 ans2 = getSecondSmallestLargestBetter(arr2);
		 
		 if(check(output1,ans1)) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+Arrays.toString(output1));
				System.out.println("Your Answer :"+ Arrays.toString(ans1));
			}
			if(check(output2,ans2)) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+Arrays.toString(output2));
				System.out.println("Your Answer :"+ Arrays.toString(ans2));
			}
			
			System.out.println("Best Approch :");
			
			ans1 = getSecondSmallestLargestBest(arr1);
			ans2 = getSecondSmallestLargestBest(arr2);
			
			if(check(output1,ans1)) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+Arrays.toString(output1));
				System.out.println("Your Answer :"+ Arrays.toString(ans1));
			}
			if(check(output2,ans2)) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+Arrays.toString(output2));
				System.out.println("Your Answer :"+ Arrays.toString(ans2));
			}
	}
	
}
