//3000. Maximum Area of Longest Diagonal Rectangle
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 2D 0-indexed integer array dimensions.
//
//For all indices i, 0 <= i < dimensions.length, dimensions[i][0] represents the length and dimensions[i][1] represents the width of the rectangle i.
//
//Return the area of the rectangle having the longest diagonal. If there are multiple rectangles with the longest diagonal, return the area of the rectangle having the maximum area.
//
//
//
//Example 1:
//
//Input: dimensions = [[9,3],[8,6]]
//Output: 48
//Explanation:
//For index = 0, length = 9 and width = 3. Diagonal length = sqrt(9 * 9 + 3 * 3) = sqrt(90) ≈ 9.487.
//For index = 1, length = 8 and width = 6. Diagonal length = sqrt(8 * 8 + 6 * 6) = sqrt(100) = 10.
//So, the rectangle at index 1 has a greater diagonal length therefore we return area = 8 * 6 = 48.
//Example 2:
//
//Input: dimensions = [[3,4],[4,3]]
//Output: 12
//Explanation: Length of diagonal is the same for both which is 5, so maximum area = 12.
//
//
//Constraints:
//
//1 <= dimensions.length <= 100
//dimensions[i].length == 2
//1 <= dimensions[i][0], dimensions[i][1] <= 100

package Arrays;

public class MaximumAreaOfLongestDiagonalRectangle_3000 {

//     approch :
//     iterate over the 2d array get diagonal and update max diagonal
//     and compute the max area as current diagonal area
//    if we encounter a diagonal having same as max diagonal we just update maxarea
//    to max of current diagonal area and previouse diagonal area;
//    time complexity : O(n)
//    space complexity : O(1)
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal=-1;
        int maxArea=-1;
        for(int i =0;i<dimensions.length;i++){
            double diagonal= diagonal(dimensions[i]);
            if(diagonal>maxDiagonal){
                maxDiagonal=diagonal;
                maxArea=area(dimensions[i]);
            }else if(diagonal==maxDiagonal){
                maxArea=Math.max(maxArea,area(dimensions[i]));
            }
        }
        return maxArea;
    }
    public static double diagonal(int [] rect){
        return  Math.sqrt((rect[0]*rect[0])+(rect[1]*rect[1]));
    }
    public static  int area(int [] rect){
        return rect[0]*rect[1];
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] dimensions1 = {{9,3},{8,6}};
        int output1=48;

        //Example 2:

        int [][] dimensions2 = {{3,4},{4,3}};
        int output2=12;

        int ans1= areaOfMaxDiagonal(dimensions1);
        int ans2= areaOfMaxDiagonal(dimensions2);

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
