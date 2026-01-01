//3789. Minimum Cost to Acquire Required Items
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given five integers cost1, cost2, costBoth, need1, and need2.
//
//There are three types of items available:
//
//An item of type 1 costs cost1 and contributes 1 unit to the type 1 requirement only.
//An item of type 2 costs cost2 and contributes 1 unit to the type 2 requirement only.
//An item of type 3 costs costBoth and contributes 1 unit to both type 1 and type 2 requirements.
//You must collect enough items so that the total contribution toward type 1 is at least need1 and the total contribution toward type 2 is at least need2.
//
//Return an integer representing the minimum possible total cost to achieve these requirements.
//
//
//
//Example 1:
//
//Input: cost1 = 3, cost2 = 2, costBoth = 1, need1 = 3, need2 = 2
//
//Output: 3
//
//Explanation:
//
//After buying three type 3 items, which cost 3 * 1 = 3, the total contribution to type 1 is 3 (>= need1 = 3) and to type 2 is 3 (>= need2 = 2).
//Any other valid combination would cost more, so the minimum total cost is 3.
//
//Example 2:
//
//Input: cost1 = 5, cost2 = 4, costBoth = 15, need1 = 2, need2 = 3
//
//Output: 22
//
//Explanation:
//
//We buy need1 = 2 items of type 1 and need2 = 3 items of type 2: 2 * 5 + 3 * 4 = 10 + 12 = 22.
//Any other valid combination would cost more, so the minimum total cost is 22.
//
//Example 3:
//
//Input: cost1 = 5, cost2 = 4, costBoth = 15, need1 = 0, need2 = 0
//
//Output: 0
//
//Explanation:
//
//Since no items are required (need1 = need2 = 0), we buy nothing and pay 0.
//
//
//
//Constraints:
//
//1 <= cost1, cost2, costBoth <= 106
//0 <= need1, need2 <= 109
package Maths;

public class MinimumCostToAcquireRequiredItems_3789 {
//    approch : dp will fail so i used just 4 cases
//    first if all need1, need2 will be bough from both cost
//    second case if need1 and need2 will be bought from their costs
//    third case if need1 is smaller i can buy that from both then rest from need2 cost
//    forth case if need2 is smaller i can buy that from both then rest from need1 cost
    public static long minimumCost(long cost1, long cost2, long costBoth, long need1, long need2) {
        long res = Long.MAX_VALUE;
        long need1cost = cost1 * need1;
        long need2cost = cost2 * need2;
        res = Math.min(need2cost + need1cost, res);// buy need1,need2 from their cost
        long totalBothCost = costBoth * Math.max(need1, need2);
        res = Math.min(totalBothCost, res);// buy both from costBoth
        if (need1 < need2) {
            // buy need1 with both cost and rest from both 2 cost
            long bothsmaller = costBoth * need1;
            res = Math.min(res, bothsmaller + (need2 - need1) * cost2);
        } else {// buy need2 with both cost and rest from both 1 cost
            long bothsmaller = costBoth * need2;
            res = Math.min(res, bothsmaller + (need1 - need2) * cost1);
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int  cost11 = 3, cost12 = 2, costBoth1 = 1, need11 = 3, need12 = 2;
        int output1= 3;

        //Example 2:

        int  cost21 = 5, cost22 = 4, costBoth2 = 15, need21 = 2, need22 = 3;
        int output2= 22;

        //Example 3:

        int  cost31 = 5, cost32 = 4, costBoth3 = 15, need31 = 0, need32 = 0;
        int output3= 0;

        long ans1 =minimumCost(cost11,cost12,costBoth1,need11,need12);
        long ans2 =minimumCost(cost21,cost22,costBoth2,need21,need22);
        long ans3 =minimumCost(cost31,cost32,costBoth3,need31,need32);

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
