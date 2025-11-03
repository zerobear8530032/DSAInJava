//1578. Minimum Time to Make Rope Colorful
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
//
//Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.
//
//Return the minimum time Bob needs to make the rope colorful.
//
//
//
//Example 1:
//
//
//Input: colors = "abaac", neededTime = [1,2,3,4,5]
//Output: 3
//Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
//Bob can remove the blue balloon at index 2. This takes 3 seconds.
//There are no longer two consecutive balloons of the same color. Total time = 3.
//Example 2:
//
//
//Input: colors = "abc", neededTime = [1,2,3]
//Output: 0
//Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.
//Example 3:
//
//
//Input: colors = "aabaa", neededTime = [1,2,3,4,1]
//Output: 2
//Explanation: Bob will remove the balloons at indices 0 and 4. Each balloons takes 1 second to remove.
//There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
//
//
//Constraints:
//
//n == colors.length == neededTime.length
//1 <= n <= 105
//1 <= neededTime[i] <= 104
//colors contains only lowercase English letters.
package Greedy;

import java.util.PriorityQueue;

public class MinimumTimeToMakeRopeColorful_1578 {

//     approch : we can see one thing we have to remove all consicutive same color baloons
//    and then we have to remove those in such a way that all balloons will removal will cost minimun
//    so we can simiply put every consicutive ballon cost which we can remove in a priority queue
//    and remove it form queue and add to res untill there is a single cost left cause that the max cost of ballon to be removed
//    time complexity : O(n + k log k)
//    space complexity : O(n)
    public static int minCostBruteForce(String colors, int[] neededTime) {
        int i=0;
        int res=0;
        PriorityQueue<Integer> queue = new PriorityQueue();
        while(i<colors.length()-1){
            queue.add(neededTime[i]);
            while(i+1< neededTime.length && colors.charAt(i)==colors.charAt(i+1)){
                queue.add(neededTime[i+1]);
                i++;
            }
            while(queue.size()!=1){
                res+=queue.poll();
            }
            queue.poll() ;// after calculating res we can remove last cost to empty the queue
            i++;
        }
        return res;
    }
// approch :
//    from above solution we have to remove all consicutive ballons whcih have smaller cost
//    so we can thing it in a reverse way at the end we always left with a single balloon
//    what we can do it just all cost of all ballons we can remove and track max cost then we can find our removal
//    by total-max cost that means we will left the highest cost one except all will be removed \
//    time complexity : O(n) // here we does not need anydata structure
//    space complexity : O(1)
    public  static int minCostBest(String colors, int[] neededTime) {
        int i=0;
        int res=0;
        while(i<colors.length()-1){
            int max= neededTime[i];
            int totalTime=  neededTime[i];
            boolean consicutive= false;
            while(i+1< neededTime.length && colors.charAt(i)==colors.charAt(i+1)){
                max= Math.max(max,neededTime[i+1]);
                totalTime+=  neededTime[i+1];
                i++;
            }
            res+=(totalTime-max);
            i++;
        }
        return res;
    }


    public static void main(String[] args) {
        //Example 1:

        String colors1 = "abaac";
        int [] neededTime1 = {1,2,3,4,5};
        int output1= 3;

        //Example 2:

        String colors2 = "abc";
        int [] neededTime2 = {1,2,3};
        int output2= 0;

        //Example 3:

        String colors3 = "aabaa";
        int [] neededTime3 = {1,2,3,4,1};
        int output3= 2;
        System.out.println("Brute Force Approch :");

        int ans1 = minCostBruteForce(colors1,neededTime1);
        int ans2 = minCostBruteForce(colors2,neededTime2);
        int ans3 = minCostBruteForce(colors3,neededTime3);

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

        System.out.println("Best Approch :");
        ans1 = minCostBruteForce(colors1,neededTime1);
        ans2 = minCostBruteForce(colors2,neededTime2);
        ans3 = minCostBruteForce(colors3,neededTime3);

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
