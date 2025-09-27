//812. Largest Triangle Area
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.
//
//
//
//Example 1:
//
//
//Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//Output: 2.00000
//Explanation: The five points are shown in the above figure. The red triangle is the largest.
//Example 2:
//
//Input: points = [[1,0],[0,0],[0,1]]
//Output: 0.50000
//
//
//Constraints:
//
//3 <= points.length <= 50
//-50 <= xi, yi <= 50
//All the given points are unique.
package Maths;

public class LargestTriangleArea_812 {
//     apply the formula find maximum
//    the  formula will give 0 for invalid triangle
//    time complexity : O(n^3)
//    space complexity : O(1)
    public static double largestTriangleArea(int[][] points) {
        double max= Double.MIN_VALUE;
        for(int i =0;i<points.length-2;i++){
            for(int j=i+1;j<points.length-1;j++){
                for(int k=j+1;k<points.length;k++){
                    double []p1={ points[i][0],points[i][1]};
                    double []p2={ points[j][0],points[j][1]};
                    double []p3={ points[k][0],points[k][1]};
                    // ½ |x₁(y₂ - y₃) + x₂(y₃ - y₁) + x₃(y₁ - y₂)|.
                    double area=Math.abs( 0.5 *(p1[0]*(p2[1]-p3[1]) + p2[0]*(p3[1]-p1[1]) + p3[0]*(p1[1]-p2[1])));
                    max= Math.max(area,max);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] points1 = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        double output1=2.00000;

        //Example 2:

        int [][] points2 = {{1,0},{0,0},{0,1}};
        double output2=0.50000;

        double ans1= largestTriangleArea(points1);
        double ans2= largestTriangleArea(points2);

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
