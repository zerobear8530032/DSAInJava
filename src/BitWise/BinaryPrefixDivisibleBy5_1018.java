//1018. Binary Prefix Divisible By 5
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given a binary array nums (0-indexed).
//
//We define xi as the number whose binary representation is the subarray nums[0..i] (from most-significant-bit to least-significant-bit).
//
//For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.
//Return an array of booleans answer where answer[i] is true if xi is divisible by 5.
//
//
//
//Example 1:
//
//Input: nums = [0,1,1]
//Output: [true,false,false]
//Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
//Only the first number is divisible by 5, so answer[0] is true.
//Example 2:
//
//Input: nums = [1,1,1]
//Output: [false,false,false]
//
//
//Constraints:
//
//1 <= nums.length <= 105
//nums[i] is either 0 or 1.
package BitWise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryPrefixDivisibleBy5_1018 {
//    approch :
//    we can just maintain the last number at place value 1 at each iteration and to perform
//    the addition of next bit we can use formula prev*2+bit
//    time comeplxity : O(n)
//    space comeplxity : O(1)
    public static List<Boolean> prefixesDivBy5(int[] nums) {
        int lastNum=0;
        List<Boolean> res= new ArrayList<>();
        for(int bit:nums){
            lastNum=lastNum*2+ bit;
            res.add(lastNum%5==0);
            lastNum= lastNum%10;
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {0,1,1};
        List<Boolean> output1= new ArrayList<>(Arrays.asList(true,false,false));

        //Example 2:

        int [] nums2 = {1,1,1};
        List<Boolean> output2= new ArrayList<>(Arrays.asList(false,false,false));

        List<Boolean> ans1= prefixesDivBy5(nums1);
        List<Boolean> ans2= prefixesDivBy5(nums2);

        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }


    }
}
