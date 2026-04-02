//1980. Find Unique Binary String
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.
//
//
//
//Example 1:
//
//Input: nums = ["01","10"]
//Output: "11"
//Explanation: "11" does not appear in nums. "00" would also be correct.
//Example 2:
//
//Input: nums = ["00","01"]
//Output: "11"
//Explanation: "11" does not appear in nums. "10" would also be correct.
//Example 3:
//
//Input: nums = ["111","011","001"]
//Output: "101"
//Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
//
//
//Constraints:
//
//n == nums.length
//1 <= n <= 16
//nums[i].length == n
//nums[i] is either '0' or '1'.
//All the strings of nums are unique.
package Strings;

import java.util.HashSet;

public class FindUniqueBinaryString_1980 {
//    approch : here we can try every number in range use hashset to optimize the search
//    time complexity : O(n)
//    space complexity : O(n)
    public static String findDifferentBinaryString(String[] nums) {
        HashSet<String> res = new HashSet();
        for(String s:nums){
            res.add(s);
        }
        for(int i =0;i<=(1<<nums[0].length())-1;i++){
            String str= String.format("%"+nums[0].length()+"s",Integer.toBinaryString(i)).replace(' ','0');
            if(!res.contains(str)){
                return str;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        //Example 1:

        String [] nums1 = {"01","10"};
        String output1= "00";

        //Example 2:

        String [] nums2 = {"00","01"};
        String output2= "10";

        //Example 3:

        String [] nums3 = {"111","011","001"};
        String output3= "000";

        String ans1= findDifferentBinaryString(nums1);
        String ans2= findDifferentBinaryString(nums2);
        String ans3= findDifferentBinaryString(nums3);

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }

    }
}
