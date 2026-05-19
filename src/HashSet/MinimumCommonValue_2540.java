//2540. Minimum Common Value
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
//
//Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,3], nums2 = [2,4]
//Output: 2
//Explanation: The smallest element common to both arrays is 2, so we return 2.
//Example 2:
//
//Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
//Output: 2
//Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
//
//
//Constraints:
//
//1 <= nums1.length, nums2.length <= 105
//1 <= nums1[i], nums2[j] <= 109
//Both nums1 and nums2 are sorted in non-decreasing order.
package HashSet;

import java.util.HashSet;

public class MinimumCommonValue_2540 {
//    put one array elements in hashset then search second array elements in that hashset
//    return the first answer we find because both are sorted in ascending order
// time complexity : O(n)
// space complexity : O(m)
    public static int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set= new HashSet();
        for(int x:nums1){
            set.add(x);
        }
        for(int x:nums2){
            if(set.contains(x)){
                return x;
            }
        }
        return -1;
    }
// approch : we can use 2 pointer one pointer at arr1 second on arr2
//    now check if arr1[i] == arr2[j] return answer
//    else if (arr1[i]<arr2[j]) increase i pointer
//    other wise increase j pointer
//    if no output found return -1;
    public static int getCommonTwoPointer(int[] nums1, int[] nums2) {
        int idx1=0;
        int idx2=0;
        while(idx1<nums1.length && idx2<nums2.length){
            if(nums1[idx1]==nums2[idx2]){return nums1[idx1];}
            else if(nums1[idx1]<nums2[idx2]){
                idx1++;
            }else{
                idx2++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums11 = {1,2,3}, nums12 = {2,4};
        int output1= 2;

        //Example 2:

        int [] nums21 = {1,2,3,6}, nums22 = {2,3,4,5};
        int output2= 2;


        System.out.println("Brute Force Approch :");
        int ans1= getCommon(nums11,nums12);
        int ans2= getCommon(nums21,nums22);


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
        System.out.println("Two Pointer  Approch :");
        ans1= getCommonTwoPointer(nums11,nums12);
        ans2= getCommonTwoPointer(nums21,nums22);


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
    }
}
