//3356. Zero Array Transformation II
//Medium
//Topics
//Companies
//Hint
//You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].
//
//Each queries[i] represents the following action on nums:
//
//Decrement the value at each index in the range [li, ri] in nums by at most vali.
//The amount by which each value is decremented can be chosen independently for each index.
//A Zero Array is an array with all its elements equal to 0.
//
//Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, nums becomes a Zero Array. If no such k exists, return -1.
//
// 
//
//Example 1:
//
//Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
//
//Output: 2
//
//Explanation:
//
//For i = 0 (l = 0, r = 2, val = 1):
//Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
//The array will become [1, 0, 1].
//For i = 1 (l = 0, r = 2, val = 1):
//Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
//The array will become [0, 0, 0], which is a Zero Array. Therefore, the minimum value of k is 2.
//Example 2:
//
//Input: nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]
//
//Output: -1
//
//Explanation:
//
//For i = 0 (l = 1, r = 3, val = 2):
//Decrement values at indices [1, 2, 3] by [2, 2, 1] respectively.
//The array will become [4, 1, 0, 0].
//For i = 1 (l = 0, r = 2, val = 1):
//Decrement values at indices [0, 1, 2] by [1, 1, 0] respectively.
//The array will become [3, 0, 0, 0], which is not a Zero Array.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//0 <= nums[i] <= 5 * 105
//1 <= queries.length <= 105
//queries[i].length == 3
//0 <= li <= ri < nums.length
//1 <= vali <= 5

package BinarySearch;

import java.util.Arrays;

public class ZeroArrayTransformationII_3356 {
//	brute force :
//	apply each query untill it does not become all elements 0;
//  time complexity :O(Q * N)
//	Space complexity :O(1)
	public static int minZeroArrayBruteForce(int[] nums, int[][] queries) {
		int ans=-1;
		if(checkZeroArray(nums)) return 0;
		for(int i =0;i<queries.length;i++) {
			int l=queries[i][0];
			int r=queries[i][1];
			int val=queries[i][2];
			for(int j=l;j<=r;j++) {
				if (nums[j]==0) {continue;}
				if(nums[j]<val) {
					nums[j]=0;
				}else {
					nums[j]=nums[j]-val;
				}
			}
			if(checkZeroArray(nums)) {
				ans=i+1;
				break;
			}
		}
        return ans;
    }
//	better approch :
//	use binary search :
//	find mid and apply all query from 0 till mid  and check it satisfy the condition 
//	if yes then check left hand side other wise right hand side 
//	time complexity : O(Q n log Q)	
//	space complexity : O(n)
	
	public static int minZeroArrayBetter(int[] nums, int[][] queries) {
		if(checkZeroArray(nums)) return 0;
		int start=0;
		int end= queries.length-1;
		int res=-1;
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(applyQuery(nums.clone(), queries, mid)) {
				end=mid-1;
				res=mid+1;
			}else {
				start=mid+1;
			}
		}
		return res;
	
	}
	public static boolean applyQuery(int [] nums, int [][] queries,int mid) {
		for(int i =0;i<=mid;i++) {
			int l=queries[i][0];
			int r=queries[i][1];
			int val=queries[i][2];
			for(int j=l;j<=r;j++) {
				if(nums[j]==0) {continue;}
				if(nums[j]<val) {nums[j]=0;}
				if(nums[j]>=val) {nums[j]=nums[j]-val;}
			}
		}
		return checkZeroArray(nums);
	}
	
//	Best approch :
//	use binary search :
//	and difference array techinque which allow us to take a range opration on array in O(1) time and O(n) space
//	find mid and apply all query from 0 till mid  and check it satisfy the condition 
//	if yes then check left hand side other wise right hand side 
//	to reduce the update range time we can  use difference arrayy 
//	where if index l=1, r=3
//	we will create a diff array and update index l of diff[l]-= val
//	and also update diff[r+1] +=val;
//	now once all query maps on that make the diff as prefix  sum array
//	now just add both diff array and nums with each other element by elements
//	space complexity : O((Q + n) log Q)
//	time complexity : O(n)	
	
	public static int minZeroArrayBest(int[] nums, int[][] queries) {
		if(checkZeroArray(nums)) return 0;
		
		int start=0;
		int end= queries.length-1;
		int res=-1;
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(applyQueryDiffSum(nums.clone(), queries, mid)) {
				end=mid-1;
				res=mid+1;
			}else {
				start=mid+1;
			}
		}
		return res;
		
	}
	public static boolean applyQueryDiffSum(int [] nums, int [][] queries,int mid) {
		
		int [] diff = new int [nums.length];
		for(int i =0;i<=mid;i++) {
			int l=queries[i][0];
			int r=queries[i][1];
			int val=queries[i][2];
			diff[l]+=-val;
			if(r+1<diff.length) {diff[r+1]+=val;}
		}
		int cf=0;
		for(int i =0;i<diff.length;i++) {
			cf=cf+diff[i];
			diff[i]=cf;
		}
		for(int i =0;i<diff.length;i++) {
			nums[i]=nums[i]+diff[i];
		}
		
		return checkZeroArray(nums);
	}

	public static boolean checkZeroArray(int [] arr) {
		for(int x: arr) {
			if(x>0)  return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		//Example 1:
		
		int [] nums1 = {2,0,2};
		int [][] queries1 = {{0,2,1},{0,2,1},{1,1,3}};
		int output1=2;

		//Example 2:

		int []nums2 = {4,3,2,1};
		int [][] queries2= {{1,3,2},{0,2,1}};
		int output2=-1;
		
		//Example 3:
		
		int []nums3 = {0};
		int [][] queries3= {{0,0,2},{0,0,4},{0,0,4},{0,0,3},{0,0,5}};
		int output3=0;
		
		int  ans1= minZeroArrayBruteForce(nums1, queries1);
		int  ans2= minZeroArrayBruteForce(nums2, queries2);
		int  ans3= minZeroArrayBruteForce(nums3, queries3);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));	}
		
		System.out.println("Better Approch :");
		
		
		nums1 = new int [] {2,0,2};
		nums2 = new int [] {4,3,2,1};
		nums3 = new int []  {0};
		
		ans1= minZeroArrayBetter(nums1, queries1);
		ans2= minZeroArrayBetter(nums2, queries2);
		ans3= minZeroArrayBetter(nums3, queries3);
		
		
		if(output1== ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(output2== ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		System.out.println("Best Approch :");
		
		
		nums1 = new int [] {2,0,2};
		nums2 = new int [] {4,3,2,1};
		nums3 = new int []  {0};
		
		ans1= minZeroArrayBetter(nums1, queries1);
		ans2= minZeroArrayBetter(nums2, queries2);
		ans3= minZeroArrayBetter(nums3, queries3);
		
		
		if(output1== ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(output2== ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}

		


	}

}
