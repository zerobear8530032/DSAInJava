//3147. Taking Maximum Energy From the Mystic Dungeon
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//In a mystic dungeon, n magicians are standing in a line. Each magician has an attribute that gives you energy. Some magicians can give you negative energy, which means taking energy from you.
//
//You have been cursed in such a way that after absorbing energy from magician i, you will be instantly transported to magician (i + k). This process will be repeated until you reach the magician where (i + k) does not exist.
//
//In other words, you will choose a starting point and then teleport with k jumps until you reach the end of the magicians' sequence, absorbing all the energy during the journey.
//
//You are given an array energy and an integer k. Return the maximum possible energy you can gain.
//
//Note that when you are reach a magician, you must take energy from them, whether it is negative or positive energy.
//
//
//
//Example 1:
//
//Input: energy = [5,2,-10,-5,1], k = 3
//
//Output: 3
//
//Explanation: We can gain a total energy of 3 by starting from magician 1 absorbing 2 + 1 = 3.
//
//Example 2:
//
//Input: energy = [-2,-3,-1], k = 2
//
//Output: -1
//
//Explanation: We can gain a total energy of -1 by starting from magician 2.
//
//
//
//Constraints:
//
//1 <= energy.length <= 105
//-1000 <= energy[i] <= 1000
//1 <= k <= energy.length - 1
//
package Recursion;

public class TakingMaximumEnergyFromTheMysticDungeon_3147 {
//    brute force approch :
//    simiulte the sum from each index by going k step ahead
//    time complexity : O(n * n/k)
    public static  int maximumEnergy(int[] energy, int k) {
        int res=Integer.MIN_VALUE;
        for(int i =0;i<energy.length;i++){
            int sum =0;
            for(int j=i;j<energy.length;j+=k){
                sum+=energy[j];
            }
            res=Math.max(sum,res);
        }
        return res;
    }
//  better approch :
//  use bottom up approch :
//  traverse reverse and get the previous element to sum of k step ahead elemnt ans maintain the max sum :
//  time complexity : O(n)
//  space complexity : O(1)
    public static  int maximumEnergyBetter(int[] energy, int k) {
        int res=Integer.MIN_VALUE;
        int n= energy.length;
        for(int i =n-1;i>=0;i--){
            if(i+k<n){
                energy[i]+=energy[i+k];
            }
            res=Math.max(energy[i],res);// check every time cause if all are negative we need smallest one
        }
        return res;
    }



    public static void main(String[] args) {
        //Example 1:

        int [] energy1 = {5,2,-10,-5,1};
        int k1 = 3;
        int output1= 3;

        //Example 2:

        int [] energy2 = {-2,-3,-1};
        int k2 = 2;
        int output2= -1;

        System.out.println("Brute Force Approch :");

        int ans1 = maximumEnergy(energy1,k1);
        int ans2 = maximumEnergy(energy2,k2);

        System.out.println("Better Force Approch :");

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


        ans1 = maximumEnergyBetter(energy1,k1);
        ans2 = maximumEnergyBetter(energy2,k2);

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
