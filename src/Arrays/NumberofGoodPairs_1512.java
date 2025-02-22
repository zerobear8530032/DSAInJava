//1512. Number of Good Pairs
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an array of integers nums, return the number of good pairs.
//
//A pair (i, j) is called good if nums[i] == nums[j] and i < j.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,3,1,1,3]
//Output: 4
//Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
//Example 2:
//
//Input: nums = [1,1,1,1]
//Output: 6
//Explanation: Each pair in the array are good.
//Example 3:
//
//Input: nums = [1,2,3]
//Output: 0
// 
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 100
package Arrays;

import java.util.HashMap;

public class NumberofGoodPairs_1512 {
//	brute force approch :
//	create a pair counter =0;
//	use  loop where the first loop have iterator i which goes from 0 till length -1
//	use a nested loop where the iterator start from i+1 and goes till length
//	each time we check if (nums[i]==nums[j])
//	if these are equal we can say we can incremenet the pair counter 
//	at last we return the pair counter
//	time complexity :O(n*n)
//	space complexity :O(1)
	public static int numIdenticalPairsBruteForce(int [] nums) {
		int counter=0;
		for(int i =0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]==nums[j]) {
					counter++;
				}
			}
		}
		return counter;
		
	}
//	Optimize Time Approoch :
//	by taking the frequency of each element we can use a formula of combination in order to find the number of
//	pairs we can make 
//	formula is : f(n,r)=n!/(2*(n!-r!))
//	here n : number of element
//	r: number of element we want to choose
//	we know we need 2 element per element so we can put them in the formula 
//	so here n = freq of element , n =2 because each pair have 2 element 
//	formaula= f(freq,2)= freq!/(2*(freq-2)!);
//	now if we know factorial we can say freq ! = freq*(freq-1)*(freq-2)! so put that in equation
//	formaula= f(freq,2)= freq*(freq-1)*(freq-2)!/(2*(freq-2)!);
//	now we can cancle out the (freq-2)!
//	so the final formula = freq*(freq-1)/2
//	so we can first find frequency of each element from the nums array then apply formula on each frequency and sum them up to
//	get output
//	
	
//	time complexity : O(n)
//	space complexity : O(n)
	public static int numIdenticalPairsOptimize(int [] nums) {
		int ans=0;
		HashMap <Integer,Integer>freqmap = new HashMap();
		for(int x:nums) {// create frequency map
			if(freqmap.containsKey(x)) {
				freqmap.put(x,freqmap.get(x)+1);
			}else {
				freqmap.put(x,1);
			}
		}
//		iterate over each frequency to get  number of pairs with formula
		for(Integer freq : freqmap.values()) {
//			apply fomula of pair on each frequency
			int pairs = freq*(freq-1)/2;
//			final result sum of all pairs
				ans+=pairs;
		}
		return ans;
	}

	public static void main(String[] args) {
		
		//Example 1:
		
		int [] nums1 = {1,2,3,1,1,3};
		int output1=4;
		
		//Example 2:
		
		int [] nums2 = {1,1,1,1};
		int output2=6;

		//Example 3:
		
		int [] nums3 = {1,2,3};
		int output3=0;
		
		int ans1 = numIdenticalPairsBruteForce(nums1);
		int ans2 = numIdenticalPairsBruteForce(nums2);
		int ans3 = numIdenticalPairsBruteForce(nums3);
		
    	System.out.println("Brute Force Approch :");
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
		
		System.out.println("Optimize Approch :");
		
		ans1 = numIdenticalPairsOptimize(nums1);
		ans2 = numIdenticalPairsOptimize(nums2);
		ans3 = numIdenticalPairsOptimize(nums3);
		
		
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
