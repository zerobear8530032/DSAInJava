//961. N-Repeated Element in Size 2N Array
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//You are given an integer array nums with the following properties:
//
//nums.length == 2 * n.
//nums contains n + 1 unique elements.
//Exactly one element of nums is repeated n times.
//Return the element that is repeated n times.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,3,3]
//Output: 3
//Example 2:
//
//Input: nums = [2,1,2,5,3,2]
//Output: 2
//Example 3:
//
//Input: nums = [5,1,5,2,5,3,5,4]
//Output: 5
// 
//
//Constraints:
//
//2 <= n <= 5000
//nums.length == 2 * n
//0 <= nums[i] <= 104
//nums contains n + 1 unique elements and one of them is repeated exactly n times.
package HashMap;

class RepeatedElementInSize2NArray_961 {
    public static int repeatedNTimes(int[] nums) {
        int [] map = new int [100000];
        for(int x:nums){
            map[x]++;
        }
        int res=  -1;
        for(int i=0;i<map.length;i++){
            if(map[i]==nums.length/2){
                res=i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3,3};
        int output1= 3;
        
        //Example 2:
        
        int [] nums2 = {2,1,2,5,3,2};
        int output2= 2;
        
        //Example 3:
        
        int [] nums3 = {5,1,5,2,5,3,5,4};
        int output3= 5;

        int ans1 =  repeatedNTimes(nums1);
        int ans2 =  repeatedNTimes(nums2);
        int ans3 =  repeatedNTimes(nums3);

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
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }

    }
}