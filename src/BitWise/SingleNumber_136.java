//136. Single Number
//Solved
//Easy
//Topics
//Companies
//Hint
//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//Example 1:
//
//Input: nums = [2,2,1]
//
//Output: 1
//
//Example 2:
//
//Input: nums = [4,1,2,1,2]
//
//Output: 4
//
//Example 3:
//
//Input: nums = [1]
//
//Output: 1
//
// 
//
//Constraints:
//
//1 <= nums.length <= 3 * 104
//-3 * 104 <= nums[i] <= 3 * 104
//Each element in the array appears twice except for one element which appears only once.





package BitWise;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber_136 {
	
	
//	Best approch
//	use xor operatior it cancle out the repeating character and only give the character are appear one time
//	time complexity :O(n)
//	space complexity :O(n)
	public static int singleNumberBruteForce(int[] nums) {
		HashMap<Integer,Integer> map =  new HashMap();
		
		for(int x: nums) {
			if(map.containsKey(x)) {
				map.put(x, map.get(x)+1);
			}else {
				map.put(x, 1);
			}
		}
		for(Map.Entry<Integer, Integer> e: map.entrySet()) {
			if(e.getValue()==1) {
				return e.getKey();
			}
		}
		return -1;
	}
	
	
//	Best approch
//	use xor operatior it cancle out the repeating character and only give the character are appear one time
//	time complexity :O(n)
//	space complexity :O(1)
	   public static int singleNumberBest(int[] nums) {
	        int x =0;
	        for(int i:nums){
	            x^=i;
	        }
	        return x;
	    }

	public static void main(String[] args) {
		
		//Example 1:
		//
		int [] nums1 = {2,2,1};
		int output1=1;

		//Example 2:
		int [] nums2 = {4,1,2,1,2};
		int output2=4;


		//Example 3:
		//
		int [] nums3 = {1};
		int output3=1;

		System.out.println("Brute Force  Approch ");
		int ans1 = singleNumberBruteForce(nums1);
		int ans2 = singleNumberBruteForce(nums2);
		int ans3 = singleNumberBruteForce(nums3);
		if(output1== ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Output : "+output1);
			System.out.println("Your Output : "+ans1);
		}
		if(output2== ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Output : "+output2);
			System.out.println("Your Output : "+ans2);
		}
		if(output3== ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Output : "+output3);
			System.out.println("Your Output : "+ans3);
		}
		System.out.println("best  Approch ");
    	ans1 = singleNumberBest(nums1);
    	ans2 = singleNumberBest(nums2);
    	ans3 = singleNumberBest(nums3);
    	if(output1== ans1) {
    		System.out.println("Case 1 Passed ");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Output : "+output1);
    		System.out.println("Your Output : "+ans1);
    	}
    	if(output2== ans2) {
    		System.out.println("Case 2 Passed ");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Output : "+output2);
    		System.out.println("Your Output : "+ans2);
    	}
    	if(output3== ans3) {
    		System.out.println("Case 3 Passed ");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Output : "+output3);
    		System.out.println("Your Output : "+ans3);
    	}

	}

}
