//2784. Check if Array is Good
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums. We consider an array good if it is a permutation of an array base[n].
//
//base[n] = [1, 2, ..., n - 1, n, n] (in other words, it is an array of length n + 1 which contains 1 to n - 1 exactly once, plus two occurrences of n). For example, base[1] = [1, 1] and base[3] = [1, 2, 3, 3].
//
//Return true if the given array is good, otherwise return false.
//
//Note: A permutation of integers represents an arrangement of these numbers.
//
//
//
//Example 1:
//
//Input: nums = [2, 1, 3]
//Output: false
//Explanation: Since the maximum element of the array is 3, the only candidate n for which this array could be a permutation of base[n], is n = 3. However, base[3] has four elements but array nums has three. Therefore, it can not be a permutation of base[3] = [1, 2, 3, 3]. So the answer is false.
//Example 2:
//
//Input: nums = [1, 3, 3, 2]
//Output: true
//Explanation: Since the maximum element of the array is 3, the only candidate n for which this array could be a permutation of base[n], is n = 3. It can be seen that nums is a permutation of base[3] = [1, 2, 3, 3] (by swapping the second and fourth elements in nums, we reach base[3]). Therefore, the answer is true.
//Example 3:
//
//Input: nums = [1, 1]
//Output: true
//Explanation: Since the maximum element of the array is 1, the only candidate n for which this array could be a permutation of base[n], is n = 1. It can be seen that nums is a permutation of base[1] = [1, 1]. Therefore, the answer is true.
//Example 4:
//
//Input: nums = [3, 4, 4, 1, 2, 1]
//Output: false
//Explanation: Since the maximum element of the array is 4, the only candidate n for which this array could be a permutation of base[n], is n = 4. However, base[4] has five elements but array nums has six. Therefore, it can not be a permutation of base[4] = [1, 2, 3, 4, 4]. So the answer is false.
//
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= num[i] <= 200
package HashMap;

import java.util.HashMap;

public class CheckIfArrayIsGood_2784 {
//    approch : just count each number occurences and check conditions satifieds
//    time complexity : O(n)
//    space complexity : O(n)

    public static boolean isGood(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int i =1;i<=nums.length-2;i++){
            if(!map.containsKey(i)){return false;}
        }
        return map.containsKey(nums.length-1) && map.get(nums.length-1)==2;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {2, 1, 3};
        boolean output1= false;

        //Example 2:

        int [] nums2 = {1,3,3,2};
        boolean output2= true;

        //Example 3:

        int [] nums3 = {1,1};
        boolean output3= true;

        //Example 4:

        int [] nums4 = {3,4,4,1,2,1};
        boolean output4= false;

        boolean ans1= isGood(nums1);
        boolean ans2= isGood(nums2);
        boolean ans3= isGood(nums3);
        boolean ans4= isGood(nums4);


        if (output1 == ans1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + output1);
            System.out.println("Your Output :" + ans1);
        }

        if (output2 == ans2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }
        if (output3 == ans3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }
        if (output4 == ans4) {
            System.out.println("Case 4 Passed");
        } else {
            System.out.println("Case 4 Failed");
            System.out.println("Actual Output :" + output4);
            System.out.println("Your Output :" + ans4);
        }
    }
}
