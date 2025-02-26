//	189. Rotate Array
//	Solved
//	Medium
//	Topics
//	Companies
//	Hint
//	Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//	
//	 
//	
//	Example 1:
//	
//	Input: nums = [1,2,3,4,5,6,7], k = 3
//	Output: [5,6,7,1,2,3,4]
//	Explanation:
//	rotate 1 steps to the right: [7,1,2,3,4,5,6]
//	rotate 2 steps to the right: [6,7,1,2,3,4,5]
//	rotate 3 steps to the right: [5,6,7,1,2,3,4]
//	Example 2:
//	
//	Input: nums = [-1,-100,3,99], k = 2
//	Output: [3,99,-1,-100]
//	Explanation: 
//	rotate 1 steps to the right: [99,-1,-100,3]
//	rotate 2 steps to the right: [3,99,-1,-100]
//	 
//	
//	Constraints:
//	
//	1 <= nums.length <= 105
//	-231 <= nums[i] <= 231 - 1
//	0 <= k <= 105
//	 
//	
//	Follow up:
//	
//	Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
//	Could you do it in-place with O(1) extra space?

package Arrays;

import java.util.Arrays;

public class RotateArray_189 {
	
//	brute force : using simulation we can rotate the array k times and get our answer :
//	will not get accepted  
//	time complexity : O(N *K)
//	space complexity : O(1)	
	
	 public static void rotateBruteForce(int[] nums, int k) {
		 for(int i =0;i<k;i++) {
			 rotatearr(nums);
		 }
	        
	    }
	 public static void rotatearr(int [] nums) {
		 int len = nums.length;
		 int lastelement = nums[len-1];
		 for(int i = len-1;i>0;i--) {
			 nums[i]= nums[i-1];
		 }
		 nums[0]= lastelement;
	 }
	 
//	 better approch : as we can see if we rotate an array k time if we rotate an array n times where 
//	 the n is the length of array the entire array again return to its inital position
//	 means we can remove such n rotation in order to get what we in letter time 
//	 this will also not get passed in this constrain we need to do better 
//	 time complexity O(n* K%n);
//	 space complexity O(1);
	 
	 public static void rotateBetter(int[] nums, int k) {
		 int n = nums.length;
		 for(int i =0;i<k%n;i++) {
			 rotatearr(nums);
		 }
		 
	 }
	 
//	 Best approch : we can use an algorith in order to reverse an array :
//	 how this works :
//	 let am array : [1,2,3,4,5,6,7]
//	 first reverse the eniter  array :
//	 [7,6,5,4,3,2,1]
//	 now we need to reverse from 0 till k%n-1 
//	 why k%n : because we discuss in better array once we rotate k time it return the inital position
//	 0 till k%n-1 : [7,6,5]
//	 reverse only this portion array will be :
//	 [5,6,7,4,3,2,1]
//	 now we just need to reverse the remaining part : k%n till n-1 (length of array): 
//	 [4,3,2,1]: reverse this :
//	 [5,6,7,1,2,3,4]: this is our output 
//	 time complexity O(n);
//	 space complexity O(1);
	 
	 public static void rotateBest(int[] nums, int k) {
		 
		 int n =nums.length;
		 if(n<1) {
			 return;
		 }
//		 first reverse entire array :
		 reversearr(0,nums.length-1,nums);
//		 now just reverse from 0 till k-1 
		 reversearr(0,k%n-1,nums);
//		 last reverse from k till n-1
		 reversearr(k,n-1,nums);
		 
		 
	 }
	 public static void reversearr(int start,int end ,int [] arr) {
		 while(start<=end) {
			 int  t=arr[start];
			 arr[start]=arr[end];
			 arr[end]=t;
			 start++;
			 end--;
		 }
		 
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

		int [] nums1= {1,2,3,4,5,6,7};
		int k1 = 3;
		int [] output1= {5,6,7,1,2,3,4};
		
		//Example 2:

		int []nums2= {-1,-100,3,99};
		int k2 = 2;
		int [] output2= {3,99,-1,-100};

		//Example 2:
		
		int []nums3= {-1};
		int k3 = 2;
		int [] output3= {-1};
		
		
		System.out.println("Brute Force  Approch :");
		
		rotateBruteForce(nums1,k1);
		rotateBruteForce(nums2,k2);
		rotateBruteForce(nums3,k3);
        
        
        if(check(nums1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(nums1));
		}
		if(check(nums2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(nums2));
		}
		
		if(check(nums3,output3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(nums2));
		}

		System.out.println("Better Approch :");
		
		//Example 1:
		
		nums1= new int [] {1,2,3,4,5,6,7};
		
		//Example 2:

		nums2=new int [] {-1,-100,3,99};

		//Example 3:
		
		nums3=new int [] {-1};
		
		
		rotateBetter(nums1,k1);
	  	rotateBetter(nums2,k2);
	  	rotateBetter(nums3,k3);
        
        
        if(check(nums1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(nums1));
		}
		if(check(nums2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(nums2));
		}
		
		if(check(nums3,output3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(nums2));
		}
		
		
		System.out.println("Better Approch :");
		
		//Example 1:
		
		nums1= new int [] {1,2,3,4,5,6,7};
		
		//Example 2:
		
		nums2=new int [] {-1,-100,3,99};
		
		//Example 3:
		
		nums3=new int [] {-1};
		
		
		rotateBest(nums1,k1);
		rotateBest(nums2,k2);
		rotateBest(nums3,k3);
		
		
		if(check(nums1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(nums1));
		}
		if(check(nums2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(nums2));
		}
		
		if(check(nums3,output3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(nums2));
		}

	}

}

