//3507. Minimum Pair Removal to Sort Array I
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given an array nums, you can perform the following operation any number of times:
//
//Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
//Replace the pair with their sum.
//Return the minimum number of operations needed to make the array non-decreasing.
//
//An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).
//
//
//
//Example 1:
//
//Input: nums = [5,2,3,1]
//
//Output: 2
//
//Explanation:
//
//The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].
//The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].
//The array nums became non-decreasing in two operations.
//
//Example 2:
//
//Input: nums = [1,2,2]
//
//Output: 0
//
//Explanation:
//
//The array nums is already sorted.
//
//
//
//Constraints:
//
//1 <= nums.length <= 50
//-1000 <= nums[i] <= 1000
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MinimumPairRemovalToSortArrayI_3507 {
    public static int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int x:nums){
            list.add(x);
        }
        int res=0;
        while(!isSorted(list)){
            int pair =foundPairs(list);
            int sum = list.get(pair)+list.get(pair+1);
            list.remove(pair);
            list.set(pair,sum);
            res++;
        }
        return res;
    }

    public static int foundPairs(List<Integer> nums){
        int min= Integer.MAX_VALUE;
        int pair =-1;
        for(int i =0;i<nums.size()-1;i++){
            int sum =nums.get(i)+nums.get(i+1);
            if(sum<min){
                pair=i;
                min = sum;
            }
        }
        return pair;
    }
    public static boolean isSorted(List<Integer> nums){
        for(int i =0;i<nums.size()-1;i++){
            if(nums.get(i)>nums.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {5,2,3,1};
        int output1= 2;

        //Example 2:

        int [] nums2 = {1,2,2};
        int output2= 0;

        int ans1 = minimumPairRemoval(nums1);
        int ans2 = minimumPairRemoval(nums2);
        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }

    }
}
