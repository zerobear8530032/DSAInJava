//1039. Minimum Score Triangulation of Polygon
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You have a convex n-sided polygon where each vertex has an integer value. You are given an integer array values where values[i] is the value of the ith vertex in clockwise order.
//
//Polygon triangulation is a process where you divide a polygon into a set of triangles and the vertices of each triangle must also be vertices of the original polygon. Note that no other shapes other than triangles are allowed in the division. This process will result in n - 2 triangles.
//
//You will triangulate the polygon. For each triangle, the weight of that triangle is the product of the values at its vertices. The total score of the triangulation is the sum of these weights over all n - 2 triangles.
//
//Return the minimum possible score that you can achieve with some triangulation of the polygon.
//
//
//
//Example 1:
//
//
//
//Input: values = [1,2,3]
//
//Output: 6
//
//Explanation: The polygon is already triangulated, and the score of the only triangle is 6.
//
//Example 2:
//
//
//
//Input: values = [3,7,4,5]
//
//Output: 144
//
//Explanation: There are two triangulations, with possible scores: 3*7*5 + 4*5*7 = 245, or 3*4*5 + 3*4*7 = 144.
//The minimum score is 144.
//
//Example 3:
//
//
//
//Input: values = [1,3,1,4,1,5]
//
//Output: 13
//
//Explanation: The minimum score triangulation is 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13.
//
//
//
//Constraints:
//
//n == values.length
//3 <= n <= 50
//1 <= values[i] <= 100
package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumScoreTriangulationOfPolygon_1039 {
    public static int minScoreTriangulation(int[] values) {
        HashMap<String, Integer> memo= new HashMap<>();
        return helper(values, 0 , values.length-1, memo);
    }
    public static int helper(int [] values, int left, int right, HashMap<String, Integer> memo){
        String key = left+","+right;
        if(memo.containsKey(key)){
            return  memo.get(key);
        }
        if(right-left+1<3){
            return 0;
        }
        int min =Integer.MAX_VALUE;
        for(int mid = left+1 ;mid<right;mid++){
            int score= (values[left]*values[right]*values[mid])+helper(values,left,mid,memo)+helper(values,mid,right,memo);
            min= Math.min(score,min);
        }
        memo.put(key,min);
        return min;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] values1 = {1,2,3};
        int output1=6;

        //Example 2:

        int [] values2 = {3,7,4,5};
        int output2=144;

        //Example 3:

        int [] values3 = {1,3,1,4,1,5};
        int output3=13;

        System.out.println(minScoreTriangulation(values1));
        System.out.println(minScoreTriangulation(values2));
        System.out.println(minScoreTriangulation(values3));
    }
}
