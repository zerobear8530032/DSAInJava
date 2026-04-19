//Best Time to Buy and Sell Stock II
//Medium
//Topics
//Company Tags
//You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
//
//On each day, you may decide to buy and/or sell the stock. However, you can buy it then immediately sell it on the same day. Also, you are allowed to perform any number of transactions but can hold at most one share of the stock at any time.
//
//Find and return the maximum profit you can achieve.
//
//Example 1:
//
//Input: prices = [7,1,5,3,6,4]
//
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3. Total profit is 4 + 3 = 7.
//
//Example 2:
//
//Input: prices = [1,2,3,4,5]
//
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4. Total profit is 4.
//
//Constraints:
//
//1 <= prices.length <= 30,000
//0 <= prices[i] <= 10,000
package DynamicProgramming;

public class BestTimeToBuyAndSellStockII {

// approch : find the longest incresing sub array and  take difference of starting and ending of it
//    at the end sum all of them together
//    time complxity: O(n)
//    space complxity: O(n)
    public static int maxProfit(int[] prices) {
        int idx=0;
        int n = prices.length;
        int res=0;
        while(idx<n){
            int l =idx;
            boolean increment =false;
            while(idx+1<n && prices[idx]<prices[idx+1]){
                idx++;
                increment=true;
            }
            if(increment){
                // System.out.println(l+" "+idx);
                res+= (prices[idx]-prices[l]);
            }

            idx++;
        }

        return res;
    }
    public static void main(String[] args) {

        //Example 1:

        int [] prices1 = {7,1,5,3,6,4};
        int output1= 7;

        //Example 2:

        int [] prices2 = {1,2,3,4,5};
        int output2= 4;

        int ans1 = maxProfit(prices1);
        int ans2 = maxProfit(prices2);


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
