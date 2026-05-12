//1665. Minimum Initial Energy to Finish Tasks
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array tasks where tasks[i] = [actuali, minimumi]:
//
//actuali is the actual amount of energy you spend to finish the ith task.
//minimumi is the minimum amount of energy you require to begin the ith task.
//For example, if the task is [10, 12] and your current energy is 11, you cannot start this task. However, if your current energy is 13, you can complete this task, and your energy will be 3 after finishing it.
//
//You can finish the tasks in any order you like.
//
//Return the minimum initial amount of energy you will need to finish all the tasks.
//
//
//
//Example 1:
//
//Input: tasks = [[1,2],[2,4],[4,8]]
//Output: 8
//Explanation:
//Starting with 8 energy, we finish the tasks in the following order:
//    - 3rd task. Now energy = 8 - 4 = 4.
//    - 2nd task. Now energy = 4 - 2 = 2.
//    - 1st task. Now energy = 2 - 1 = 1.
//Notice that even though we have leftover energy, starting with 7 energy does not work because we cannot do the 3rd task.
//Example 2:
//
//Input: tasks = [[1,3],[2,4],[10,11],[10,12],[8,9]]
//Output: 32
//Explanation:
//Starting with 32 energy, we finish the tasks in the following order:
//    - 1st task. Now energy = 32 - 1 = 31.
//    - 2nd task. Now energy = 31 - 2 = 29.
//    - 3rd task. Now energy = 29 - 10 = 19.
//    - 4th task. Now energy = 19 - 10 = 9.
//    - 5th task. Now energy = 9 - 8 = 1.
//Example 3:
//
//Input: tasks = [[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]]
//Output: 27
//Explanation:
//Starting with 27 energy, we finish the tasks in the following order:
//    - 5th task. Now energy = 27 - 5 = 22.
//    - 2nd task. Now energy = 22 - 2 = 20.
//    - 3rd task. Now energy = 20 - 3 = 17.
//    - 1st task. Now energy = 17 - 1 = 16.
//    - 4th task. Now energy = 16 - 4 = 12.
//    - 6th task. Now energy = 12 - 6 = 6.
//
//
//Constraints:
//
//1 <= tasks.length <= 105
//1 <= actual​i <= minimumi <= 104
package Greedy;

import java.util.Arrays;

public class MinimumInitialEnergyToFinishTasks_1665 {
    public static int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(t1, t2)-> (t2[1]-t2[0])-(t1[1]-t1[0]));
        int s=0;
        int e= 0;
        for(int [] task:tasks){
            s+= task[0];
            e+= task[1];
        }
        int res=Integer.MAX_VALUE;
        while(s<=e){
            int mid = s+(e-s)/2;
            // System.out.println(s+" "+mid+" "+e);
            if(canCompleteAllTasks(tasks,mid)){
                // System.out.println("can do");
                res=Math.min(res,mid);
                e=mid-1;
            }else{
                // System.out.println("cannot do");
                s=mid+1;
            }
        }
        return res;
    }

    public static boolean canCompleteAllTasks(int [][] tasks , int energy){
        for(int [] task:tasks){
            if(task[1]<=energy){
                energy-=task[0];
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //Example 1:

        int [][] tasks1 = {{1,2},{2,4},{4,8}};
        int output1= 8;

        //Example 2:

        int [][] tasks2 = {{1,3},{2,4},{10,11},{10,12},{8,9}};
        int output2= 32;

        //Example 3:

        int [][] tasks3 = {{1,7},{2,8},{3,9},{4,10},{5,11},{6,12}};
        int output3= 27;

        int ans1 = minimumEffort(tasks1);
        int ans2 = minimumEffort(tasks2);
        int ans3 = minimumEffort(tasks3);

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
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }

    }
}
