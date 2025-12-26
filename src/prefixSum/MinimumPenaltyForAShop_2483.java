//2483. Minimum Penalty for a Shop
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':
//
//if the ith character is 'Y', it means that customers come at the ith hour
//whereas 'N' indicates that no customers come at the ith hour.
//If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
//
//For every hour when the shop is open and no customers come, the penalty increases by 1.
//For every hour when the shop is closed and customers come, the penalty increases by 1.
//Return the earliest hour at which the shop must be closed to incur a minimum penalty.
//
//Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.
//
//
//
//Example 1:
//
//Input: customers = "YYNY"
//Output: 2
//Explanation:
//- Closing the shop at the 0th hour incurs in 1+1+0+1 = 3 penalty.
//- Closing the shop at the 1st hour incurs in 0+1+0+1 = 2 penalty.
//- Closing the shop at the 2nd hour incurs in 0+0+0+1 = 1 penalty.
//- Closing the shop at the 3rd hour incurs in 0+0+1+1 = 2 penalty.
//- Closing the shop at the 4th hour incurs in 0+0+1+0 = 1 penalty.
//Closing the shop at 2nd or 4th hour gives a minimum penalty. Since 2 is earlier, the optimal closing time is 2.
//Example 2:
//
//Input: customers = "NNNNN"
//Output: 0
//Explanation: It is best to close the shop at the 0th hour as no customers arrive.
//Example 3:
//
//Input: customers = "YYYY"
//Output: 4
//Explanation: It is best to close the shop at the 4th hour as customers arrive at each hour.
//
//
//Constraints:
//
//1 <= customers.length <= 105
//customers consists only of characters 'Y' and 'N'.
package prefixSum;

public class MinimumPenaltyForAShop_2483 {
//    Approch : we can see
//    we can close shop any time and before closing shop its always open
//    so we can find prefix sum of n
//    and suffix sum of Y
//    then we can compute penalty in O(1) by summing each other
//    to calculte penalty we need to also consider when we close at certain time
//    that time if customer is there its penalty also included
//    rest we just need to check lowest penalty and update the hrs
//    time compelxity : O(n)
//    space compelxity : O(n)
//

    public static int bestClosingTime(String customers) {
        int n = customers.length();
        int [] prefixN= new int [n+1];
        int [] suffixY= new int [n+1];
        int nsum=0;
        for(int i =0;i<n;i++){
            char ch =customers.charAt(i);
            if(ch=='N'){
                nsum++;
            }
            prefixN[i]=nsum;
        }
        int ysum=0;
        for(int i =n-1;i>=0;i--){
            char ch =customers.charAt(i);
            if(ch=='Y'){
                ysum++;
            }
            suffixY[i]=ysum;
        }
//        suffix sum initally will be 0
        suffixY[n]=0;
        prefixN[n]=nsum;// prefix sum last value is same as second last
        int minPenalty= Integer.MAX_VALUE;
        int minhrs=0;// it update each time we found new better lowest penalty
        for(int i  =0;i<n+1;i++){
            int penalty = prefixN[i]+suffixY[i];
            if(i<n && customers.charAt(i)=='N'){penalty--;}
            if(minPenalty>penalty){
                minPenalty=penalty;
                minhrs=i;
            }
            // System.out.println("hr :"+i+"   "+"Penalty :"+penalty);
        }
        // System.out.println(Arrays.toString(prefixN));
        // System.out.println(Arrays.toString(suffixY));
        return minhrs;
    }

    public static void main(String[] args) {
        //Example 1:

        String  customers1 = "YYNY";
        int output1= 2;

        //Example 2:

        String  customers2 = "NNNNN";
        int output2= 2;

        //Example 3:

        String  customers3 = "YYYY";
        int output3= 4;

        int ans1 = bestClosingTime(customers1);
        int ans2 = bestClosingTime(customers2);
        int ans3 = bestClosingTime(customers3);

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
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }


    }
}
