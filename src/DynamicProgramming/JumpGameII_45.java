//45. Jump Game II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.
//
//Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:
//
//0 <= j <= nums[i] and
//i + j < n
//Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.
//
//
//
//Example 1:
//
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
//Example 2:
//
//Input: nums = [2,3,0,1,4]
//Output: 2
//
//
//Constraints:
//
//1 <= nums.length <= 104
//0 <= nums[i] <= 1000
//It's guaranteed that you can reach nums[n - 1].
package DynamicProgramming;

public class JumpGameII_45 {
//    tabulation dp : first try every single way the optimize till tabulation
//    time complexity : O(n^2);
//    space complexity : O(n);

    public static int jump(int[] nums) {
        int [] table = new int [nums.length];
        table[0]= 1;
        for(int i =0;i<nums.length;i++){
            if(table[i]==0){continue;}
            for(int j=1;j<=nums[i];j++){
                if(j+i>=nums.length){
                    continue;
                }else{
                    if(table[i+j]==0){
                        table[i+j]=table[i]+1;
                    }else{
                        table[i+j]= Math.min(table[i+j],table[i]+1);
                    }
                }
            }
        }
        return table[nums.length-1]-1;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {2,3,1,1,4};
        int output1=2;

        //Example 2:

        int [] nums2 = {2,3,0,1,4};
        int output2=2;

        int ans1= jump(nums1);
        int ans2= jump(nums2);

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


    }
}
