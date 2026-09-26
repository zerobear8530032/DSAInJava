//Merge Intervals
//Medium
//Topics
//Company Tags
//Hints
//Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//You may return the answer in any order.
//
//Note: Intervals are non-overlapping if they have no common point. For example, [1, 2] and [3, 4] are non-overlapping, but [1, 2] and [2, 3] are overlapping.
//
//Example 1:
//
//Input: intervals = [[1,3],[1,5],[6,7]]
//
//Output: [[1,5],[6,7]]
//Example 2:
//
//Input: intervals = [[1,2],[2,3]]
//
//Output: [[1,3]]
//Constraints:
//
//1 <= intervals.length <= 1000
//intervals[i].length == 2
//0 <= start <= end <= 1000
package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {
//    approch:
//    first we sort the intervals by starting time
//    then we can take current intervals and check is it over lapping
//    if yes we merge it other wise we will create a new interval in the list
//    at end we convert it to array and return answewr
//    time complexity : O(n * log n)
//    space complexity : O(n)
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2)-> i1[0]-i2[0]);
        List<int []> res= new ArrayList<>();
        for(int i =0;i<intervals.length;i++){
            if(res.isEmpty()){
                res.add(new  int []{intervals[i][0],intervals[i][1]});
            }else{
                int [] lastInterval = res.getLast();
                if(lastInterval[1]>=intervals[i][0] && lastInterval[1]<=intervals[i][1]){
                    lastInterval[1]= intervals[i][1];
                }else if(lastInterval[1]<intervals[i][0]){
                    res.add(intervals[i]);
                }
            }
        }
        int [][] output = new int [res.size()][2];
        int idx=0;
        for(int [] interval : res){
            output[idx++]=interval;
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

        int [][] intervals1 = {{1,3},{1,5},{6,7}};
        int [][] output1= {{1,5},{6,7}};

        //Example 2:

        int [][] intervals2 = {{1,2},{2,3}};
        int [][] output2= {{1,3}};

        int [][] ans1= merge(intervals1);
        int [][] ans2= merge(intervals2);
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
