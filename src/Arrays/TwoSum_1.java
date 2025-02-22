//1. Two Sum
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
// 
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
//Constraints:
//
//2 <= nums.length <= 104
//-109 <= nums[i] <= 109
//-109 <= target <= 109
//Only one valid answer exists.
// 
//
//Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

package Arrays;
import java.util.Arrays;
import java.util.HashMap;
public class TwoSum_1{
//	approch :
//	use a hashset to make the look up O(1) time 
//	how this work x1+x2= target 
//	we can say if  x2= target-x1
//	so what we can do is each time we iterate a number we will 
//	put it in hash set if we does not seen it where nums[i] is key and its index i is values
//	now we have all x1 in the key we can just check the place of x2 which will be the current number '.
//	and when both equal to target we return its index
//  time complexity :O(n)
//  space complexity :O(n)
	public static int[] twoSumOptimize(int[] nums, int target) {
        for(int i =0;i<nums.length-1;i++) {
        	for(int j =i+1;j<nums.length;j++) {
        		if(nums[i]+nums[j]==target) {
        			return new int [] {i,j};
        		}
        		
        	}
        }
        return null;
    }
    
    
//  brute  force approch check each and every index entire array 
//   time complexity :O(n*n)
//   time complexity :O(1)
    public static int[] twoSumBrute(int[] nums, int target) {
    	HashMap<Integer,Integer> map = new HashMap();// hashmap
    	for(int i =0;i<nums.length;i++){// iterater over loop
    		int t= target-nums[i];//target = nums[i]+t
//           so we can  say t =target-nums[i]
    		if(map.containsKey(t)){// finding t
    			return new int []{map.get(t),i};// find the target then ereturn index
    		}else{
    			map.put(nums[i],i);
    		}
    	}
    	return null;
    }
    
    public static void main(String[] args) {
		
    	//Example 1:
		
		int [] nums1 = {2,7,11,15};
		int target1= 9;
		int []output1= {0,1};
		
		//Example 2:
		
		int [] nums2 = {3,2,4};
		int target2= 6;
		int []output2= {1,2};
		
		//Example 3:
		
		int []nums3 = {3,3};
		int target3= 6;
		int []output3 = {0,1};
		
		System.out.println("Brute Force Approch ");
		
		
		int []ans1 = twoSumBrute(nums1,target1);
		int []ans2 = twoSumBrute(nums2,target2);
		int []ans3 = twoSumBrute(nums3,target3);
		
		
		if(Arrays.equals(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(ans1));
	}
		if(Arrays.equals(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(ans2));
		}
		if(Arrays.equals(ans3, output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output3));
			System.out.println("Your Answer :"+ Arrays.toString(ans3));	}
		
		
		System.out.println("Optimize Approch :");
		
		ans1 = twoSumOptimize(nums1,target1);
		ans2 = twoSumOptimize(nums2,target2);
		ans3 = twoSumOptimize(nums3,target3);
		
		if(Arrays.equals(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(ans1));
		}
		if(Arrays.equals(output2, ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(ans2));
		}
		if(Arrays.equals(output3, ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output3));
			System.out.println("Your Answer :"+ Arrays.toString(ans3));
		}
	}
    
}
