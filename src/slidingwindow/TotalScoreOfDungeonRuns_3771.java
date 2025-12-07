//3771. Total Score of Dungeon Runs
//Attempted
//Medium
//premium lock icon
//Companies
//Hint
//You are given a positive integer hp and two positive 1-indexed integer arrays damage and requirement.
//
//There is a dungeon with n trap rooms numbered from 1 to n. Entering room i reduces your health points by damage[i]. After that reduction, if your remaining health points are at least requirement[i], you earn 1 point for that room.
//
//Let score(j) be the number of points you get if you start with hp health points and enter the rooms j, j + 1, ..., n in this order.
//
//Return the integer score(1) + score(2) + ... + score(n), the sum of scores over all starting rooms.
//
//Note: You cannot skip rooms. You can finish your journey even if your health points become non-positive.
//
//
//
//Example 1:
//
//Input: hp = 11, damage = [3,6,7], requirement = [4,2,5]
//
//Output: 3
//
//Explanation:
//
//score(1) = 2, score(2) = 1, score(3) = 0. The total score is 2 + 1 + 0 = 3.
//
//As an example, score(1) = 2 because you get 2 points if you start from room 1.
//
//You start with 11 health points.
//Enter room 1. Your health points are now 11 - 3 = 8. You get 1 point because 8 >= 4.
//Enter room 2. Your health points are now 8 - 6 = 2. You get 1 point because 2 >= 2.
//Enter room 3. Your health points are now 2 - 7 = -5. You do not get any points because -5 < 5.
//Example 2:
//
//Input: hp = 2, damage = [10000,1], requirement = [1,1]
//
//Output: 1
//
//Explanation:
//
//score(1) = 0, score(2) = 1. The total score is 0 + 1 = 1.
//
//score(1) = 0 because you do not get any points if you start from room 1.
//
//You start with 2 health points.
//Enter room 1. Your health points are now 2 - 10000 = -9998. You do not get any points because -9998 < 1.
//Enter room 2. Your health points are now -9998 - 1 = -9999. You do not get any points because -9999 < 1.
//score(2) = 1 because you get 1 point if you start from room 2.
//
//You start with 2 health points.
//Enter room 2. Your health points are now 2 - 1 = 1. You get 1 point because 1 >= 1.
//
//
//Constraints:
//
//1 <= hp <= 109
//1 <= n == damage.length == requirement.length <= 105
//1 <= damage[i], requirement[i] <= 104
package slidingwindow;

class TotalScoreOfDungeonRuns_3771 {
    public static long totalScore(int hp, int[] damage, int[] requirement) {
        long res=0;
        for(int start=0;start<damage.length;start++){
            int health = hp;
            for(int j=start;j<damage.length;j++){
                health -= damage[j];
                if(health>=requirement[j]){
                    res++;
                }else if(health<=0){
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //Example 1:

        int  hp1 = 11;
        int [] damage1 = {3,6,7}, requirement1 = {4,2,5};
        int output1= 3;

        //Example 2:

        int  hp2 = 3;
        int [] damage2 = {10000,1}, requirement2 = {1,1};
        int output2= 1;

        long ans1 = totalScore(hp1,damage1,requirement1);
        long ans2 = totalScore(hp2,damage2,requirement2);

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