//1288. Remove Covered Intervals
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.
//
//The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
//
//Return the number of remaining intervals.
//
//
//
//Example 1:
//
//Input: intervals = [[1,4],[3,6],[2,8]]
//Output: 2
//Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
//Example 2:
//
//Input: intervals = [[1,4],[2,3]]
//Output: 1
//
//
//Constraints:
//
//1 <= intervals.length <= 1000
//intervals[i].length == 2
//0 <= li < ri <= 105
//All the given intervals are unique.
package Intervals;

import java.util.Arrays;

public class RemoveCoveredIntervals_1288 {
//    approch : here we sort the intervals by starting time
//    if the starting time is equal we sort it descending by ending time
//    by sorting like this we can see all early starting intervals and lter ending intervals are on left side
//    so we can take time first interval and check it is in btw the next interval
//    because we sort by arrival time we know already the previous intervals started before them
//    so we only check its ending before our current maxend if yes we have cover interval
//    if not we can say this is the interval which remain in our answer
//    and we can update the end with the current interval
//    time complexity : O(N log n)
//    space complexity : O(1)
    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(t1, t2)-> {
            if(t1[0]==t2[0]){
                return t2[1]-t1[1];
            }
            return t1[0]-t2[0];
        });
        int count=0;
        int max=0;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][1]>max){
                count++;
                max=intervals[i][1];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] intervals1 = {{1,4},{3,6},{2,8}};
        int output1= 2;

        //Example 2:

        int [][] intervals2 = {{1,4},{2,3}};
        int output2= 2;

        int ans1= removeCoveredIntervals(intervals1);
        int ans2= removeCoveredIntervals(intervals2);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }


    }
}
