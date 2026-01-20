//3314. Construct the Minimum Bitwise Array I
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array nums consisting of n prime integers.
//
//You need to construct an array ans of length n, such that, for each index i, the bitwise OR of ans[i] and ans[i] + 1 is equal to nums[i], i.e. ans[i] OR (ans[i] + 1) == nums[i].
//
//Additionally, you must minimize each value of ans[i] in the resulting array.
//
//If it is not possible to find such a value for ans[i] that satisfies the condition, then set ans[i] = -1.
//
//
//
//Example 1:
//
//Input: nums = [2,3,5,7]
//
//Output: [-1,1,4,3]
//
//Explanation:
//
//For i = 0, as there is no value for ans[0] that satisfies ans[0] OR (ans[0] + 1) = 2, so ans[0] = -1.
//For i = 1, the smallest ans[1] that satisfies ans[1] OR (ans[1] + 1) = 3 is 1, because 1 OR (1 + 1) = 3.
//For i = 2, the smallest ans[2] that satisfies ans[2] OR (ans[2] + 1) = 5 is 4, because 4 OR (4 + 1) = 5.
//For i = 3, the smallest ans[3] that satisfies ans[3] OR (ans[3] + 1) = 7 is 3, because 3 OR (3 + 1) = 7.
//Example 2:
//
//Input: nums = [11,13,31]
//
//Output: [9,12,15]
//
//Explanation:
//
//For i = 0, the smallest ans[0] that satisfies ans[0] OR (ans[0] + 1) = 11 is 9, because 9 OR (9 + 1) = 11.
//For i = 1, the smallest ans[1] that satisfies ans[1] OR (ans[1] + 1) = 13 is 12, because 12 OR (12 + 1) = 13.
//For i = 2, the smallest ans[2] that satisfies ans[2] OR (ans[2] + 1) = 31 is 15, because 15 OR (15 + 1) = 31.
//
//
//Constraints:
//
//1 <= nums.length <= 100
//2 <= nums[i] <= 1000
//nums[i] is a prime number.
package BitWise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructTheMinimumBitwiseArrayI_3314 {

    public static int[] minBitwiseArray(List<Integer> nums) {
        int [] res= new int [nums.size()];
        for(int i=0;i<nums.size();i++){
            res[i]= getSmallest(nums.get(i));
        }
        return res;
    }
    public static int getSmallest(int x){
        for(int i =1;i<=x;i++){
            if((i | (i+1)) == x){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //Example 1:

        List<Integer> nums1 =  new ArrayList<>(Arrays.asList(2,3,5,7));
        int []output1= {-1,1,4,3};

        //Example 2:

        List<Integer> nums2 =  new ArrayList<>(Arrays.asList(11,13,31));
        int [] output2= {9,12,15};

        int [] ans1 = minBitwiseArray(nums1);
        int [] ans2 = minBitwiseArray(nums1);
        if(Arrays.equals(ans1,output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output1) );
            System.out.println("Your Output :"+Arrays.toString(ans1));
        }
        if(Arrays.equals(ans2,output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output2) );
            System.out.println("Your Output :"+Arrays.toString(ans2));
        }
    }
}
