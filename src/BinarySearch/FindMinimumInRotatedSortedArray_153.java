//153. Find Minimum in Rotated Sorted Array
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
//
//[4,5,6,7,0,1,2] if it was rotated 4 times.
//[0,1,2,4,5,6,7] if it was rotated 7 times.
//Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
//Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//
//You must write an algorithm that runs in O(log n) time.
//
//
//
//Example 1:
//
//Input: nums = [3,4,5,1,2]
//Output: 1
//Explanation: The original array was [1,2,3,4,5] rotated 3 times.
//Example 2:
//
//Input: nums = [4,5,6,7,0,1,2]
//Output: 0
//Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
//Example 3:
//
//Input: nums = [11,13,15,17]
//Output: 11
//Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
//
//
//Constraints:
//
//n == nums.length
//1 <= n <= 5000
//-5000 <= nums[i] <= 5000
//All the integers of nums are unique.
//nums is sorted and rotated between 1 and n times.
package BinarySearch;
// approch : we can use binary search
// because its a sorted array and got rotated it hve 2 parts one sorted in ascending and one in descending
//and the min we want is always at the right side of that pivote
// so we cna apply a binary search on it where we check from mid
// the left boundary and right boundary if mid < then s we will move to right side other wise left side
// and mid will always be in center where m > m+1
//time complexity : O(log n)
//space complexity : O(1)
public class FindMinimumInRotatedSortedArray_153 {
    public static int findMin(int[] nums) {
        int pivot=getpivot(nums);
        if(pivot==-1){
            return nums[0];
        }else{
            return nums[pivot+1];
        }


    }
    public static int getpivot(int [] nums){
        int start =0;
        int end = nums.length -1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[start]>nums[mid]){
                end = mid;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {3,4,5,1,2};
        int output1= 1;

        //Example 2:

        int [] nums2 = {4,5,6,7,0,1,2};
        int output2= 0;

        //Example 3:

        int [] nums3 = {11,13,15,17};
        int output3= 11;

        int ans1 = findMin(nums1);
        int ans2 = findMin(nums2);
        int ans3 = findMin(nums3);

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
