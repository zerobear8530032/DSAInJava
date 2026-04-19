//1855. Maximum Distance Between a Pair of Values
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two non-increasing 0-indexed integer arrays nums1​​​​​​ and nums2​​​​​​.
//
//A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length, is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i​​​​.
//
//Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.
//
//An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.
//
//
//
//Example 1:
//
//Input: nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
//Output: 2
//Explanation: The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
//The maximum distance is 2 with pair (2,4).
//Example 2:
//
//Input: nums1 = [2,2,2], nums2 = [10,10,1]
//Output: 1
//Explanation: The valid pairs are (0,0), (0,1), and (1,1).
//The maximum distance is 1 with pair (0,1).
//Example 3:
//
//Input: nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
//Output: 2
//Explanation: The valid pairs are (2,2), (2,3), (2,4), (3,3), and (3,4).
//The maximum distance is 2 with pair (2,4).
//
//
//Constraints:
//
//1 <= nums1.length, nums2.length <= 105
//1 <= nums1[i], nums2[j] <= 105
//Both nums1 and nums2 are non-increasing.
package TwoPointers;

public class MaximumDistanceBetweenAPairOfValues_1855 {
//  approch: we can go through nums1 at each number and find in num2
//    element greater then equal to the i num nums1
//    because arry is sorted in descending order we can use binary search and find ciel of the value
//    time complexity : O(N log N)
//    time complexity : O(1)
    public static int maxDistance(int[] nums1, int[] nums2) {
        int res =0;
        for(int i=0;i<nums1.length;i++){
            int idx = binarySearch(i,nums2.length-1,nums2,nums1[i]);
            //    System.out.println(idx);
            res= Math.max(idx-i,res);
        }
        return res;
    }

    public static int binarySearch(int s,int e, int [] nums , int target){
        int res=-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(nums[mid]<target){e=mid-1;}
            else if(nums[mid]>=target){
                res=Math.max(res,mid);
                s=mid+1;
            }
        }
        return res;
    }

    // approch: we can use 2 ponters becuse both are sorted we can move both pointer together if condition is not ment
    // if it met we increase the distance btw l , r
    //  now why we always increase i,j even if it get vlid then invlid its because we re trying to maximize result
//    we will never re calculate smaller windows with this
    //    time complexity : O(N)
    //    time complexity : O(1)

    public static int maxDistanceBest(int[] nums1, int[] nums2) {
        int i=0;
        int j =0;
        int res =0;
        while (i<nums1.length && j< nums2.length){
            if(nums1[i]<=nums2[j]){
                res= Math.max(res,j-i);
                j++;
            }else {
                i++;
                j++;
            }

        }
        return  res;
    }

    public static void main(String[] args) {

        //Example 1:

        int []nums11 = {55,30,5,4,2}, nums12 = {100,20,10,10,5};
        int output1 =2;

        //Example 2:

        int []nums21 = {2,2,2}, nums22 = {10,10,1};
        int output2 =1;

        //Example 3:

         int [] nums31 = {30,29,19,5}, nums32 = {25,25,25,25,25};
         int output3=2;

         System.out.println("Binary Search Approch :");
         int ans1 = maxDistance(nums11,nums12);
         int ans2 = maxDistance(nums21,nums22);
         int ans3 = maxDistance(nums31,nums32);

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

        System.out.println("Two Pointer Approch :");

        ans1 = maxDistanceBest(nums11,nums12);
        ans2 = maxDistanceBest(nums21,nums22);
        ans3 = maxDistanceBest(nums31,nums32);

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
