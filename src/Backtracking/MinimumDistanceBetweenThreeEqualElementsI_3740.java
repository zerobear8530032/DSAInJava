//3740. Minimum Distance Between Three Equal Elements I
//Solved
//Easy
//premium lock icon
//Companies
//Hint
//You are given an integer array nums.
//
//A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].
//
//The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.
//
//Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.
//
//
//
//Example 1:
//
//Input: nums = [1,2,1,1,3]
//
//Output: 6
//
//Explanation:
//
//The minimum distance is achieved by the good tuple (0, 2, 3).
//
//(0, 2, 3) is a good tuple because nums[0] == nums[2] == nums[3] == 1. Its distance is abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6.
//
//Example 2:
//
//Input: nums = [1,1,2,3,2,1,2]
//
//Output: 8
//
//Explanation:
//
//The minimum distance is achieved by the good tuple (2, 4, 6).
//
//(2, 4, 6) is a good tuple because nums[2] == nums[4] == nums[6] == 2. Its distance is abs(2 - 4) + abs(4 - 6) + abs(6 - 2) = 2 + 2 + 4 = 8.
//
//Example 3:
//
//Input: nums = [1]
//
//Output: -1
//
//Explanation:
//
//There are no good tuples. Therefore, the answer is -1.
//
//
//
//Constraints:
//
//1 <= n == nums.length <= 100
//1 <= nums[i] <= n
package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumDistanceBetweenThreeEqualElementsI_3740 {
    public static int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                List<Integer> indexes= new ArrayList<>();
                indexes.add(i);
                map.put(nums[i],indexes);
            }
        }
        int res=Integer.MAX_VALUE;
        for(int key: map.keySet()){
            List<Integer> indexes= map.get(key);
            if(indexes.size()>=3){
                for(int i =0;i<indexes.size()-2;i++){
                    int distance = Math.abs(indexes.get(i)-indexes.get(i+1))+Math.abs(indexes.get(i+1)-indexes.get(i+2))+
                            Math.abs(indexes.get(i+2)-indexes.get(i));
                    res=Math.min(distance,res);
                }
            }
        }
        return res==Integer.MAX_VALUE? -1:res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,1,1,3};
        int output1= 6;

        //Example 2:

        int [] nums2 = {1,1,2,3,2,1,2};
        int output2= 8;

        //Example 3:

        int [] nums3 = {1};
        int output3= -1;

        int ans1 = minimumDistance(nums1);
        int ans2 = minimumDistance(nums2);
        int ans3 = minimumDistance(nums3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+(output3));
            System.out.println("Your Answer :"+ (ans3));
        }





    }
}
