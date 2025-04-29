//2962. Count Subarrays Where Max Element Appears at Least K Times
//Solved
//Medium
//Topics
//Companies
//You are given an integer array nums and a positive integer k.
//
//Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
//
//A subarray is a contiguous sequence of elements within an array.
//
// 
//
//Example 1:
//
//Input: nums = [1,3,2,3,3], k = 2
//Output: 6
//Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
//Example 2:
//
//Input: nums = [1,4,2,1], k = 3
//Output: 0
//Explanation: No subarray contains the element 4 at least 3 times.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 106
//1 <= k <= 105

package slidingwindow;
class CountSubarraysWhereMaxElementAppearsAtLeastKTimes_2962 {
//	brute force approch :
//	generate every single sub array and check comdition
//	time complexity :O(n^3)
//	space complexity :O(1)
	
	public static long countSubarraysBruteForce(int[] nums, long k) {
		int max=Integer.MIN_VALUE;
		for(int x:nums) {
			max=Math.max(max, x);
		}
		long ans =0;
		for(int i =0;i<nums.length;i++) {
			for(int j =i;j<nums.length;j++) {
				int c=0; 
				for(int l=i;l<=j;l++) {
					if(nums[l]==max) {
						c++;
					}
				}
				if(k<=c) {
					ans++;
				}
			}
		}
		
		return ans;
    }
	
//	better approch :
//	efficeintly generate every single sub array and check comdition
//	time complexity :O(n^2)
//	space complexity :O(1)
	
	public static long countSubarraysBetter(int[] nums, long k) {
		int max=Integer.MIN_VALUE;
		for(int x:nums) {
			max=Math.max(max, x);
		}
		long ans =0;
		for(int i =0;i<nums.length;i++) {
			int count=0;
			for(int j =i;j<nums.length;j++) {
				if(nums[j]==max) {
					count++;
				}
				if(count>=k) {
					ans++;
				}
			}
			if(nums[i]==max) {
				count--;
			}
		}
		
		return ans;
	}
	
	
//	best approch :
//	we can use a approch where we find all subarray which have less then k times the 
//	max element then we just substract that with total number of sub array which we can 
//	get by sum of nums.length natural numbers
//	time complexity :O(n)
//	space complexity :O(1)
    public static long countSubarraysBest(int[] nums, int k) {
        int l=0;
        long ans =0;
        int max=Integer.MIN_VALUE;
        for(int x:nums){
            max=Math.max(max,x);
        }
        int n=nums.length;
        int maxCount=0;
        for(int r=0;r<n;r++){
            if(nums[r]==max){
                maxCount++;
            }
            while(l<=r && maxCount>=k){
                if(nums[l]==max){
                    maxCount--;
                }
                l++;
            }
            ans+=(r-l+1);
        }
        long totalsubarray = (long)n*(n+1)/2L;
        return totalsubarray-ans;
    }
    public static void main(String[] args) {
    	//Example 1:

    	int [] nums1 = {1,3,2,3,3};
    	int k1 = 2;
    	int output1=6;

    	//Example 2:

    	int [] nums2 = {1,4,2,1};
    	int k2 = 3;
    	int output2=0;
    	
    	
    	System.out.println("Brute Force Approch :");
		
		long ans1=countSubarraysBruteForce(nums1,k1);
		long ans2=countSubarraysBruteForce(nums2,k2);
		
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

		System.out.println("Better Approch :");
		
		ans1=countSubarraysBetter(nums1,k1);
		ans2=countSubarraysBetter(nums2,k2);

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

		System.out.println("Best Approch :");
		
		ans1=countSubarraysBest(nums1,k1);
		ans2=countSubarraysBest(nums2,k2);
		
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

	}
}