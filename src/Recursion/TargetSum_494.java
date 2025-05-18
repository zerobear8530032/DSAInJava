//494. Target Sum
//Medium
//Topics
//Companies
//You are given an integer array nums and an integer target.
//
//You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
//
//For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
//Return the number of different expressions that you can build, which evaluates to target.
//

//Example 1:
//
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
//Example 2:
//
//Input: nums = [1], target = 1
//Output: 1
// 
//
//Constraints:
//
//1 <= nums.length <= 20
//0 <= nums[i] <= 1000
//0 <= sum(nums[i]) <= 1000
//-1000 <= target <= 1000


package Recursion;

import java.util.HashMap;

public class TargetSum_494 {
//	brute force recusion :
//	we can use a recursive helper function which take index
//	and target now each time we will perform 2 recusrive calles 
//	one for addition where we go to next index and decrement target by current index element from nums
//	second for substraction where we go to next index and incement target by current index element from nums
//	and at the end when ever target ==0 and length of nums == index we can return true
//	if target != 0 but length == index then we can return zero cause
//	we have  used each and every element in the array but target is not yet possible to create here
//	time complexity :O(2^n)  
//	space complexity :O(n)  
	public static int findTargetSumWaysBruteForce(int[] nums, int target) {
		  
		  return targetSumHelper(nums,target,0);
	    }
	  
	  public static int targetSumHelper(int []nums, int target, int index) {
		  if(nums.length==index && 	target ==0) {
			  return 1;
			  }
		  if(nums.length==index) {
			  return 0;
		  }
		  
		  int add= targetSumHelper(nums, target-nums[index], index+1);
		  int substract= targetSumHelper(nums, target+nums[index], index+1);
		  
		  return add+substract;
		  }
	  
	  
//	  better we can use a memorization where 
//	  a map can store the current index +","+ target and the output at that instance
//	  now we can just check in map at each call wheather it get pre computed or not 
//	  other wise we can compute it 
//	  
//	time complexity :O(n*sum)  
//	space complexity :O(n*sum)  
	  public static int findTargetSumWaysBetter(int[] nums, int target) {
		  HashMap<String, Integer> map= new HashMap();
		  
		  return targetSumHelper(nums,target,0,map);
	  }
	  
	  public static int targetSumHelper(int []nums, int target, int index,HashMap<String,Integer> map) {
		  
		  if(nums.length==index && 	target ==0) {
			  return 1;
		  }
		  
		  if(nums.length==index) {
			  return 0;
		  }
		  String key = index + "," + target;
		  
		  if (map.containsKey(key)) {
			  return map.get(key);
		  }

		  int add= targetSumHelper(nums, target-nums[index], index+1,map);
		  int substract= targetSumHelper(nums, target+nums[index], index+1,map);
		  map.put(key, add+substract);
		  return map.get(key);
	  }

	public static void main(String[] args) {
		
		//Example 1:

		int [] nums1 = {1,1,1,1,1};
		int target1 = 3;
		int output1= 5;

		//Example 2:

		int [] nums2 = {1};
		int target2 = 1;
		int output2= 1;
		
		System.out.println("Brute Approch :");
		
		int ans1=findTargetSumWaysBruteForce(nums1,target1);
		int ans2=findTargetSumWaysBruteForce(nums2,target2);
		
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
		
		ans1=findTargetSumWaysBruteForce(nums1,target1);
		ans2=findTargetSumWaysBruteForce(nums2,target2);
		
		
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
