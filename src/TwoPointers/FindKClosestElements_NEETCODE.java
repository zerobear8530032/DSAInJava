//Find K Closest Elements
//Medium
//Topics
//Company Tags
//You are given a sorted integer array arr, two integers k and x,
//return the k closest integers to x in the array.
//The result should also be sorted in ascending order.
//
//An integer a is closer to x than an integer b if:
//|a - x| < |b - x|, or
//|a - x| == |b - x| and a < b
//
//Example 1:
//
//Input: arr = [2,4,5,8], k = 2, x = 6
//Output: [4,5]
//
//Example 2:
//
//Input: arr = [2,3,4], k = 3, x = 1
//Output: [2,3,4]
//
//Constraints:
//
//1 <= k <= arr.length <= 10,000.
//-10,000 <= arr[i], x <= 10,000
//arr is sorted in ascending order.

package TwoPointers;

import java.util.*;

public class FindKClosestElements_NEETCODE {

    // Time Complexity: O(n - k)
    // In worst case we shrink window from size n to k

    // Space Complexity: O(k)
    // storing result list

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            if (r - l + 1 == k) {
                break;
            }

            int leftDistance = Math.abs(arr[l] - x);
            int rightDistance = Math.abs(arr[r] - x);

            if (leftDistance > rightDistance) {
                l++;
            } else {
                r--;
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            res.add(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        // Example 1:
        int[] arr1 = {2, 4, 5, 8};
        int k1 = 2;
        int x1 = 6;
        List<Integer> output1 = Arrays.asList(4, 5);

        // Example 2:
        int[] arr2 = {2, 3, 4};
        int k2 = 3;
        int x2 = 1;
        List<Integer> output2 = Arrays.asList(2, 3, 4);

        List<Integer> ans1 = findClosestElements(arr1, k1, x1);
        List<Integer> ans2 = findClosestElements(arr2, k2, x2);

        if (output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + output1);
            System.out.println("Your Output :" + ans1);
        }

        if (output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }
    }
}