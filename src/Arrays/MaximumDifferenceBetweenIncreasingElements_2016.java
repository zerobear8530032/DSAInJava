//2016. Maximum Difference Between Increasing Elements
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].
//
//Return the maximum difference. If no such i and j exists, return -1.
//
// 
//
//Example 1:
//
//Input: nums = [7,1,5,4]
//Output: 4
//Explanation:
//The maximum difference occurs with i = 1 and j = 2, nums[j] - nums[i] = 5 - 1 = 4.
//Note that with i = 1 and j = 0, the difference nums[j] - nums[i] = 7 - 1 = 6, but i > j, so it is not valid.
//Example 2:
//
//Input: nums = [9,4,3,2]
//Output: -1
//Explanation:
//There is no i and j such that i < j and nums[i] < nums[j].
//Example 3:
//
//Input: nums = [1,5,2,10]
//Output: 9
//Explanation:
//The maximum difference occurs with i = 0 and j = 3, nums[j] - nums[i] = 10 - 1 = 9.
// 
//
//Constraints:
//
//n == nums.length
//2 <= n <= 1000
//1 <= nums[i] <= 109
package Arrays;



public class MaximumDifferenceBetweenIncreasingElements_2016 {
//brute force solution:
// we check every pair:
//	time complexity :O(n*n)
//	space complexity :O(1)
	public static int maximumDifferenceBruteForce(int[] nums) {
		int res=-1;
		for(int i =0;i<nums.length-1;i++){
			for(int j = i+1;j<nums.length;j++) {
				if(nums[i]<nums[j]) {
					int diff = nums[j]-nums[i];
					res=Math.max(res, diff);
				}
			}
			
		}
		return res;
	}
//best approch:
// we check froms start to end where first element are consider min when we see a number lesser then currmin
//	we update new min other wise if its greater we will calculare difference and get max difference:
//	time complexity :O(n)
//	space complexity :O(1)
	  public static int maximumDifferenceBest(int[] nums) {
	        int res=-1;
	        int minElement = nums[0];
	        for(int i =1;i<nums.length;i++){
	            if(minElement <nums[i]){
	                res=Math.max(nums[i]-minElement , res);
	            }else{
	                minElement=nums[i];
	            }
	        }
	        return res;
	    }
	public static void main(String[] args) {

		//Example 1:

		int []nums1 = {7,1,5,4};
		int output1 = 4;

		//Example 2:

		int []nums2 = {9,4,3,2};
		int output2 = -1;
		

		//Example 3:

		int []nums3 = {1,5,2,10};
		int output3 = 9;
		
		
    	System.out.println("Brute Force Approch :");
    	
    	int ans1=maximumDifferenceBruteForce(nums1);
    	int ans2=maximumDifferenceBruteForce(nums2);
    	int ans3=maximumDifferenceBruteForce(nums3);


    	
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
    	
    	System.out.println("Best Approch :");
    	ans1=maximumDifferenceBest(nums1);
    	ans2=maximumDifferenceBest(nums2);
    	ans3=maximumDifferenceBest(nums3);
    	
    	
    	
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

