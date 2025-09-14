//3683. Earliest Time to Finish One Task
//Solved
//Easy
//premium lock icon
//Companies
//Hint
//You are given a 2D integer array tasks where tasks[i] = [si, ti].
//
//Each [si, ti] in tasks represents a task with start time si that takes ti units of time to finish.
//
//Return the earliest time at which at least one task is finished.
//
//
//
//Example 1:
//
//Input: tasks = [[1,6],[2,3]]
//
//Output: 5
//
//Explanation:
//
//The first task starts at time t = 1 and finishes at time 1 + 6 = 7. The second task finishes at time 2 + 3 = 5. You can finish one task at time 5.
//
//Example 2:
//
//Input: tasks = [[100,100],[100,100],[100,100]]
//
//Output: 200
//
//Explanation:
//
//All three tasks finish at time 100 + 100 = 200.
//
//
//
//Constraints:
//
//1 <= tasks.length <= 100
//tasks[i] = [si, ti]
//1 <= si, ti <= 100

package Arrays;

public class EarliestTimeToFinishOneTask_3683 {
    public static int earliestTime(int[][] tasks) {
        int minTime=Integer.MAX_VALUE;
        for(int [] task:tasks){
            int time= task[0]+task[1];
            minTime=Math.min(minTime,time);
        }
        return minTime;
    }

    public static void main(String[] args) {
        //Example 1:

        int [][] tasks1 = {{1,6},{2,3}};
        int output1=5;

        //Example 2:

        int [][] tasks2 = {{100,100},{100,100},{100,100}};
        int output2=200;


        int ans1=earliestTime(tasks1);
        int ans2=earliestTime(tasks2);

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
