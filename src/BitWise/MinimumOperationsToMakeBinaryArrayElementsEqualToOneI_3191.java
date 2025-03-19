//3191. Minimum Operations to Make Binary Array Elements Equal to One I
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given a binary array nums.
//
//You can do the following operation on the array any number of times (possibly zero):
//
//Choose any 3 consecutive elements from the array and flip all of them.
//Flipping an element means changing its value from 0 to 1, and from 1 to 0.
//
//Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.
//
// 
//
//Example 1:
//
//Input: nums = [0,1,1,1,0,0]
//Output: 3
//
//Explanation:
//We can do the following operations:
//
//Choose the elements at indices 0, 1 and 2. The resulting array is nums = [1,0,0,1,0,0].
//Choose the elements at indices 1, 2 and 3. The resulting array is nums = [1,1,1,0,0,0].
//Choose the elements at indices 3, 4 and 5. The resulting array is nums = [1,1,1,1,1,1].
//Example 2:
//
//Input: nums = [0,1,1,1]
//
//Output: -1
//
//Explanation:
//It is impossible to make all elements equal to 1

package BitWise;


public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI_3191 {
    
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] == 0) {
                // Flip the three consecutive elements
                for (int j = i; j < i + 3; j++) {
                    nums[j] ^= 1;  // Toggle the bits
                }
                operations++;
            }
        }

        // Check if all elements are 1 after flipping
        for (int num : nums) {
            if (num == 0) return -1;
        }

        return operations;
    }

    public static void main(String[] args) {
        
        //Example 1:
        
        int [] nums1 = {0,1,1,1,0,0};
        int output1=3;

        //Example 2:
        
        int [] nums2 = {0,1,1,1};
        int output2=-1;
        
        int ans1 = minOperations(nums1);
		int ans2 = minOperations(nums2);
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
		
        
        
        
                

    }
}
