//1749. Maximum Absolute Sum of Any Subarray
//Medium
//Topics
//Companies
//Hint
//You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
//
//Return the maximum absolute sum of any (possibly empty) subarray of nums.
//
//Note that abs(x) is defined as follows:
//
//If x is a negative integer, then abs(x) = -x.
//If x is a non-negative integer, then abs(x) = x.
// 
//
//Example 1:
//
//Input: nums = [1,-3,2,3,-4]
//Output: 5
//Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
//Example 2:
//
//Input: nums = [2,-5,1,-4,3,-2]
//Output: 8
//Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//-104 <= nums[i] <= 104


package Arrays;

public class MaximumAbsoluteSumOfAnySubarray_1749 {
//	approch : take ebvery single subarray :
//	get sum of iit and find max absolute sub array 
//	time complexity :O(n*n)
//	Space complexity :O(1)

	public static int maxAbsoluteSumBruteForce(int[] nums) {
		int n = nums.length;
		int maxSum=0;
		for(int i =0;i<n;i++) {
			for(int j =i;j<n;j++) {
				int sum=0;
				for(int s=i;s<=j;s++) {
					sum+=nums[s];
				}
				maxSum=Math.max(maxSum, Math.abs(sum));
			}
		}
		return maxSum;
        
    }
	
//	approch : take every single subarray :
//	get sum of it and find max absolute sub array 
//	use running sum in order to optimize it
//	time complexity :O(n*n)
//	Space complexity :O(1)
	public static int maxAbsoluteSumBetter(int[] nums) {
		int n = nums.length;
		int maxSum=0;
		for(int i =0;i<n;i++) {
			int currsum =0;
			for(int j =i;j<n;j++) {
				currsum+=nums[j];
				maxSum=Math.max(maxSum, Math.abs(currsum));
			}
		}
		return maxSum;
		
	}
	
	
//	approch : Use kadans algorithm
//	use kadans algorithm which is simple we take 2 variable 
//	curr sum,maxsum, we calcualte currsum at each index
//	and update the maxsum with max of currsum 
//	but when the currsum become less then  0 we can say we reset the sum to 0 
//	as it means we start the sub array from here 
//	time complexity :O(n)
//	Space complexity :O(1)
	public static int maxAbsoluteSumBest(int[] nums) {
		int n = nums.length;
		int maxSum=Integer.MIN_VALUE;
		int currSum=0;
		for(int i =0;i<n;i++) {
			currSum+=nums[i];
			maxSum= Math.max(maxSum,currSum);
			if(currSum<0) {
				currSum=0;
			}
		}
		int minSum = Integer.MAX_VALUE;
		currSum = 0;
		for (int i = 0; i < n; i++) {  
		    currSum += nums[i];
		    minSum = Math.min(minSum, currSum);
		    if (currSum > 0) {
		        currSum = 0;  
		    }
		}
		return Math.max(maxSum, Math.abs(minSum));
	}

	
//	best optimization  approch : Use kadans algorithm
//	we can combine both loop as one single one
//	time complexity :O(n)
//	Space complexity :O(1)
	public static int maxAbsoluteSumOptimize(int[] nums) {
		int n = nums.length;
		int maxSum=Integer.MIN_VALUE;
		int minSum = Integer.MAX_VALUE;
		int maxcurrSum=0;
		int mincurrSum=0;
		for(int i =0;i<n;i++) {
			maxcurrSum+=nums[i];
			mincurrSum += nums[i];	
			maxSum= Math.max(maxSum,maxcurrSum);
			minSum = Math.min(minSum, mincurrSum);
			if(maxcurrSum<0) {
				maxcurrSum=0;
			}
			if (mincurrSum > 0) {
				mincurrSum = 0;  
			}
		}
		
		
		return Math.max(maxSum, Math.abs(minSum));
	}

	public static void main(String[] args) {
		//Example 1:
		
		int []nums1 = {1,-3,2,3,-4};
		int output1= 5;
		
		//Example 2:
		
		int [] nums2 = {2,-5,1,-4,3,-2};
		int output2=8;
		
		//Example 3:
		
		int [] nums3 = {-3,-5,-3,-2,-6,3,10,-10,-8,-3,0,10,3,-5,8,7,-9,-9,5,-8};
		int output3=27;
		
		System.out.println("Brute Force Approch :");
		
		int ans1 = maxAbsoluteSumBruteForce(nums1);
		int ans2 = maxAbsoluteSumBruteForce(nums2);
		int ans3 = maxAbsoluteSumBruteForce(nums3);
		
		
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2==ans2) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}

    	System.out.println("Better Approch :");
    	ans1 = maxAbsoluteSumBetter(nums1);
    	ans2 = maxAbsoluteSumBetter(nums2);
    	ans3 = maxAbsoluteSumBetter(nums3);
    	
    	
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
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}
    	
    	System.out.println("Best  Approch :");
    	ans1 = maxAbsoluteSumBest(nums1);
    	ans2 = maxAbsoluteSumBest(nums2);
    	ans3 = maxAbsoluteSumBest(nums3);
    	
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
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}

    	System.out.println("Best Optimize Approch :");
    	ans1 = maxAbsoluteSumOptimize(nums1);
    	ans2 = maxAbsoluteSumOptimize(nums2);
    	ans3 = maxAbsoluteSumOptimize(nums3);
    	
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
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}
    	
		
		
	}

}
