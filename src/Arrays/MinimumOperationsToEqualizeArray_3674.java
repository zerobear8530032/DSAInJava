//3674. Minimum Operations to Equalize Array
//Solved
//Easy
//premium lock icon
//Companies
//Hint
//You are given an integer array nums of length n.
//
//In one operation, choose any subarray nums[l...r] (0 <= l <= r < n) and replace each element in that subarray with the bitwise AND of all elements.
//
//Return the minimum number of operations required to make all elements of nums equal.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//
//Example 1:
//
//Input: nums = [1,2]
//
//Output: 1
//
//Explanation:
//
//Choose nums[0...1]: (1 AND 2) = 0, so the array becomes [0, 0] and all elements are equal in 1 operation.
//
//Example 2:
//
//Input: nums = [5,5,5]
//
//Output: 0
//
//Explanation:
//
//nums is [5, 5, 5] which already has all elements equal, so 0 operations are required.
//
//
//
//Constraints:
//
//1 <= n == nums.length <= 100
//1 <= nums[i] <= 105
package Arrays;

public class MinimumOperationsToEqualizeArray_3674 {
    public static int minOperations(int[] nums) {
        int n= nums[0];
        for(int i =1;i<nums.length;i++){
            if(n!=nums[i]){return 1;}
        }
        return 0;
    }
    public static void main(String[] args) {
        //Example 1:

        int []  nums1 = {1,2};
        int output1=1;

        //Example 2:

        int []  nums2 = {5,5,5};
        int output2=0;

        int ans1= minOperations(nums1);
        int ans2= minOperations(nums2);

        if(ans1==output1) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ (output1));
            System.out.println("Your Output : "+ (ans1));
        }
        if((ans2==output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ (output2));
            System.out.println("Your Output : "+ (ans2));
        }




    }
}
