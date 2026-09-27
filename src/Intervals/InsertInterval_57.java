//57. Insert Interval
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//Two intervals are considered overlapping if they share at least one point.
//
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.
//
//Note that you don't need to modify intervals in-place. You can make a new array and return it.
//
//
//
//Example 1:
//
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
//Example 2:
//
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
//
//
//Constraints:
//
//0 <= intervals.length <= 104
//intervals[i].length == 2
//0 <= starti <= endi <= 105
//intervals is sorted by starti in ascending order.
//newInterval.length == 2
//0 <= start <= end <= 105
package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval_57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> listIntervals = new ArrayList<>();
        boolean inserted= false;
        for(int i =0;i<intervals.length;i++){
            if(intervals[i][0]<newInterval[0]){
                listIntervals.add(intervals[i]);
            }else if(intervals[i][0]>=newInterval[0] && !inserted){
                listIntervals.add(newInterval);
                listIntervals.add(intervals[i]);
                inserted=true;
            }else{
                listIntervals.add(intervals[i]);
            }
        }
        if(!inserted){
            listIntervals.add(newInterval);
        }
        List<int []> mergedIntervals= new ArrayList<>();
        for(int [] interval:listIntervals){
            if(mergedIntervals.isEmpty()){
                mergedIntervals.add(interval);
            }else{
                int [] lastInterval = mergedIntervals.getLast();
                if(lastInterval[1]>=interval[0]){
                    lastInterval[1]= Math.max(lastInterval[1],interval[1]);
                }else{
                    mergedIntervals.add(interval);
                }
            }
        }
        int [][] output=new int[mergedIntervals.size()][2];
        for(int i=0;i<output.length;i++){
            output[i]= mergedIntervals.get(i);
        }
        return output;
    }

    public static String printMatrix(int [][]img) {

        StringBuilder str = new StringBuilder("[");
        for(int i =0;i<img.length;i++) {
            str.append(Arrays.toString(img[i]));
        }
        str.append("]");
        return str.toString();
    }

    public static boolean check(int [][] ans,int [][] output) {
        if(ans.length!=output.length  || ans[0].length != output[0].length) {
            return false;
        }
        for(int i =0;i<ans.length;i++) {
            for(int j=0;j<ans[i].length;j++) {
                if(ans[i][j]!=output[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
        //Example 1:

        int [][] intervals1 = {{1,3},{6,9}};
        int [] newInterval1 = {2,5};
        int [][] output1= {{1,5},{6,9}};

        //Example 2:

        int [][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int [] newInterval2 = {4,8};
        int [][] output2= {{1,2},{3,10},{12,16}};

        int [][] ans1= insert(intervals1,newInterval1 );
        int [][] ans2= insert(intervals2,newInterval2 );

        if(check(output1, ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ printMatrix(output1));
            System.out.println("Your Answer :"+ printMatrix(ans1));
        }
        if(check(output2, ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ printMatrix(output2));
            System.out.println("Your Answer :"+ printMatrix(ans2) );
        }

    }
}
