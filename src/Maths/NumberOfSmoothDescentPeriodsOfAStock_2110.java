//2110. Number of Smooth Descent Periods of a Stock
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array prices representing the daily price history of a stock, where prices[i] is the stock price on the ith day.
//
//A smooth descent period of a stock consists of one or more contiguous days such that the price on each day is lower than the price on the preceding day by exactly 1. The first day of the period is exempted from this rule.
//
//Return the number of smooth descent periods.
//
//
//
//Example 1:
//
//Input: prices = [3,2,1,4]
//Output: 7
//Explanation: There are 7 smooth descent periods:
//[3], [2], [1], [4], [3,2], [2,1], and [3,2,1]
//Note that a period with one day is a smooth descent period by the definition.
//Example 2:
//
//Input: prices = [8,6,7,7]
//Output: 4
//Explanation: There are 4 smooth descent periods: [8], [6], [7], and [7]
//Note that [8,6] is not a smooth descent period as 8 - 6 ≠ 1.
//Example 3:
//
//Input: prices = [1]
//Output: 1
//Explanation: There is 1 smooth descent period: [1]
//
//
//Constraints:
//
//1 <= prices.length <= 105
//1 <= prices[i] <= 105
package Maths;

public class NumberOfSmoothDescentPeriodsOfAStock_2110 {
//    approch :
//    we can find decreasing sub array length
//    and the number of subarray it created which are descent period is sum of n natural numbers
//    till that length so if the descent period is of length 5 so it can create 5+4+3+2+1 descend period sections
//    time complexity : O(n)
//    space complexity : O(1)
    public  static long getDescentPeriods(int[] nums) {
        long res=0;
        int idx=0;
        int n = nums.length;
        while(idx<n){
            long seqlen=1;
            while(idx+1<n && nums[idx]-1 == nums[idx+1]){
                idx++;
                seqlen++;
            }
            res+=(seqlen*(seqlen+1))/2;;
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] prices1 = {3,2,1,4};
        int output1= 7;

        //Example 2:

        int [] prices2 = {8,6,7,7};
        int output2 = 4;
        //Example 3:

        int [] prices3 = {1};
        int output3 = 1;

        long ans1= getDescentPeriods(prices1);
        long ans2= getDescentPeriods(prices2);
        long ans3= getDescentPeriods(prices3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
    }
}
