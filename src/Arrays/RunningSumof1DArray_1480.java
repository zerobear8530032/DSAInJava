//1480. Running Sum of 1d Array
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//
//Return the running sum of nums.
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [1,3,6,10]
//Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
//Example 2:
//
//Input: nums = [1,1,1,1,1]
//Output: [1,2,3,4,5]
//Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
//Example 3:
//
//Input: nums = [3,1,2,10,1]
//Output: [3,4,6,16,17]
// 
//
//Constraints:
//
//1 <= nums.length <= 1000
//-10^6 <= nums[i] <= 10^6
package Arrays;
import java.util.Arrays;

public class RunningSumof1DArray_1480 {
// approch :
//	iterate over array while keeping the  sum of all element till that index 
//	time complexity :O(n) : iterate over loop
//	space complexity :O(1): no extra space used
	    public static int[]  runningSum(int[] nums) {
//	    	createa a sum which store the sum of element
	    	int sum=0;
	    	for(int  i =0;i<nums.length;i++) {
	    		sum+=nums[i]; // sum the current element and prev elemennt
	    		nums[i]=sum; // update the index of array with sum
	    	}
	    	return nums;
	    }
	    
	    public static boolean check(int [] arr1, int [] arr2) {
			if(arr1.length!=arr2.length) {
				return false;
			}
			for(int i =0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					return false;
				}
			}
			
			for(int i =0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					return false;
				}
			}
			
			return true;
		}
	

	public static void main(String[] args) {
		//Example 1:
		
		int [] nums1 = {1,2,3,4};
		int [] output1 = {1,3,6,10};
		
		//Example 2:
		
		int [] nums2 = {1,1,1,1,1};
		int [] output2 = {1,2,3,4,5};
		
		//Example 3:

		int [] nums3 = {3,1,2,10,1};
		int [] output3 = {3,4,6,16,17};
		
		int ans1 []= runningSum(nums1);
		int ans2 []= runningSum(nums2);
		int ans3 []= runningSum(nums3);
		
		
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
		
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		
		

		

	}

}
