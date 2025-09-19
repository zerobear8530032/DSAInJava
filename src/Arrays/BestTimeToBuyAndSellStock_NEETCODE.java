//Best Time to Buy and Sell Stock
//Solved
//You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
//
//You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
//
//Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
//
//Example 1:
//
//Input: prices = [10,1,5,6,7,1]
//
//Output: 6
//Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.
//
//Example 2:
//
//Input: prices = [10,8,7,5,2]
//
//Output: 0
//Explanation: No profitable transactions can be made, thus the max profit is 0.
//
//Constraints:
//
//1 <= prices.length <= 100
//0 <= prices[i] <= 100

package Arrays;

public class BestTimeToBuyAndSellStock_NEETCODE {
//     approch : here we can say if the buy price is smaller then sell price
//     we can calculate the profit other wise we will update the buy price if the buy price is greater then the
//     current price our max profit will alwys keep track of max profit so far
//     time complexity : O(n)
//     space complexity : O(1)
        public  static int maxProfit(int[] prices) {
            //  lets do brute force approch :
            int maxProfit=0;
            int buy=prices[0];
            for(int i=0;i<prices.length;i++){
                if(buy<prices[i]){
                    int profit= prices[i]-buy;
                    maxProfit= Math.max(maxProfit,profit);
                }else{
                    buy=prices[i];
                    int profit= prices[i]-buy;
                    maxProfit= Math.max(maxProfit,profit);
                }
            }
            return maxProfit;
        }

    public static void main(String[] args) {
        //Example 1:

        int [] prices1 = {10,1,5,6,7,1};
        int output1=6;

        //Example 2:

        int [] prices2 = {10,8,7,5,2};
        int output2=0;

        int ans1= maxProfit(prices1);
        int ans2= maxProfit(prices2);
        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }

    }
}
