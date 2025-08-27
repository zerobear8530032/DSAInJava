//1493. Longest Subarray of 1's After Deleting One Element
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a binary array nums, you should delete one element from it.
//
//Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
//
//
//
//Example 1:
//
//Input: nums = [1,1,0,1]
//Output: 3
//Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
//Example 2:
//
//Input: nums = [0,1,1,1,0,1,1,0,1]
//Output: 5
//Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
//Example 3:
//
//Input: nums = [1,1,1]
//Output: 2
//Explanation: You must delete one element.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//nums[i] is either 0 or 1.

package slidingwindow;

public class LongestSubarrayOfAfterDeletingOneElement_1493 {
// approch :
//  here we can use sliding window
//  keep a zerocount variable if we encounter zero we can add to counter
//    if zercounter reached more then 1 we can move left  pointer
//    towards right and decrement it zerocounter until it reached 1
//    and at each time right move ahead we can  keep track of maxWindow length -zerocount
//    because all element in window are 1 and zerocount will substractzeros
//    time complexity : O(n)
//    space complexity : O(1)
//
    public static int longestSubarray(int[] nums) {
        int l =0;
        int zerocount =0;
        int maxCountOne=0;
        boolean allones=true;
        for(int r =0;r<nums.length;r++){
            if(nums[r]==0){
                // increase zero
                zerocount++;
                allones=false;
            }
            maxCountOne= Math.max(maxCountOne,(r-l)+1-zerocount);
            if(zerocount>1){
                while(zerocount>1 && l<=r){
                    if(nums[l]==0){
                        zerocount--;
                    }
                    l++;
                }
            }
        }
        if(allones){return nums.length-1;}
        return maxCountOne;
    }
    public static void main(String[] args) {

    //Example 1:

    int [] nums1 = {1,1,0,1};
    int output1=3;

    //Example 2:

    int [] nums2 = {0,1,1,1,0,1,1,0,1};
    int output2=5;

    //Example 3:

    int [] nums3 = {1,1,1};
    int output3=2;

    int ans1 =longestSubarray(nums1);
    int ans2 =longestSubarray(nums2);
    int ans3 =longestSubarray(nums3);


        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }


    }

}
