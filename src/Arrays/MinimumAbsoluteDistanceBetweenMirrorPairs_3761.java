//3761. Minimum Absolute Distance Between Mirror Pairs
//Attempted
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer array nums.
//
//A mirror pair is a pair of indices (i, j) such that:
//
//0 <= i < j < nums.length, and
//reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by reversing the digits of x. Leading zeros are omitted after reversing, for example reverse(120) = 21.
//Return the minimum absolute distance between the indices of any mirror pair. The absolute distance between indices i and j is abs(i - j).
//
//If no mirror pair exists, return -1.
//
//
//
//Example 1:
//
//Input: nums = [12,21,45,33,54]
//
//Output: 1
//
//Explanation:
//
//The mirror pairs are:
//
//(0, 1) since reverse(nums[0]) = reverse(12) = 21 = nums[1], giving an absolute distance abs(0 - 1) = 1.
//(2, 4) since reverse(nums[2]) = reverse(45) = 54 = nums[4], giving an absolute distance abs(2 - 4) = 2.
//The minimum absolute distance among all pairs is 1.
//
//Example 2:
//
//Input: nums = [120,21]
//
//Output: 1
//
//Explanation:
//
//There is only one mirror pair (0, 1) since reverse(nums[0]) = reverse(120) = 21 = nums[1].
//
//The minimum absolute distance is 1.
//
//Example 3:
//
//Input: nums = [21,120]
//
//Output: -1
//
//Explanation:
//
//There are no mirror pairs in the array.
//
//
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 109​​​​​​​
package Arrays;

import java.util.HashMap;

public class MinimumAbsoluteDistanceBetweenMirrorPairs_3761 {
//    time complexity : O(N)
//    space complexity : O(N)
//     approch : we can do simple reverse travesal right to left and
//    find the reverse of current is present or not in hashmap
//    if not we can put current number and it index insode the map as key value
//    if the current num is reversed and present in map we can find the distance btw them
//    that all we just find the min distnace amongs them is our answer
    public static int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap();
        int res = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int reversed= reverseNum(nums[i]);
            if (map.containsKey(reversed)) {
                int right = map.get(reversed);
                int left = i;
                res = Math.min((right - left), res);
            } else {
                map.put(nums[i], i);
            }
        }
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
    public static int reverseNum(int num) {
        int res = 0;
        while (num != 0) {
            int r = num % 10;
            res= res * 10 + r;
            num /= 10;
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {12,21,45,33,54};
        int output1= 1;

        //Example 2:

        int [] nums2 = {120,21};
        int output2= 1;

        //Example 3:

        int [] nums3 = {21,120};
        int output3= -1;

        int ans1= minMirrorPairDistance(nums1);
        int ans2= minMirrorPairDistance(nums2);
        int ans3= minMirrorPairDistance(nums3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
