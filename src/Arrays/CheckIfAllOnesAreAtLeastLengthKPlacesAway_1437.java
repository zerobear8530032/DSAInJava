//1437. Check If All 1's Are at Least Length K Places Away
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.
//
//
//
//Example 1:
//
//
//Input: nums = [1,0,0,0,1,0,0,1], k = 2
//Output: true
//Explanation: Each of the 1s are at least 2 places away from each other.
//Example 2:
//
//
//Input: nums = [1,0,0,1,0,1], k = 2
//Output: false
//Explanation: The second 1 and third 1 are only one apart from each other.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//0 <= k <= nums.length
//nums[i] is 0 or 1
package Arrays;

public class CheckIfAllOnesAreAtLeastLengthKPlacesAway_1437 {
//   approch : here we can use simple sliding window where l is at first 1 from left to right
//    and we can then just skipp all 0 until we doe not encounter any 1
//    and take size bwt elemeents and if its <k return false
//    other wise continue;
//    time complexity : O(n)
//    space complexity : O(1)
    public static boolean kLengthApart(int[] nums, int k) {
        int l =0;
        while(l<nums.length && nums[l]==0){
            l++;
        }
        for(int r=l;r<nums.length;r++){
            if(nums[l]==1 &&nums[r]==1 && l!=r){
                int size = r-l-1;
                if(size<k){
                    return false;
                }
                l=r;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,0,0,0,1,0,0,1};
        int k1 = 2;
        boolean output1= true;

        //Example 2:

        int [] nums2 = {1,0,0,1,0,1};
        int k2 = 2;
        boolean output2= false;

        boolean ans1= kLengthApart(nums1,k1);
        boolean ans2= kLengthApart(nums2,k2);

        if(output1== ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2== ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }

    }
}
