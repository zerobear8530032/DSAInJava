//3494. Find the Minimum Amount of Time to Brew Potions
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two integer arrays, skill and mana, of length n and m, respectively.
//
//In a laboratory, n wizards must brew m potions in order. Each potion has a mana capacity mana[j] and must pass through all the wizards sequentially to be brewed properly. The time taken by the ith wizard on the jth potion is timeij = skill[i] * mana[j].
//
//Since the brewing process is delicate, a potion must be passed to the next wizard immediately after the current wizard completes their work. This means the timing must be synchronized so that each wizard begins working on a potion exactly when it arrives. ​
//
//Return the minimum amount of time required for the potions to be brewed properly.
//
//
//
//Example 1:
//
//Input: skill = [1,5,2,4], mana = [5,1,4,2]
//
//Output: 110
//
//Explanation:
//
//Potion Number	Start time	Wizard 0 done by	Wizard 1 done by	Wizard 2 done by	Wizard 3 done by
//0	0	5	30	40	60
//1	52	53	58	60	64
//2	54	58	78	86	102
//3	86	88	98	102	110
//As an example for why wizard 0 cannot start working on the 1st potion before time t = 52, consider the case where the wizards started preparing the 1st potion at time t = 50. At time t = 58, wizard 2 is done with the 1st potion, but wizard 3 will still be working on the 0th potion till time t = 60.
//
//Example 2:
//
//Input: skill = [1,1,1], mana = [1,1,1]
//
//Output: 5
//
//Explanation:
//
//Preparation of the 0th potion begins at time t = 0, and is completed by time t = 3.
//Preparation of the 1st potion begins at time t = 1, and is completed by time t = 4.
//Preparation of the 2nd potion begins at time t = 2, and is completed by time t = 5.
//Example 3:
//
//Input: skill = [1,2,3,4], mana = [1,2]
//
//Output: 21
//
//
//
//Constraints:
//
//n == skill.length
//m == mana.length
//1 <= n, m <= 5000
//1 <= mana[i], skill[i] <= 5000

package BinarySearch;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindTheMinimumAmountOfTimeToBrewPotions_3494 {

    public static long minTime(int[] skill, int[] mana) {
        int n= skill.length;
        int m= mana.length;
        long [] finishTime = new long [n];
        for(int i =0;i<m;i++){
            finishTime[0]+= mana[i]*skill[0];
            for(int j=1;j<n;j++){
                finishTime[j]= Math.max(finishTime[j],finishTime[j-1])+ (mana[i]*skill[j]);
            }
            for(int j=n-1;j>0;j--){
                finishTime[j-1]= finishTime[j]-(mana[i]*skill[j]);
            }
        }
        return finishTime[n-1];
    }
    public static void main(String[] args) {
        //Example 1:

        int [] skill1 = {1,5,2,4}, mana1 = {5,1,4,2};
        int output1= 110;

        //Example 2:

        int [] skill2 = {1,1,1}, mana2 = {1,1,1};
        int output2= 5;

        //Example 3:

        int [] skill3 = {1,2,3,4}, mana3 = {1,2};
        int output3= 21;

        long ans1 = minTime(skill1,mana1);
        long ans2 = minTime(skill2,mana2);
        long ans3 = minTime(skill3,mana3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
