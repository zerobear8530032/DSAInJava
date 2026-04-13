//41. First Missing Positive
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
//
//You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,0]
//Output: 3
//Explanation: The numbers in the range [1,2] are all in the array.
//Example 2:
//
//Input: nums = [3,4,-1,1]
//Output: 2
//Explanation: 1 is in the array but 2 is missing.
//Example 3:
//
//Input: nums = [7,8,9,11,12]
//Output: 1
//Explanation: The smallest positive integer 1 is missing.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-231 <= nums[i] <= 231 - 1
package HashSet;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FirstMissingPositive_41 {
//   opproch : just put every thing in a set and find if set have number form 0 , integer max length;
//    time complexity : O(n)
//    space complexity : O(n)
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set= Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for(int i =1;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //Example 1:
        //
        int []nums1 = {1,2,0};
        int output1= 3;
        //Explanation: The numbers in the range [1,2] are all in the array.

        //Example 2:
        //
        int []nums2 = {3,4,-1,1};
        int output2= 2;

        //Example 3:

        int []nums3 = {7,8,9,11,12};
        int output3 =1;


        int ans1=  firstMissingPositive(nums1);
        int ans2=  firstMissingPositive(nums2);
        int ans3=  firstMissingPositive(nums3);

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
