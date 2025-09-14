//\3684. Maximize Sum of At Most K Distinct Elements
//Solved
//Easy
//premium lock icon
//Companies
//Hint
//You are given a positive integer array nums and an integer k.
//
//Choose at most k elements from nums so that their sum is maximized. However, the chosen numbers must be distinct.
//
//Return an array containing the chosen numbers in strictly descending order.
//
//
//
//Example 1:
//
//Input: nums = [84,93,100,77,90], k = 3
//
//Output: [100,93,90]
//
//Explanation:
//
//The maximum sum is 283, which is attained by choosing 93, 100 and 90. We rearrange them in strictly descending order as [100, 93, 90].
//
//Example 2:
//
//Input: nums = [84,93,100,77,93], k = 3
//
//Output: [100,93,84]
//
//Explanation:
//
//The maximum sum is 277, which is attained by choosing 84, 93 and 100. We rearrange them in strictly descending order as [100, 93, 84]. We cannot choose 93, 100 and 93 because the chosen numbers must be distinct.
//
//Example 3:
//
//Input: nums = [1,1,1,2,2,2], k = 6
//
//Output: [2,1]
//
//Explanation:
//
//The maximum sum is 3, which is attained by choosing 1 and 2. We rearrange them in strictly descending order as [2, 1].
//
//
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 109
//1 <= k <= nums.length

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizeSumOfAtMostKDistinctElements_3684 {
    public static int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list= new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            if(list.size()==0){
                list.add(nums[i]);
            }else if(list.get(list.size()-1)!=nums[i]){
                list.add(nums[i]);
            }
        }
        int [] output= new int [Math.min(list.size(),k)];
        for(int i =0;i<output.length;i++){
            output[i]= list.get(i);
        }
        return output;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {84,93,100,77,90};
        int k1 = 3;
        int [] output1= {100,93,90};

        //Example 2:

        int [] nums2 = {84,93,100,77,93};
        int k2 = 3;
        int [] output2= {100,93,84};

        //Example 3:

        int [] nums3 = {1,1,1,2,2,2};
        int k3 = 6;
        int [] output3= {2,1};

        int [] ans1= maxKDistinct(nums1,k1);
        int [] ans2= maxKDistinct(nums2,k2);
        int [] ans3= maxKDistinct(nums3,k3);

        if(Arrays.equals(output1,ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ Arrays.toString(output1));
            System.out.println("Your Answer :"+ Arrays.toString(ans1));
        }
        if(Arrays.equals(output2,ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+Arrays.toString(output2));
            System.out.println("Your Answer :"+ Arrays.toString(ans2));
        }
        if(Arrays.equals(output2,ans2)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ Arrays.toString(output3));
            System.out.println("Your Answer :"+ Arrays.toString(ans3));
        }



    }
}
