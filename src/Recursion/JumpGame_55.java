//55. Jump Game
//Solved
//Medium
//Topics
//Companies
//You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//
//Return true if you can reach the last index, or false otherwise.
//
// 
//
//Example 1:
//
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//Example 2:
//
//Input: nums = [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
// 
//
//Constraints:
//
//1 <= nums.length <= 104
//0 <= nums[i] <= 105

package Recursion;

import java.util.HashMap;

public class JumpGame_55 {
//	jump games :
//	using recursion Brute Force approch :	
//	we will explore every single path to reach the end of array 
//	we will make a function which take arr , current position index
//	we can use recursion where base case will be if index>=nums.length-1
//	now we  can check from 1 <=nums[currposition]  and recall the function 
//	jump(arr,currpos+i)
//	this will check every single path to each the end 
//	Time Complexity :O(N^J)
//	Space Complexity :O(N)
	public static boolean canJumpBruteRecursion(int[] nums) {
		return jumphelper(nums,0);
    }
	
	private static boolean jumphelper(int[] nums, int index) {
		if(index>=nums.length-1) {
			return true;
		}
		for(int i =1;i<=nums[index];i++) {
			return jumphelper(nums,index+i);
		}
		return false;
	}

//	using recursion memorization approch :	
//	we will explore every single path to reach the end of array 
//	we will just use a hashmap which will keep track of wheather we have been through this path 
//	if yes then its value will be output 
//	this can remove all the position we already calculated
//	we does not need to do it again
//	this will check every single path to each the end 
//	Time Complexity :O(N)
//	Space Complexity :O(N)
//	using recursion memorization approch :	
//	we will explore every single path to reach the end of array 
//	we will just use a hashmap which will keep track of wheather we have been through this path 
//	if yes then its value will be output 
//	this can remove all the position we already calculated
//	we does not need to do it again
//	this will check every single path to each the end 
//	Time Complexity :O(N)
//	Space Complexity :O(N)
	public static boolean canJumpMemoRecursion(int[] nums) {
		HashMap<Integer,Boolean> memo = new HashMap();
		return jumphelpermemo(nums,0,memo);
	}
	
	private static boolean jumphelpermemo(int[] nums, int index,HashMap<Integer, Boolean> memo) {
		if(index>=nums.length-1) {
			return true;
		}
		if(memo.containsKey(index)) {
			return memo.get(index);
		}
		for(int i =1;i<=nums[index];i++) {
			if(jumphelpermemo(nums,index+i,memo)) {
				memo.put(index, true);
				return true;
			}
		}
		memo.put(index,false);
		return false;		
	}

	
	
	
	public static void main(String[] args) {
		
		//Example 1:
		
		int [] nums1 = {2,3,1,1,4};
		boolean output1=true;
		
		//Example 2:
		
		int [] nums2 = {3,2,1,0,4};
		boolean output2=false;

		int [] nums3 = {2,0,0};
		boolean output3=true;
		
		boolean ans1=canJumpBruteRecursion(nums1);
		boolean ans2=canJumpBruteRecursion(nums2);
		boolean ans3=canJumpBruteRecursion(nums3);
		
		System.out.println("Brute Force Recursion Approch :");
		
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
		
		ans1=canJumpMemoRecursion(nums1);
		ans2=canJumpMemoRecursion(nums2);
		ans3=canJumpMemoRecursion(nums3);
		
		System.out.println("Brute Force Recursion Approch :");
		
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
