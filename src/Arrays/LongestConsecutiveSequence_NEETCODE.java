//Longest Consecutive Sequence
//Solved 
//Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.
//
//A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.
//
//You must write an algorithm that runs in O(n) time.
//
//Example 1:
//
//Input: nums = [2,20,4,10,3,4,5]
//
//Output: 4
//Explanation: The longest consecutive sequence is [2, 3, 4, 5].
//
//Example 2:
//
//Input: nums = [0,3,2,5,4,6,1,1]
//
//Output: 7
//Constraints:
//
//0 <= nums.length <= 1000
//-10^9 <= nums[i] <= 10^9


package Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence_NEETCODE {
//	brute force approch 
//	sort the array and find the longest sequence by checking curre index and next index 

//	time complexity :O(n log n);

	public static int longestConsecutiveBruteForce(int[] nums) {
//		sort tthe array :
		Arrays.sort(nums);
		int n=nums.length;
		if(n==0) return 0;
		int count=0;
		int ans =0;
		for(int i=0;i<n-1;i++ ) {
			if(nums[i]==nums[i+1]) {
				continue;
			}
			if(nums[i]==nums[i+1]-1) {
				count++;
			}else {
				count=0;
			}
			ans= Math.max(ans, count);
		}
		return ans+1;
		
	}
	
//	best approch :
//	here we use a single hash set and put each element in it 
//	if we visualize every thing on a big  number line then each and every sequence willl be with each other
//	now we can check  each element previous present of not means if nums[i] -1 is present on the array
//	if its present means we can say its not a start of an sequence cause there is a smaller number then that
//	we will skip it and keep checking each nums[i] there is a nums[ii]-1 is present or not
//	when we found it we will have a infinite loop untill the nums[i]+1 are not present in the array 
//	means if 1,2,3,4,100,200,201
//	then  if we are at 1 we will check from 1 till untill 1+x is not present in the hashset in this case we will only get tilll4
//	if we count it thats our answer
//	to check each numeber present or not we can use a hashset this will remove duplicates also
//	at most we will visit a number 2 times 
//	time complexity :O(n);
//	space complexity :O(n);
	public static int longestConsecutiveBest(int[] nums) {
		HashSet<Integer> set= new HashSet();
		int ans=0;
//		hashset of nums:
		for(int x:nums) {
			set.add(x);
		}
		for(int i=0;i<nums.length;i++) {
			if(!set.contains(nums[i]-1)) {
				int count=0;
				int x = nums[i];
				while(set.contains(x)) {// check number exists 
					x++;// get next number
					count++;
				}
				ans=Math.max(ans, count);
			}
		}
		return ans;
		
				
	}

	public static void main(String[] args) {
		
		
		
		//Example 1:
		
		int [] nums1 = {2,20,4,10,3,4,5};
		int output1=4;
		
		//Example 2:
		
		int [] nums2 = {0,3,2,5,4,6,1,1};
		int output2=7;

		//Example 3:
		
		int [] nums3= {};
		int output3=0;
		
		//Example 4:
		
		int [] nums4= {0,0};
		int output4=1;
		
		
		System.out.println("Brute Force Approch");
		int ans1=longestConsecutiveBruteForce(nums1);
		int ans2=longestConsecutiveBruteForce(nums2);
		int ans3=longestConsecutiveBruteForce(nums3);
		int ans4=longestConsecutiveBruteForce(nums4);
		
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
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}
		
		System.out.println("Best Approch");
		
		ans1=longestConsecutiveBest(nums1);
		ans2=longestConsecutiveBest(nums2);
		ans3=longestConsecutiveBest(nums3);
		ans4=longestConsecutiveBest(nums4);
		
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
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}
	}

}
