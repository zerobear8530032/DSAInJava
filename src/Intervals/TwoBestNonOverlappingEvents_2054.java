//2054. Two Best Non-Overlapping Events
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.
//
//Return this maximum sum.
//
//Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.
//
//
//
//Example 1:
//
//
//Input: events = [[1,3,2],[4,5,2],[2,4,3]]
//Output: 4
//Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
//Example 2:
//
//Example 1 Diagram
//Input: events = [[1,3,2],[4,5,2],[1,5,5]]
//Output: 5
//Explanation: Choose event 2 for a sum of 5.
//Example 3:
//
//
//Input: events = [[1,5,3],[1,5,1],[6,6,5]]
//Output: 8
//Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8.
//
//
//Constraints:
//
//2 <= events.length <= 105
//events[i].length == 3
//1 <= startTimei <= endTimei <= 109
//1 <= valuei <= 106
package Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class TwoBestNonOverlappingEvents_2054 {
// approch :
// we can use tak not take approc where we first sort the intervals by starting time and
//    then from each interval we try to find next closest inteval we can choose
//    compute result and get max one
//    time complexity : N log n
//    space complexity : N
    public static int maxTwoEvents(int[][] events) {
        Integer [][] memo= new Integer[events.length+1][3];
        Arrays.sort(events, new Comparator<int []>(){
            public int compare(int [] e1, int [] e2){
                return e1[0]-e2[0];
            }
        });
        int res=0;
        return helper(0,events,0,memo);
    }

    public static int helper(int i, int [][] events, int attended, Integer [][] memo){
        if(attended==2 || i>=events.length){
            return 0;
        }
        if(memo[i][attended]!=null){
            return memo[i][attended];
        }
        int nextValidValue = binarySearch(i+1,events.length-1,events,events[i][1]);
        int take = helper(nextValidValue,events,attended+1,memo)+events[i][2];
        int skip = helper(i+1,events,attended,memo);
        memo[i][attended]=Math.max(take,skip);
        return memo[i][attended];
    }
    public static int binarySearch(int start,int end, int [][] events, int endTime){
        int res=Integer.MAX_VALUE;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(endTime<events[mid][0]){
                res=Math.min(res,mid);
                end=mid-1;
            }else if(endTime>=events[mid][0]){
                start=mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] events1 = {{1,3,2},{4,5,2},{2,4,3}};
        int output1= 4;

        //Example 2:

        int [][] events2 = {{1,3,2},{4,5,2},{1,5,5}};
        int output2= 5;

        //Example 3:

        int [][] events3 = {{1,5,3},{1,5,1},{6,6,5}};
        int output3= 8;

        int ans1 = maxTwoEvents(events1);
        int ans2 = maxTwoEvents(events2);
        int ans3 = maxTwoEvents(events3);
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
