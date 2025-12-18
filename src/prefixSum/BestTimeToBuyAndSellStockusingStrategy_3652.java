//3652. Best Time to Buy and Sell Stock using Strategy
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two integer arrays prices and strategy, where:
//
//prices[i] is the price of a given stock on the ith day.
//strategy[i] represents a trading action on the ith day, where:
//-1 indicates buying one unit of the stock.
//0 indicates holding the stock.
//1 indicates selling one unit of the stock.
//You are also given an even integer k, and may perform at most one modification to strategy. A modification consists of:
//
//Selecting exactly k consecutive elements in strategy.
//Set the first k / 2 elements to 0 (hold).
//Set the last k / 2 elements to 1 (sell).
//The profit is defined as the sum of strategy[i] * prices[i] across all days.
//
//Return the maximum possible profit you can achieve.
//
//Note: There are no constraints on budget or stock ownership, so all buy and sell operations are feasible regardless of past actions.
//
//
//
//Example 1:
//
//Input: prices = [4,2,8], strategy = [-1,0,1], k = 2
//
//Output: 10
//
//Explanation:
//
//Modification	Strategy	Profit Calculation	Profit
//Original	[-1, 0, 1]	(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8	4
//Modify [0, 1]	[0, 1, 1]	(0 × 4) + (1 × 2) + (1 × 8) = 0 + 2 + 8	10
//Modify [1, 2]	[-1, 0, 1]	(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8	4
//Thus, the maximum possible profit is 10, which is achieved by modifying the subarray [0, 1]​​​​​​​.
//
//Example 2:
//
//Input: prices = [5,4,3], strategy = [1,1,0], k = 2
//
//Output: 9
//
//Explanation:
//
//Modification	Strategy	Profit Calculation	Profit
//Original	[1, 1, 0]	(1 × 5) + (1 × 4) + (0 × 3) = 5 + 4 + 0	9
//Modify [0, 1]	[0, 1, 0]	(0 × 5) + (1 × 4) + (0 × 3) = 0 + 4 + 0	4
//Modify [1, 2]	[1, 0, 1]	(1 × 5) + (0 × 4) + (1 × 3) = 5 + 0 + 3	8
//Thus, the maximum possible profit is 9, which is achieved without any modification.
//
//
//
//Constraints:
//
//2 <= prices.length == strategy.length <= 105
//1 <= prices[i] <= 105
//-1 <= strategy[i] <= 1
//2 <= k <= prices.length
//k is even
package prefixSum;

public class BestTimeToBuyAndSellStockusingStrategy_3652 {
//    approch:
//     we can solve this question using prefix sum
//    create 2 prefix array with operation one with price
//    nowe we can precomputer initial res with using strategy
//    and we can use prefix sum technique to find sum of continous selling
//    time complexity : O(n)
//    space complexity : O(n)
    public static long maxProfit(int[] prices, int[] strategy, int k) {
        long [] operationPrefixSum = new long[prices.length];
        long [] pricePrefixSum = new long[prices.length];
        // long [] pricePrefixSum = new long[prices.length];
        long sum =0;
        int n =prices.length;
        long priceSum=0;
        for(int i =0;i<prices.length;i++){
            sum+= prices[i]*strategy[i];
            operationPrefixSum[i]=sum;
            priceSum+= prices[i];
            pricePrefixSum[i]= priceSum;
        }
        long res=operationPrefixSum[n-1];
        for(int i =0;i<=n-k;i++){
            long totalSum = operationPrefixSum[n-1];
            long rightSum = operationPrefixSum[i+k-1];
            long leftSum = i-1>=0?operationPrefixSum[i-1]:0;
            long newSum= totalSum- (rightSum-leftSum);

            long totalPrice= pricePrefixSum[i+k-1];
            long leftPrice= ((i+k-1)-(k/2))>=0 ?pricePrefixSum[((i+k-1)-(k/2))]:0;
            long finalPrice= totalPrice-leftPrice;
            res=Math.max(res,finalPrice+newSum);
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] prices1 = {4,2,8}, strategy1 = {-1,0,1};
        int k1 = 2;
        int output1= 10;

        //Example 2:

        int [] prices2 = {5,4,3}, strategy2 = {1,1,0};
        int k2 = 2;
        int output2= 9;


        long ans1= maxProfit(prices1,strategy1,k1);
        long ans2= maxProfit(prices2,strategy2,k2);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :" + (output2));
            System.out.println("Your Answer :" + (ans2));
        }
    }
}
