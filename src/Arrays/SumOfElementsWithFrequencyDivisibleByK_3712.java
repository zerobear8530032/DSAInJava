//3712. Sum of Elements With Frequency Divisible by K
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums and an integer k.
//
//Return an integer denoting the sum of all elements in nums whose frequency is divisible by k, or 0 if there are no such elements.
//
//Note: An element is included in the sum exactly as many times as it appears in the array if its total frequency is divisible by k.
//
//
//
//Example 1:
//
//Input: nums = [1,2,2,3,3,3,3,4], k = 2
//
//Output: 16
//
//Explanation:
//
//The number 1 appears once (odd frequency).
//The number 2 appears twice (even frequency).
//The number 3 appears four times (even frequency).
//The number 4 appears once (odd frequency).
//So, the total sum is 2 + 2 + 3 + 3 + 3 + 3 = 16.
//
//Example 2:
//
//Input: nums = [1,2,3,4,5], k = 2
//
//Output: 0
//
//Explanation:
//
//There are no elements that appear an even number of times, so the total sum is 0.
//
//Example 3:
//
//Input: nums = [4,4,4,1,2,3], k = 3
//
//Output: 12
//
//Explanation:
//
//The number 1 appears once.
//The number 2 appears once.
//The number 3 appears once.
//The number 4 appears three times.
//So, the total sum is 4 + 4 + 4 = 12.
//
//
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 100
//1 <= k <= 100
package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SumOfElementsWithFrequencyDivisibleByK_3712 {
//    approch :
//    compute frequnecy then just divide by k which are completely divisibl are our values
//    which are valid and we can do valu*frequency sum of all such values
//    time complexity : O(n)
//    space complexity : O(n)
    public static int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int sum =0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int value = e.getKey();
            int freq = e.getValue();
            if(freq%k==0){
                sum+= (freq*value);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,2,3,3,3,3,4};
        int k1 = 2;
        int output1= 16;

        //Example 2:

        int [] nums2 = {1,2,3,4,5};
        int k2 = 2;
        int output2= 0;

        //Example 3:


        int [] nums3 = {4,4,4,1,2,3};
        int k3 = 3;
        int output3= 12;

        int ans1 = sumDivisibleByK(nums1,k1);
        int ans2 = sumDivisibleByK(nums2,k2);
        int ans3 = sumDivisibleByK(nums3,k3);
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
