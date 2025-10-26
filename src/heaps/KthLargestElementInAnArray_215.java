//215. Kth Largest Element in an Array
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given an integer array nums and an integer k, return the kth largest element in the array.
//
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//Can you solve it without sorting?
//
//
//
//Example 1:
//
//Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
//Example 2:
//
//Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
//
//
//Constraints:
//
//1 <= k <= nums.length <= 105
//-104 <= nums[i] <= 104
package heaps;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {
//    approch :
//    here we can use a min heap where we push element and remove the smallest element when ti get more then k elements
//    this remove the smaller elements which are not in k and all bigger elements remain in the heap
//    at the end last element is the K  th largest
//    time complexity : O(n log k)
//    space complexity : O(n)
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue= new PriorityQueue<>();
        for(int x:nums){
            queue.add(x);
            if(queue.size()>k){
                queue.remove();
            }
        }
        return queue.remove();
    }
    public static void main(String[] args) {

        //Example 1:

        int [] nums1 = {3,2,1,5,6,4};
        int  k1 = 2;
        int output1= 5;

        //Example 2:

        int [] nums2 = {3,2,3,1,2,4,5,5,6};
        int  k2 = 4;
        int output2= 4;

        int ans1=  findKthLargest(nums1,k1);
        int ans2=  findKthLargest(nums2,k2);

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


    }
}
