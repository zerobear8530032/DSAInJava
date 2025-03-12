//1499. Max Value of Equation
//Solved
//Hard
//Topics
//Companies
//Hint
//You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.
//
//Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.
//
//It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.
//
//Example 1:
//
//Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
//Output: 4
//Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
//No other pairs satisfy the condition, so we return the max of 4 and 1.
//Example 2:
//
//Input: points = [[0,0],[3,0],[9,2]], k = 3
//Output: 3
//Explanation: Only the first two points have an absolute difference of 3 or less in the x-values, and give the value of 0 + 0 + |0 - 3| = 3.
// 
//
//Constraints:
//
//2 <= points.length <= 105
//points[i].length == 2
//-108 <= xi, yi <= 108
//0 <= k <= 2 * 108
//xi < xj for all 1 <= i < j <= points.length
//xi form a strictly increasing sequence.


package Arrays;

public class MaxValueofEquation_1499 {
//	brute Force Approhc:
//	we check every pairs of 2 points that satisfy the coondition and find maximum
//	time complexity :O(n*n)
//	space complexity :O(1)
	public static int findMaxValueOfEquation(int[][] points, int k) {
		int max=0;
		for(int i =0;i<points.length-1;i++) {
			for(int j=i+1;j<points.length;j++) {
				if(Math.abs(points[i][0]-points[j][0])<=k) {
					int eq= points[i][1]+ points[j][1]+Math.abs(points[i][0]-points[j][0]);
					max=Math.max(max, eq);
				}
			}
		}
		return max;
    }
	
	public static void main(String[] args) {
		
		//Example 1:
	
		int [][]  points1 = {{1,3},{2,0},{5,10},{6,-10}};
		int k1 = 1;
		int output1=4;

		//Example 2:

		int [][] points2 = {{0,0},{3,0},{9,2}};
		int k2 = 3;
		int output2=3;		
		
		System.out.println("Brute Force :");
		
    	int ans1=findMaxValueOfEquation(points1,k1);
    	int ans2=findMaxValueOfEquation(points2,k2);
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	
		
		
		
		}
	}
