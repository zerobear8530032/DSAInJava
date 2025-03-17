//2206. Divide Array Into Equal Pairs
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given an integer array nums consisting of 2 * n integers.
//
//You need to divide nums into n pairs such that:
//
//Each element belongs to exactly one pair.
//The elements present in a pair are equal.
//Return true if nums can be divided into n pairs, otherwise return false.
//
// 
//
//Example 1:
//
//Input: nums = [3,2,3,2,2,2]
//Output: true
//Explanation: 
//There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
//If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.
//Example 2:
//
//Input: nums = [1,2,3,4]
//Output: false
//Explanation: 
//There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition.
// 
//
//Constraints:
//
//nums.length == 2 * n
//1 <= n <= 500
//1 <= nums[i] <= 500

package BitWise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualPairs_2206 {
//	Brute Force approch :
//	create a frequency hashmap
//	and check  any value is odd if it is return true else false
	public static boolean divideArrayBruteForce(int[] nums) {
	       HashMap<Integer,Integer> map = new HashMap();
	       for(int i=0;i<nums.length;i++){
	        if(map.containsKey(nums[i])){
	            map.put(nums[i],map.get(nums[i])+1);
	        }else{
	            map.put(nums[i],1);
	        }
	       }
	       for(Map.Entry<Integer,Integer> e: map.entrySet()){
	        if(e.getValue()%2!=0) return false;
	       }
	       return true;
	    }
	
//	better Force approch :
//  we can create a max size array and map number frequency there
	public static boolean divideArrayBetter(int[] nums) {
		int [] temp= new int [500];
		for(int x:nums) {
			temp[x-1]++;
		}
		for(int x:temp) {
			if(x%2!=0) return false;
		}
		return true;
		}
	
	
//	best approch :
//	here we can use a long integer which can map all the bits on that long and return true if bitmask ==0
//	other wise false
	public static boolean divideArrayBest(int[] nums) {
        long bitmask=0;
        for (long x : nums) {
            bitmask ^= 1L<<x; 
        }
        return bitmask==0; 
    }

	
	public static void main(String[] args) {
		
		
		//Example 1:

		int []  nums1 = {3,2,3,2,2,2};
		boolean output1=true;

		//Example 2:

		int []  nums2 = {1,2,3,4};
		boolean output2=false;
	
		//Example 3:
		
		int []  nums3 = {500,500,500,500,499,499,20,52};
		boolean output3=false;
		
		System.out.println("Brute Force Approch :");
		
		boolean ans1=divideArrayBruteForce(nums1);
		boolean ans2=divideArrayBruteForce(nums2);
		boolean ans3=divideArrayBruteForce(nums3);
		
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
		
		ans1=divideArrayBetter(nums1);
		ans2=divideArrayBetter(nums2);
		ans3=divideArrayBetter(nums3);
		
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
		
		ans1=divideArrayBest(nums1);
		ans2=divideArrayBest(nums2);
		ans3=divideArrayBest(nums3);
		
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
