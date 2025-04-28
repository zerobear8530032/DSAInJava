//2302. Count Subarrays With Score Less Than K
//Hard
//Topics
//Companies
//Hint
//The score of an array is defined as the product of its sum and its length.
//
//For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
//Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose score is strictly less than k.
//
//A subarray is a contiguous sequence of elements within an array.
//
// 
//
//Example 1:
//
//Input: nums = [2,1,4,3,5], k = 10
//Output: 6
//Explanation:
//The 6 subarrays having scores less than 10 are:
//- [2] with score 2 * 1 = 2.
//- [1] with score 1 * 1 = 1.
//- [4] with score 4 * 1 = 4.
//- [3] with score 3 * 1 = 3. 
//- [5] with score 5 * 1 = 5.
//- [2,1] with score (2 + 1) * 2 = 6.
//Note that subarrays such as [1,4] and [4,3,5] are not considered because their scores are 10 and 36 respectively, while we need scores strictly less than 10.
//Example 2:
//
//Input: nums = [1,1,1], k = 5
//Output: 5
//Explanation:
//Every subarray except [1,1,1] has a score less than 5.
//[1,1,1] has a score (1 + 1 + 1) * 3 = 9, which is greater than 5.
//Thus, there are 5 subarrays having scores less than 5.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 105
//1 <= k <= 1015


package slidingwindow;

public class CountSubarraysWithScoreLessThanK_2302 {
	
//	brute force approch :
//	generate every single sub array and check comdition
//	time complexity :O(n^3)
//	space complexity :O(1)
	
	public static long countSubarraysBruteForce(int[] nums, long k) {
		int count =0;
		for(int i =0;i<nums.length;i++) {
			for(int j =i;j<nums.length;j++) {
				int sum=0;
				int size=0;
				for(int l=i;l<=j;l++) {
					sum+=nums[l];
					size++;
				}
				if(sum*size<k) {
					count++;
				}
			}
		}
		
		return count;
    }
	
//	better approch :
//	efficeintly generate every single sub array and check comdition
//	time complexity :O(n^2)
//	space complexity :O(1)
	
	public static long countSubarraysBetter(int[] nums, long k) {
		int count =0;
		for(int i =0;i<nums.length;i++) {
			int sum=0;
			int size=0;
			for(int j =i;j<nums.length;j++) {
				sum+=nums[j];
				size++;
				if(sum*size<k) {
					count++;
				}
			}
			sum-=nums[i];
		}
		
		return count;
	}
	
	
//	Best approch :
//	by using sliding window we will find the largest sub array which satisfy the
//	condition then we will take all sub array from largest subarray
//	at each place using formula n*(n+1)/2	
//	this works because if n = 5 then all sub array btw 0,5 will fall in same condition
//	then total number of sub array from are 5+4+3+2+1 which is sum of all n numbers
//	time complexity :O(n)
//	space complexity :O(1)
	
	public static long countSubarraysBest(int[] nums, long k) {
		long count =0;
		int l=0;
		int n=nums.length;
		long sum =0;
		for(int r=0;r<n;r++) {
			sum+=nums[r];
			while(l<=r && (sum* (r-l+1)) >=k ) {
				sum-=nums[l];
				l++;
			}
			count+= (r-l+1);
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		//Example 1:
		//
		int [] nums1 = {2,1,4,3,5};
		int k1 = 10;
		int output1=6;
		
		//Example 2:

		int [] nums2 = {1,1,1};
		int k2 = 5;
		int output2=5;
		
		//Example 3:
		
		int [] nums3 = {1,1,1,1,1};
		int k3 = 120;
		int output3=15;
		
		
		System.out.println("Brute Force Approch :");
		
		long ans1=countSubarraysBruteForce(nums1,k1);
		long ans2=countSubarraysBruteForce(nums2,k2);
		long ans3=countSubarraysBruteForce(nums3,k3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		System.out.println("Better Approch :");
		
		ans1=countSubarraysBetter(nums1,k1);
		ans2=countSubarraysBetter(nums2,k2);
		ans3=countSubarraysBetter(nums3,k3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		System.out.println("Best Approch :");
		
		ans1=countSubarraysBest(nums1,k1);
		ans2=countSubarraysBest(nums2,k2);
		ans3=countSubarraysBest(nums3,k3);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}



	}

}
