//34. Find First and Last Position of Element in Sorted Array
//Solved
//Medium
//Topics
//Companies
//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.
//
// 
//
//Example 1:
//
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:
//
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
//Example 3:
//
//Input: nums = [], target = 0
//Output: [-1,-1]
// 
//
//Constraints:
//
//0 <= nums.length <= 105
//-109 <= nums[i] <= 109
//nums is a non-decreasing array.
//-109 <= target <= 109


package Arrays;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
	
	
//	brute Force approch :
//  by using 2 pointer we can check the target both sides at once and return indexes if found other wise
//	return -1,-1
//	time complexity :    O(n) 
//	Space complexity :    O(1) 
	 public static int[] searchRangeBrute(int[] nums, int target) {
		 int start =0;
		 int end = nums.length-1;
		 int ans []=  {-1,-1};
		 boolean foundstart=false;
		 boolean foundend=false;
		 while(start<=end ) {
			 if(nums[start]==target) {
				 ans[0]=start;
				 foundstart=true;
			 }else {
				 start++;				 
			 }
			 if(nums[end]==target) {
				 ans[1]=end;				 
				 foundend=true;
			 }else {
				 end--;				 
			 }
			 if(foundstart && foundend) {
				 break;
			 }
			 
		 }
		 
	        return ans;
	    }

//	better Approch  :
//	use binary search once we find target find the left side of the array then find the right side of  the array 
//	 if target is not found return -1,-1;
//	time complexity :    O(log N) 
//	Space complexity :    O(1) 
		 public static int[] searchRangeBetter(int[] nums, int target) {
			 int start =0;
			 int end = nums.length-1;
			 int ans []=  {-1,-1};
//			 first find the target :
			 ans[0]=binarySearch(nums, target, true);
			 ans[1]=binarySearch(nums, target, false);
			 
			 
		     return ans;
		    }
		 public static int binarySearch(int [] arr,int target,boolean startindex) {
			int ans=-1;
			int s=0;
			int e=arr.length-1;
			while(s<=e) {
				int mid= s+(e-s)/2;
				if(arr[mid]<target) {
					s=mid+1;
				}else if(arr[mid]>target) {
					e=mid-1;
				}else {
					ans=mid;
					if(startindex) {
						e=mid-1;
					}else {
						s=mid+1;
					}
					
					
				}
			}
			return ans;
		 }
		
		 	public static boolean check(int [] ans,int []output) {
		 		if(ans.length!=output.length) {
		 			return false;
		 		}
		 		for(int i=0;i<ans.length;i++) {
		 			if(ans[i]!=output[i]) {
		 				return false;
		 			}
		 		}
		 		return true;
		 		
		 	}
	

	public static void main(String[] args) {
		
		//Example 1:
		//
		int []nums1 = {5,7,7,8,8,10};
		int  target1 = 8;
		int []output1 = {3,4};
		
		//Example 2:
		//
		int []nums2 = {5,7,7,8,8,10};
		int  target2 = 6;
		int []output2 = {-1,-1};
		
		//Example 3:
		int []nums3 = {};
		int  target3 = 0;
		int []output3 = {-1,-1};
		System.out.println("Brute Force  Approch :");
		
		int[] ans1=searchRangeBrute(nums1,target1);
	  	int[] ans2=searchRangeBrute(nums2,target2);
	  	int[] ans3=searchRangeBrute(nums2,target3);
        
        
        if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}

		System.out.println("Better Approch :");
		
		ans1=searchRangeBetter(nums1,target1);
	  	ans2=searchRangeBetter(nums2,target2);
	  	ans3=searchRangeBetter(nums2,target3);
        
        
        if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}



	}

}
