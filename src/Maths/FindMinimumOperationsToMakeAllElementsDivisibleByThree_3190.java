//3190. Find Minimum Operations to Make All Elements Divisible by Three
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums. In one operation, you can add or subtract 1 from any element of nums.
//
//Return the minimum number of operations to make all elements of nums divisible by 3.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//
//Output: 3
//
//Explanation:
//
//All array elements can be made divisible by 3 using 3 operations:
//
//Subtract 1 from 1.
//Add 1 to 2.
//Subtract 1 from 4.
//Example 2:
//
//Input: nums = [3,6,9]
//
//Output: 0
//
//
//
//Constraints:
//
//1 <= nums.length <= 50
//1 <= nums[i] <= 50
package Maths;

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree_3190 {
//    time complexity : O(n)
//    space complexity : O(1)
    public static int minimumOperations(int[] nums) {
        int operations = 0;
        for(int x:nums){
            if(x%3!=0){
                int subOperation = x%3;// if there is remainder i can substract it
                int div = x/3;
                int nextMultiple= (div+1)*3;
                int addOperation = nextMultiple-x;// if there is a next mutliple closer to x i can add the difference of it the x
                operations+= Math.min(subOperation,addOperation);
            }
        }
        return operations;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3,4};
        int output1= 3;

        //Example 2:

        int [] nums2 = {3,6,9};
        int output2= 3;

        int ans1 = minimumOperations(nums1);
        int ans2 = minimumOperations(nums2);

        if(output1== ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2== ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }

    }
}
