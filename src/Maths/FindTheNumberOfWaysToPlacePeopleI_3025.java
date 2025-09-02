//3025. Find the Number of Ways to Place People I
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 2D array points of size n x 2 representing integer coordinates of some points on a 2D plane, where points[i] = [xi, yi].
//
//Count the number of pairs of points (A, B), where
//
//A is on the upper left side of B, and
//there are no other points in the rectangle (or line) they make (including the border).
//Return the count.
//
//
//
//Example 1:
//
//Input: points = [[1,1],[2,2],[3,3]]
//
//Output: 0
//
//Explanation:
//
//
//
//There is no way to choose A and B so A is on the upper left side of B.
//
//Example 2:
//
//Input: points = [[6,2],[4,4],[2,6]]
//
//Output: 2
//
//Explanation:
//
//
//
//The left one is the pair (points[1], points[0]), where points[1] is on the upper left side of points[0] and the rectangle is empty.
//The middle one is the pair (points[2], points[1]), same as the left one it is a valid pair.
//The right one is the pair (points[2], points[0]), where points[2] is on the upper left side of points[0], but points[1] is inside the rectangle so it's not a valid pair.
//Example 3:
//
//Input: points = [[3,1],[1,3],[1,1]]
//
//Output: 2
//
//Explanation:
//
//
//
//The left one is the pair (points[2], points[0]), where points[2] is on the upper left side of points[0] and there are no other points on the line they form. Note that it is a valid state when the two points form a line.
//The middle one is the pair (points[1], points[2]), it is a valid pair same as the left one.
//The right one is the pair (points[1], points[0]), it is not a valid pair as points[2] is on the border of the rectangle.
//
//
//Constraints:
//
//2 <= n <= 50
//points[i].length == 2
//0 <= points[i][0], points[i][1] <= 50
//All points[i] are distinct.

package Maths;

import java.util.*;

public class FindTheNumberOfWaysToPlacePeopleI_3025 {
//    Brute Force Approch :
//    check every pair of possible rectangle we can create
//    we can keep track of that using hashmap
//    where key is index of point A and values is a list of points B
//    we can then just check the second condition does the points
//    present in btw A, B in O(n) time
//    time complexity : O(n*n*n)
//    space complexity : O(1)
public static int numberOfPairs(int[][] points) {
    int count =0;
    for(int i  =0;i<points.length;i++){
        for(int j=0;j<points.length;j++){
            if(i==j){continue;}
            int [] A= points[i];
            int [] B = points[j];
            if(A[0]<=B[0] && A[1]>=B[1]){
                if(checkContainsPoint(points, A,B)){
                    count++;
                }
            }
        }
    }
    return count;
}


    public static boolean checkContainsPoint(int [][] points,int [] A, int [] B){
        for(int [] P:points){
            if(P==A || P==B){// skip the a , b
                continue;
            }
            if(A[0]<=P[0] && B[0]>=P[0] && A[1]>=P[1] && B[1]<=P[1]){
                return false;
            }
        }
        return true;
    }


//
    public static int numberOfPairsBetter(int[][] points) {
        int count =0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });

        for(int i  =0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                if(i==j){continue;}
                int [] A= points[i];
                int [] B = points[j];
                if(A[0]<=B[0] && A[1]>=B[1]){
                    if(checkContainsPoint(points, A,B)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        //Example 1:

        int [][] points1 = {{1,1},{2,2},{3,3}};
        int  output1=0;

        //Example 2:

        int [][] points2 = {{6,2},{4,4},{2,6}};
        int  output2=2;

        //Example 3:

        int [][] points3 = {{3,1},{1,3},{1,1}};
        int  output3=2;


        int ans1= numberOfPairs(points1);
        int ans2= numberOfPairs(points2);
        int ans3= numberOfPairs(points3);

        if(output1== ans1) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output : "+output1);
            System.out.println("Your Output : "+ans1);
        }
        if(output2== ans2) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output : "+output2);
            System.out.println("Your Output : "+ans2);
        }
        if(output3== ans3) {
            System.out.println("Case 3 Passed ");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output : "+output3);
            System.out.println("Your Output : "+ans3);
        }

        System.out.println("Better Approch ");

        ans1= numberOfPairsBetter(points1);
        ans2= numberOfPairsBetter(points2);
        ans3= numberOfPairsBetter(points3);

        if(output1== ans1) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output : "+output1);
            System.out.println("Your Output : "+ans1);
        }
        if(output2== ans2) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output : "+output2);
            System.out.println("Your Output : "+ans2);
        }
        if(output3== ans3) {
            System.out.println("Case 3 Passed ");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output : "+output3);
            System.out.println("Your Output : "+ans3);
        }



    }
}
