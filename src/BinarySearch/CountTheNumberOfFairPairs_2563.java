//2563. Count the Number of Fair Pairs
//Attempted
//Medium
//Topics
//Companies
//Hint
//Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
//
//A pair (i, j) is fair if:
//
//0 <= i < j < n, and
//lower <= nums[i] + nums[j] <= upper
// 
//
//Example 1:
//
//Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
//Output: 6
//Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
//Example 2:
//
//Input: nums = [1,7,9,2,5], lower = 11, upper = 11
//Output: 1
//Explanation: There is a single fair pair: (2,3).
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//nums.length == n
//-109 <= nums[i] <= 109
//-109 <= lower <= upper <= 109


package BinarySearch;

import java.util.Arrays;

public class CountTheNumberOfFairPairs_2563 {
//	brute force approch :
//	check every single pairs :
//	time complexity :O(n*n)
//	space complexity :O(1)

    public static long countFairPairsBruteForce(int[] nums, int lower, int upper) {
	        long counter=0;
	        for(int i =0;i<nums.length-1;i++){
	            for(int j=i+1;j<nums.length;j++){
	                int sum = nums[i]+nums[j];
	                if(sum>=lower && sum<=upper ){
	                    counter++;
	                }
	            }
	        }
	        return counter;
	    }
	
//	better force approch :
//    here we first sort the element
//    then we find the largest element and smallest element to add at nums[i]
//    to make the fair pair we use binary search to find largest element which is smaller then our target
//    then we just find the number of elements in btw it and return the sum of them
//	time complexity :O(n  log n)+O(n log n)
//	space complexity :O(1)
    
    public static long countFairPairsBetter(int[] nums, int lower, int upper) {
    	Arrays.sort(nums);
    	long res=0;
    	for (int i =0;i<nums.length;i++) {
    		int up= upper-nums[i]; 
    		int low= lower-nums[i];
    		res+= binarysearch(nums,i+1,nums.length-1,up+1)-binarysearch(nums,i+1,nums.length-1,low);
    	}
    	return res;
    	
    }
    

//    larger number then x 
	public static int binarysearch(int [] nums,int l, int r, int target) {
		while(l<=r) {
			int mid= l+(r-l)/2;
			if(nums[mid]>=target) {
				r=mid-1;
			}else {
				l=mid+1;
			}
		}
		return r;
	}

	public static void main(String[] args) {
		
		
		//Example 1:

		int [] nums1 = {0,1,7,4,4,5};
		int lower1 = 3, upper1 = 6;
		long  output1=6;
		

		//Example 2:

		int [] nums2 = {1,7,9,2,5};
		int lower2 = 11, upper2 = 11;
		long output2=1;
		
		System.out.println("Brute force approch :");
		
		long ans1 = countFairPairsBruteForce(nums1,lower1,upper1);
		long ans2 = countFairPairsBruteForce(nums2,lower2,upper2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		
		System.out.println("Better Approch :");
		
		ans1 = countFairPairsBetter(nums1,lower1,upper1);
		ans2 = countFairPairsBetter(nums2,lower2,upper2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}




	}

}
