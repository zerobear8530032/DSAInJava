//3005. Count Elements With Maximum Frequency
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array nums consisting of positive integers.
//
//Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
//
//The frequency of an element is the number of occurrences of that element in the array.
//
//
//
//Example 1:
//
//Input: nums = [1,2,2,3,1,4]
//Output: 4
//Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
//So the number of elements in the array with maximum frequency is 4.
//Example 2:
//
//Input: nums = [1,2,3,4,5]
//Output: 5
//Explanation: All elements of the array have a frequency of 1 which is the maximum.
//So the number of elements in the array with maximum frequency is 5.
//
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 100

package Arrays;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency_3005 {


    public static int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int maxFreq=0;
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
            maxFreq=Math.max(maxFreq,map.get(x));
        }
        // find the number of element hving max freq
        int count =0;
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()==maxFreq){
                count++;
            }
        }
        return count*maxFreq;

    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,2,3,1,4};
        int output1= 4;
        //Example 2:

        int [] nums2 = {1,2,3,4,5};
        int output2= 5;

        int ans1= maxFrequencyElements(nums1);
        int ans2= maxFrequencyElements(nums2);


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


    }
}
