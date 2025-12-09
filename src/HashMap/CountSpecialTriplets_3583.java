//3583. Count Special Triplets
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums.
//
//A special triplet is defined as a triplet of indices (i, j, k) such that:
//
//0 <= i < j < k < n, where n = nums.length
//nums[i] == nums[j] * 2
//nums[k] == nums[j] * 2
//Return the total number of special triplets in the array.
//
//Since the answer may be large, return it modulo 109 + 7.
//
//
//
//Example 1:
//
//Input: nums = [6,3,6]
//
//Output: 1
//
//Explanation:
//
//The only special triplet is (i, j, k) = (0, 1, 2), where:
//
//nums[0] = 6, nums[1] = 3, nums[2] = 6
//nums[0] = nums[1] * 2 = 3 * 2 = 6
//nums[2] = nums[1] * 2 = 3 * 2 = 6
//Example 2:
//
//Input: nums = [0,1,0,0]
//
//Output: 1
//
//Explanation:
//
//The only special triplet is (i, j, k) = (0, 2, 3), where:
//
//nums[0] = 0, nums[2] = 0, nums[3] = 0
//nums[0] = nums[2] * 2 = 0 * 2 = 0
//nums[3] = nums[2] * 2 = 0 * 2 = 0
//Example 3:
//
//Input: nums = [8,4,2,8,4]
//
//Output: 2
//
//Explanation:
//
//There are exactly two special triplets:
//
//(i, j, k) = (0, 1, 3)
//nums[0] = 8, nums[1] = 4, nums[3] = 8
//nums[0] = nums[1] * 2 = 4 * 2 = 8
//nums[3] = nums[1] * 2 = 4 * 2 = 8
//(i, j, k) = (1, 2, 4)
//nums[1] = 4, nums[2] = 2, nums[4] = 4
//nums[1] = nums[2] * 2 = 2 * 2 = 4
//nums[4] = nums[2] * 2 = 2 * 2 = 4
//
//
//Constraints:
//
//3 <= n == nums.length <= 105
//0 <= nums[i] <= 105
package HashMap;

import java.util.HashMap;

public class CountSpecialTriplets_3583 {
//    approch : we can keep track of left sid evalues and right side values of mid in hashmap
//    and just find the left count * right count
//    make sure the integer is not over flow
    public static int specialTriplets(int[] nums) {
    int MOD=1000000007;
    HashMap<Integer,Long> right = new HashMap();
    for(int x:nums){
        right.put(x,right.getOrDefault(x,0L)+1L);
    }
    HashMap<Integer,Long> left = new HashMap<>();
    int res=0;
    for(int x:nums){
        int mid =x*2;
        right.put(x,right.get(x)-1);
        if(left.containsKey(mid) && right.containsKey(mid)){
            long l = left.get(mid);
            long r = right.get(mid);
            long pairs= (l*r)%MOD;
            res= (int)(res+pairs)%MOD;
        }
        left.put(x,left.getOrDefault(x,0L)+1);
    }
    return (int)res;
}
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {6,3,6};
        int output1= 1;

        //Example 2:

        int [] nums2 = {0,1,0,0};
        int output2= 1;

        //Example 3:

        int [] nums3 = {8,4,2,8,4};
        int output3= 2;

        int ans1= specialTriplets(nums1);
        int ans2= specialTriplets(nums2);
        int ans3= specialTriplets(nums3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
    }
}
