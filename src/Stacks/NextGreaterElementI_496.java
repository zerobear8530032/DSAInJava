//496. Next Greater Element I
//Solved
//Easy
//Topics
//Companies
//The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
//
//You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
//
//For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
//
//Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
//
// 
//
//Example 1:
//
//Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//Output: [-1,3,-1]
//Explanation: The next greater element for each value of nums1 is as follows:
//- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
//- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
//- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
//Example 2:
//
//Input: nums1 = [2,4], nums2 = [1,2,3,4]
//Output: [3,-1]
//Explanation: The next greater element for each value of nums1 is as follows:
//- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
//- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
// 
//
//Constraints:
//
//1 <= nums1.length <= nums2.length <= 1000
//0 <= nums1[i], nums2[i] <= 104
//All integers in nums1 and nums2 are unique.
//All the integers of nums1 also appear in nums2.
// 
//
//Follow up: Could you find an O(nums1.length + nums2.length) solution?

package Stacks;

import java.util.Arrays;
import java.util.List;

public class NextGreaterElementI_496 {
//	brute force :
//	first go through nums1 find that number in nums2 and check right side for greater 
//	number if found update the ans array other wise -1
//	time complexity :O(n*n)
//	time complexity :O(n): output array 

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
	        int ans[] = new int[nums1.length];
	        for(int i=0;i<nums1.length;i++){
	            ans[i]=findNextGreatest(nums2,nums1[i]);
	        }
	        return ans;
	    }
	    public static int findNextGreatest(int [] nums,int num){
	        int idx=0;
	        while(nums[idx]!=num){
	            idx++;
	        }
	        for(int i=idx;i<nums.length;i++){
	            if(nums[i]>num){
	                return nums[i];
	            }
	        }
	        return -1;
	    }
	    
	    
	    public static boolean check(int []output, int []ans) {
			if(output.length!=ans.length) {
				return false;
			}
			for(int i =0;i<output.length;i++) {
				if(output[i]!=ans[i]) {
					return false;
				}
			}
			
			return true;
		}
	
	public static void main(String[] args) {
		//Example 1:
		//
		int  []nums11 = {4,1,2}, nums12 = {1,3,4,2};
		int [] output1= {-1,3,-1};

		//Example 2:
		
		int  []nums21 = {2,4}, nums22 = {1,2,3,4};
		int [] output2= {3,-1};
		
		int[]ans1 = nextGreaterElement(nums11,nums12);
		int[]ans2 = nextGreaterElement(nums21,nums22);
	
		System.out.println("Brute Force :");
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		


	}

}
