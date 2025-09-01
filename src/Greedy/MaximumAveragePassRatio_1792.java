//1792. Maximum Average Pass Ratio
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.
//
//You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.
//
//The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.
//
//Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.
//
//
//
//Example 1:
//
//Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
//Output: 0.78333
//Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
//Example 2:
//
//Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
//Output: 0.53485
//
//
//Constraints:
//
//1 <= classes.length <= 105
//classes[i].length == 2
//1 <= passi <= totali <= 105
//1 <= extraStudents <= 105
package Greedy;

import java.util.PriorityQueue;

public class MaximumAveragePassRatio_1792 {
//    approch : here we will try to get gain of each class using fornula
//    (pass+1/total+1) -(pass/total) for a single student
//    now we can store all the entry with its value and gain
//    and store in maxheap with respect to gain
//    now we will get top element and give it the student by incrementing the pass,total
//    then we recompute its gain and push it back to the maxheap
//    we repeat it extra students number of time and
//    at the end all students will be at some class
//    now we will just pop every class calculate avg and return it
//    time complexity : O(n)
//    space complexity : O(n)

     static class Entry implements Comparable<Entry>{
        double gains;
        double pass;
        double total;

        @Override
        public int compareTo(Entry o2){
            return Double.compare(o2.gains,this.gains);
        }

        public Entry(double pass, double total, double gains) {
            this.gains = gains;
            this.pass = pass;
            this.total = total;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "gains=" + gains +
                    ", pass=" + pass +
                    ", fail=" + total +
                    '}';
        }

        public double avg(){
            return pass/ total;
        }
    }
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Entry> maxheap = new PriorityQueue<>();
        for(int [] clazz:classes){
            double pass = clazz[0];
            double total = clazz[1];
            double gain = getGain(pass,total);
            Entry  e= new Entry(pass,total,gain);
            maxheap.add(e);
        }
        for(int i =0;i<extraStudents;i++){
            Entry maxGainClass = maxheap.poll();
            maxGainClass.pass++;
            maxGainClass.total++;
            double gain= getGain(maxGainClass.pass,maxGainClass.total);
            maxGainClass.gains=gain;
            maxheap.add(maxGainClass);
        }
        double TotalClassAvgSum=0;
        while(!maxheap.isEmpty()){
            Entry e = maxheap.poll();
            TotalClassAvgSum+= (e.pass/e.total);
        }
        return TotalClassAvgSum/classes.length;
    }

    public static double getGain(double pass,double total){
        return ((pass+1)/(total+1))-(pass/total);
    }


    public static void main(String[] args) {
        //Example 1:

        int [][] classes1 = {{1,2},{3,5},{2,2}};
        int extraStudents1 = 2;
        double output1=0.78333;

        //Example 2:


        int [][] classes2 = {{2,4},{3,9},{4,5},{2,10}};
        int extraStudents2 = 4;
        double output2=0.53485;

        System.out.println(maxAverageRatio(classes1,extraStudents1));
        System.out.println(maxAverageRatio(classes2,extraStudents2));
    }
}
