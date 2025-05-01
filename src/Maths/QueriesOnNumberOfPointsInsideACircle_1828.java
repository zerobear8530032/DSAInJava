//1828. Queries on Number of Points Inside a Circle
//Medium
//Topics
//Companies
//Hint
//You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.
//
//You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.
//
//For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.
//
//Return an array answer, where answer[j] is the answer to the jth query.
//
// 
//
//Example 1:
//
//
//Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
//Output: [3,2,2]
//Explanation: The points and circles are shown above.
//queries[0] is the green circle, queries[1] is the red circle, and queries[2] is the blue circle.
//Example 2:
//
//
//Input: points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
//Output: [2,3,2,4]
//Explanation: The points and circles are shown above.
//queries[0] is green, queries[1] is red, queries[2] is blue, and queries[3] is purple.
// 
//
//Constraints:
//
//1 <= points.length <= 500
//points[i].length == 2
//0 <= x​​​​​​i, y​​​​​​i <= 500
//1 <= queries.length <= 500
//queries[j].length == 3
//0 <= xj, yj <= 500
//1 <= rj <= 500
//All coordinates are integers.
// 
//
//Follow up: Could you find the answer for each query in better complexity than O(n)?

package Maths;

import java.util.Arrays;

public class QueriesOnNumberOfPointsInsideACircle_1828 {
//	brute force approch : find euclidian distnace btw each circle center and point
//	if its smaller then its radius it is in circle;
	
//	time complexity : O(p*q)
//	space complexity :O(M): output array 
	
	    public static int[] countPoints(int[][] points, int[][] queries) {
	        int []ans = new int [queries.length];
	        for(int i =0;i<queries.length;i++){
	            int[] circle=queries[i];
	            int counter=0;
	            for(int j=0;j<points.length;j++){
	                int []point=points[j];
	                if(isInsideCircle(point,circle)){
	                    counter++;
	                }
	            }
	            ans[i]=counter;
	        }
	        return ans;
	    }
	    public static boolean isInsideCircle(int [] points , int []circle){
	    	int x1= circle[0];
	    	int x2=points[0];
	    	int y1= circle[1];
	    	int y2=points[1];
	    	int radius= circle[2];
	    	double euclidiandistance = Math.sqrt(Math.pow((x2-x1),2)+Math.pow(y2-y1,2));
	    	return euclidiandistance<=radius;
	    }
	
	public static void main(String[] args) {
		
		
		//Example 1:

		int [][]points1 = {{1,3},{3,3},{5,3},{2,2}}, queries1 = {{2,3,1},{4,3,1},{1,1,2}};
		int [] output1= {3,2,2};

		//Example 2:

		int [][]points2 = {{1,1},{2,2},{3,3},{4,4},{5,5}}, queries2 = {{1,2,2},{2,2,2},{4,3,2},{4,3,3}};
		int [] output2= {2,3,2,4};
		
		System.out.println("Brute Force Approch :");
		
		int [] ans1=countPoints(points1,queries1);
		int [] ans2=countPoints(points2,queries2);
		
		if(Arrays.equals(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output1));
			System.out.println("Your Answer :"+ Arrays.toString(ans1));
		}
		if(Arrays.equals(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ Arrays.toString(output2));
			System.out.println("Your Answer :"+ Arrays.toString(ans2));
		}


	}

}
