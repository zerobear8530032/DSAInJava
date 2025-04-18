//2176. Count Equal and Divisible Pairs in an Array
//Solved
//Easy
//Topics
//Companies
//Hint
//Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.
// 
//
//Example 1:
//
//Input: nums = [3,1,2,2,2,1,3], k = 2
//Output: 4
//Explanation:
//There are 4 pairs that meet all the requirements:
//- nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
//- nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
//- nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
//- nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.
//Example 2:
//
//Input: nums = [1,2,3,4], k = 1
//Output: 0
//Explanation: Since no value in nums is repeated, there are no pairs (i,j) that meet all the requirements.
// 
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= nums[i], k <= 100


package Arrays;

public class CountEqualAndDivisiblePairsInAnArray_2176 {
	
//	brute force approch :
//	taking every single pairs :
//	and checking conditions
//	time complexity :O(n^2)
//	space complexity :O(1)
	    public static int countPairs(int[] nums, int k) {
	        int ans=0;
	    for(int i =0;i<nums.length-1;i++){
	        for(int j=i+1;j<nums.length;j++){
	            if(nums[i]==nums[j] && (i*j)%k==0){
	                ans++;
	            }
	        }
	    }    
	    return ans;
	    }
//	another brute force approch :
//	we can create a hashmap of 
//	each element with its key and a list of index as values
//	then we can iterate over entry and check every single pairs
//	this will allow us to remove the requirement to check every single unequal pairs;
//	but in worst case where a single number is repeated in entire array it is O(n^2)
//	time complexity :O(n^2)
//	space complexity :O(n^2)
	    public static int countPairsBruteForce2(int[] nums, int k) {
	    	int ans=0;
	    	for(int i =0;i<nums.length-1;i++){
	    		for(int j=i+1;j<nums.length;j++){
	    			if(nums[i]==nums[j] && (i*j)%k==0){
	    				ans++;
	    			}
	    		}
	    	}    
	    	return ans;
	    }
	

	public static void main(String[] args) {
		
		//Example 1:
		
		int [] nums1 = {3,1,2,2,2,1,3};
		int k1 = 2;
		int output1=4;

		//Example 2:

		int [] nums2 = {1,2,3,4};
		int k2 = 1;
		int output2=0;

		System.out.println("Brute Force Approch 1 :");
		
		System.out.println("Better Approch :");
		
		 int ans1 = countPairs(nums1,k1);
		 int ans2 = countPairs(nums2,k2);
		
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

		
		System.out.println("Brute Force Approch 2 :");

		ans1 = countPairsBruteForce2(nums1,k1);
		ans2 = countPairsBruteForce2(nums2,k2);
		
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
