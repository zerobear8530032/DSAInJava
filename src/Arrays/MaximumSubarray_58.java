//	53. Maximum Subarray
//	Solved
//	Medium
//	Topics
//	Companies
//	Given an integer array nums, find the 
//	subarray
//	 with the largest sum, and return its sum.
//	
//	 
//	
//	Example 1:
//	
//	Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//	Output: 6
//	Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//	Example 2:
//	
//	Input: nums = [1]
//	Output: 1
//	Explanation: The subarray [1] has the largest sum 1.
//	Example 3:
//	
//	Input: nums = [5,4,-1,7,8]
//	Output: 23
//	Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
//	 
//	
//	Constraints:
//	
//	1 <= nums.length <= 105
//	-104 <= nums[i] <= 104
//	 
//	
//	Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


package Arrays;

import java.util.Arrays;

public class MaximumSubarray_58{
	
//	Brute Force Approch :
//	approch :
//	first loop initialize the starting point 
//	second loop nested loop initalize the ending point of sub array 
//	third loop sum all element btw i and j
//	after that we check the  max out of the all the sum and return max 
//	Time Complexity :O(n*n*n);
	
	
	  public  static int maxSubArrayBruteForce(int[] nums) {
		  
		  int max =Integer.MIN_VALUE;
		  for(int i=0;i<nums.length;i++) {
			  for(int j=i;j<nums.length;j++) {
				  int sum =0;
				  for(int k=i;k<=j;k++) {
					  sum+=nums[k];
				  }
				  max=Math.max(max, sum);
			  }
		  }
		  return max;

	    }
	  
	  
	  
//	  Better Approch :
//	  using recursion : approch 
//	  we first start with nums, nums.length-1 
//	  in each recursion we calculate the prev Max 
//	  and to calculate prevMax we will use Max(curr number, curr Number + prevMax)
//	  and we check it current max with the global max of entire max we get
//	  Time complexity :O(n)
//	  Space complexity :O(n)

	  static  int globalMax;
	  public  static int maxSubArrayBruteForceRecursion(int[] nums) {
		  globalMax =Integer.MIN_VALUE;
		  helperRecursion(nums, nums.length-1);
		  return globalMax;
	    }
	  public static int helperRecursion(int [] nums,int i) {
		  if(i==0) {// base case 
			  globalMax = Math.max(globalMax, nums[0]);
			  return nums[0];
		  }
		  int prevMax= helperRecursion(nums, i-1);// this will go to get previous recursion calls 
		  
		  // Calculate the current max subarray sum ending at index i
	        int currentMax = Math.max(nums[i], nums[i] + prevMax);
	        
	        // Update global maximum if needed
	        globalMax = Math.max(globalMax, currentMax);
		  return currentMax;// here if max is nums[i]-> means we are starting the new sub array
//		 if max is nums[i]+prevmax then we are going with old sub array  
	  }
	  
	  
//	  Recursion Memorization
//	  the memorization code is not efficient enough for this question because the tree is skeweed 
//	  towards one sided so their were almost no repetation of same sub problem
//	  here we just create a new array memo of same length and calculate the max sum and add it to
//	  the i th index in memo
//	  Time complexity :O(n)
//	  Space complexity :O(n)

	  
	    private static int[] memo; // Memoization array

	    public static int maxSubArrayRecursionUsingMemo(int[] nums) {
	        globalMax = Integer.MIN_VALUE;
	        memo = new int[nums.length]; // Allocate memo array
	        for (int i = 0; i < nums.length; i++) {
	            memo[i] = Integer.MIN_VALUE; // Initialize memo array with a special value
	        }
	        helperRecursionMemo(nums, nums.length - 1);
	        return globalMax;
	    }

	    public static int helperRecursionMemo(int[] nums, int i) {
	        if (i == 0) { // Base case
	            globalMax = Math.max(globalMax, nums[0]);
	            return nums[0];
	        }

	        // Return already computed value if available
	        if (memo[i] != Integer.MIN_VALUE) {
	        	System.out.println("memory get used");
	            return memo[i];
	        }

	        int prevMax = helperRecursionMemo(nums, i - 1);
	        
	        // Compute the current max subarray sum ending at index i
	        int currentMax = Math.max(nums[i], nums[i] + prevMax);

	        // Update global max if needed
	        globalMax = Math.max(globalMax, currentMax);

	        // Save the computed result in the memo array
	        memo[i] = currentMax;

	        return currentMax;
	    }
	    
//	  Kadans Algo:
//	    its a simple algo where we check from left to right
//	    when the curr sum reach less then 0 we start a new sub array 
//	    and find max of each subb array 
//	 
	    
	    
	        public static int maxSubArrayKadanAlgo(int[] nums) {
	            // Initialize the first element as the initial max sum
	            int currentMax = nums[0];
	            int globalMax = nums[0];

	            // Loop through the array starting from the second element
	            for (int i = 1; i < nums.length; i++) {
	                // Calculate the maximum sum at the current index
	                currentMax = Math.max(nums[i], nums[i] + currentMax);
	                
	                // Update globalMax if the currentMax is greater
	                globalMax = Math.max(globalMax, currentMax);
	            }

	            return globalMax;
	        }
	 	  
	  
	public static void main(String[] args) {
	//		Example 1:

			int []nums1 = {-2,1,-3,4,-1,2,1,-5,4};
			int output1=6;
			
	//		Example 2:

			int []nums2 = {1};
			int output2=1;

	//		Example 3:

			int []nums3 = {5,4,-1,7,8};
			int output3=23;
			
			int ans1 =maxSubArrayBruteForce(nums1);
	    	int ans2 =maxSubArrayBruteForce(nums2);
	    	int ans3 =maxSubArrayBruteForce(nums3);
	    	
	    	
	    	if(ans1==output1) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ output1);
				System.out.println("Your Answer :"+ ans1);
			}
			if(ans2==output2) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+output2);
				System.out.println("Your Answer :"+ ans2);
			}
			if(ans3==output3) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Expected Ouput :"+ output3);
				System.out.println("Your Answer :"+ ans3);
			}
			
			System.out.println("Recursion Brute Force");
			
			ans1 =maxSubArrayBruteForceRecursion(nums1);
			ans2 =maxSubArrayBruteForceRecursion(nums2);
			ans3 =maxSubArrayBruteForceRecursion(nums3);
			
			
			if(ans1==output1) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ output1);
				System.out.println("Your Answer :"+ ans1);
			}
			if(ans2==output2) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+output2);
				System.out.println("Your Answer :"+ ans2);
			}
			if(ans3==output3) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Expected Ouput :"+ output3);
				System.out.println("Your Answer :"+ ans3);
			}
			
			System.out.println("Recursion Memo ");
			
			ans1 =maxSubArrayRecursionUsingMemo(nums1);
			ans2 =maxSubArrayRecursionUsingMemo(nums2);
			ans3 =maxSubArrayRecursionUsingMemo(nums3);
			
			
			if(ans1==output1) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ output1);
				System.out.println("Your Answer :"+ ans1);
			}
			if(ans2==output2) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+output2);
				System.out.println("Your Answer :"+ ans2);
			}
			if(ans3==output3) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Expected Ouput :"+ output3);
				System.out.println("Your Answer :"+ ans3);
			}
			
			System.out.println("Recursion Memo ");
			
			ans1 =maxSubArrayKadanAlgo(nums1);
			ans2 =maxSubArrayKadanAlgo(nums2);
			ans3 =maxSubArrayKadanAlgo(nums3);
			
			
			if(ans1==output1) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ output1);
				System.out.println("Your Answer :"+ ans1);
			}
			if(ans2==output2) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+output2);
				System.out.println("Your Answer :"+ ans2);
			}
			if(ans3==output3) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Expected Ouput :"+ output3);
				System.out.println("Your Answer :"+ ans3);
			}
			
			
	}
}

