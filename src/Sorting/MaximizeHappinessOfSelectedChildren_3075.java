//3075. Maximize Happiness of Selected Children
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array happiness of length n, and a positive integer k.
//
//There are n children standing in a queue, where the ith child has happiness value happiness[i]. You want to select k children from these n children in k turns.
//
//In each turn, when you select a child, the happiness value of all the children that have not been selected till now decreases by 1. Note that the happiness value cannot become negative and gets decremented only if it is positive.
//
//Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.
//
//
//
//Example 1:
//
//Input: happiness = [1,2,3], k = 2
//Output: 4
//Explanation: We can pick 2 children in the following way:
//- Pick the child with the happiness value == 3. The happiness value of the remaining children becomes [0,1].
//- Pick the child with the happiness value == 1. The happiness value of the remaining child becomes [0]. Note that the happiness value cannot become less than 0.
//The sum of the happiness values of the selected children is 3 + 1 = 4.
//Example 2:
//
//Input: happiness = [1,1,1,1], k = 2
//Output: 1
//Explanation: We can pick 2 children in the following way:
//- Pick any child with the happiness value == 1. The happiness value of the remaining children becomes [0,0,0].
//- Pick the child with the happiness value == 0. The happiness value of the remaining child becomes [0,0].
//The sum of the happiness values of the selected children is 1 + 0 = 1.
//Example 3:
//
//Input: happiness = [2,3,4,5], k = 1
//Output: 5
//Explanation: We can pick 1 child in the following way:
//- Pick the child with the happiness value == 5. The happiness value of the remaining children becomes [1,2,3].
//The sum of the happiness values of the selected children is 5.
//
//
//Constraints:
//
//1 <= n == happiness.length <= 2 * 105
//1 <= happiness[i] <= 108
//1 <= k <= n
package Sorting;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren_3075 {
//    approch :
//    we can sort the array and choose children with highest happiness
//    and each time we choose a children we will decreasing the  next children
//    happiness by happines-1
//    and at the end  if we choose k children we can break or if the children happiness reaches 0
//    because if the highest happiness is 0 means no other children have more happinesss then 0
//
//    approch: time complexity : O(N log N)
//    space: time complexity : O(1)
    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long child=0;
        long res=0;
        for(int i =happiness.length-1;i>=0;i--){
            if(happiness[i]-child>0){
                res+=happiness[i]-child;
            }
            child++;
            if(child==k){break;}
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] happiness1 = {1,2,3};
        int k1 = 2;
        int output1= 4;

        //Example 2:

        int [] happiness2 = {1,1,1,1};
        int k2 = 2;
        int output2= 1;

        //Example 3:

        int [] happiness3 = {2,3,4,5};
        int k3 = 1;
        int output3= 5;

        long ans1 = maximumHappinessSum(happiness1,k1);
        long ans2 = maximumHappinessSum(happiness2,k2);
        long ans3 = maximumHappinessSum(happiness3,k3);

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
