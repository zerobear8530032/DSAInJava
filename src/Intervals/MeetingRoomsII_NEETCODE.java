//Meeting Rooms II
//Medium
//Topics
//Company Tags
//Hints
//Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of rooms required to schedule all meetings without any conflicts.
//
//Note: (0,8),(8,10) is NOT considered a conflict at 8.
//
//Example 1:
//
//Input: intervals = [(0,40),(5,10),(15,20)]
//
//Output: 2
//Explanation:
//room1: (0,40)
//room2: (5,10),(15,20)
//
//Example 2:
//
//Input: intervals = [(4,9)]
//
//Output: 1
//Constraints:
//
//0 <= intervals.length <= 100,000
package Intervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Interval{
    int start;
    int end;
    public Interval (int start, int end){
        this.start=start;
        this.end=end;
    }
}
public class MeetingRoomsII_NEETCODE {
    // approch : here we use a priority queue as min heap
//    sort the intervals by start time and add check if current queue is empty we assign the it to queue
//    if queue top is smaller then or equal to current interval start time we pop top and insert the curr interval end time
//    at the end we will have size of queue as our answer
    //    time complexity : O(N log N)
    //    space complexity : O(N)
    public static int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Collections.sort(intervals,(i1, i2)-> i1.start-i2.start);
        for(Interval interval:intervals){
            if(queue.isEmpty()){
                queue.add(interval.end);
            }else{
                if(queue.peek()<=interval.start){
                    queue.poll();
                }
                queue.add(interval.end);
            }
        }
        return queue.size();
    }
    public static void main(String[] args) {
        //Example 1:

        List<Interval> intervals1 = Arrays.asList(new Interval(0,40),new Interval(5,10),new Interval(15,20));
        int output1= 2;

        //Example 2:

        List<Interval>  intervals2 =Arrays.asList(new Interval(4,9));
        int output2= 1;

        int ans1= minMeetingRooms(intervals1);
        int ans2= minMeetingRooms(intervals2);

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
